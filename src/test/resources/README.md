
Test Data
=========

The files here are used for testing purposes.

example.txt
example.txt.asc
example.txt.gpg

The first file is some plain text (the opening paragraph of "Moby Dick"). The .gpg file is the
OpenPGP output created by GnuPG version 2.2.17 (using libgcrypt 1.8.4). This file is
symmetrically encrypted using the default encryption algorithm selected by GPG. The passphrase
is "Hello, World!" (no quotes). THe .asc file is the same content, except in "ASCII armor" form
(aka, base-64 encoded). It was symmetrically encrypted using the same passphrase, but,
obviously, at a different time.

Test File Format
----------------

The first 32 bytes of example.txt.gpg are as follows:

00000000  8C 0D 04 07 03 02 7F E0  2A 8A 86 6E 42 9A B9 D2 |........*..nB...|
00000010  E9 01 07 9E 49 05 1F 2E  A2 31 40 F5 14 E8 B3 C4 |....I....1@.....|

The first packet header starts with 8C:

    8c = 1000,1100 = 10 0011 00
    
This is an old-style packet of type 3, "Symmetric Key Encrypted Session Key Packet." The length
encoding ID is 0 which corresponds to a 1-octet encoded length (the 0D).

After skipping the body of the first packet we come to the start of the header of the next
packet: D2

    D2 = 1101,0010 = 11 010010
    
This is a new-style packet of type 18, "Symmetric Encrypted and Integrity Protected Data
Packet."

The first octet of the length of this packet is E9 which corresponds to a partial body length.
The implied partial length is 1 << (0xE9 & 0x1F), which is 1 << 9, which is 512.

Returning to the initial packet... the body is:

    04 07 03 02 7F E0 2A 8A 86 6E 42 9A B9
    
The RFC specifies:

   The body of this packet consists of:

   - A one-octet version number.  The only currently defined version is 4.

   - A one-octet number describing the symmetric algorithm used.

   - A string-to-key (S2K) specifier, length as defined above.

   - Optionally, the encrypted session key itself, which is decrypted with the string-to-key
     object.
       
   If the encrypted session key is present, the result of applying the S2K algorithm to the
   passphrase is used to decrypt just that encrypted session key field, using CFB mode with an
   IV of all zeros. The decryption result consists of a one-octet algorithm identifier that
   specifies the symmetric-key encryption algorithm used to encrypt the following Symmetrically
   Encrypted Data packet, followed by the session key octets themselves.

The first octet is, indeed, 4 as required. The symmetric algorithm used is represented by 7 (AES
with 128 bit key; see Section 9 of the RFC). This is followed by the String2Key identifier of 3
(Iterated and Salted S2K). The hash algorithm used is indicated by 2 (SHA-1), followed by an 8
octet salt value (7F E0 2A 8A 86 6E 42 9A), followed by a count (B9).

The count byte implies an octet count given by:

    #define EXPBIAS 6
        count = ((Int32)16 + (c & 15)) << ((c >> 4) + EXPBIAS);

where 'c' is the 0xB9 value. This is:

    count = (16 + 9) << (11 + 6) = 25 << 17 = 3_276_800
    
This is the total number of octets to hash.
