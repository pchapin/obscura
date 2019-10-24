package edu.vtc.obscura;

/**
 * This enumeration type specifies the various Packet subtypes that exist. It is a red flag
 * when an OOP program creates an enumeration like this. Normally users of a super type do not
 * need (or want) to know the precise type of object they are interacting with. Instead the
 * dispatch to an overriding method, which is done automatically, takes care of checking the
 * runtime type of an object.
 *
 * However, the semantics of the different packet types in OpenPGP are often radically different.
 * It will be common, when processing, for example an array of Packets, to need to know which
 * kind of packet is in each array element so the proper behavior can be coded. Only a very
 * small number of operations have a common meaning and semantics across all Packet types. This
 * is why interface Packet is so sparse.
 */
public enum PacketType {
    Reserved,
    PublicKeyEncryptedSessionKey,
    Signature,
    SymmetricKeyEncryptedSessionKey,
    OnePassSignature,
    SecretKey,
    PublicKey,
    SecretSubkey,
    CompressedData,
    SymmetricallyEncryptedData,
    Marker,
    LiteralData,
    Trust,
    UserID,
    PublicSubkey,
    UserAttribute,
    SymmetricEncryptedIntegrityProtectedData,
    ModificationDetectionCode
}
