package edu.vtc.obscura;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Packet class that represents session keys that have been symmetrically encrypted.
 */
public class SymmetricKeyEncryptedSessionKeyPacket implements Packet {

    private int stringToKeyIdentifier;
    private int hashIdentifier;
    private int keySize;
    private byte[] salt;
    private int countControl;

    @Override
    public PacketType getType()
    {
        return PacketType.SymmetricKeyEncryptedSessionKey;
    }

    @Override
    public void write(OutputStream os)
    {
        // IMPLEMENT ME!
    }

    @Override
    public void read(InputStream is)
    {
        // IMPLEMENT ME!
    }


    /**
     * Return the session key in this packet.
     * @param passPhrase The passphrase used to decrypt the session key or, if no session key is
     * included in the packet, the passphrase is used to directly generate the session key.
     * @return The resulting session key.
     */
    public byte[] getSessionKey(String passPhrase)
            throws String2Key.NotImplementedException, String2Key.UnsupportedException
    {
        byte[] keyMaterial;

        switch (stringToKeyIdentifier) {
            case 0:
                keyMaterial =
                    String2Key.simple(hashIdentifier, keySize, passPhrase);
                break;

            case 1:
                keyMaterial =
                    String2Key.salted(hashIdentifier, keySize, passPhrase, salt);
                break;

            case 3:
                // See RFC-4880, Section 3.7.1.3.
                int octetCount = (16 + (countControl & 0xFFFF)) << ((countControl >> 4) + 6);
                keyMaterial =
                    String2Key.iteratedAndSalted(hashIdentifier, keySize, passPhrase, salt, octetCount);
                break;

            default:
                throw new String2Key.UnsupportedException("S2K specifier = " + stringToKeyIdentifier);
        }
        return keyMaterial;
    }

}
