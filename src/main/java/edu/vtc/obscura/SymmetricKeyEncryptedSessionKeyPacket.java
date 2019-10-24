package edu.vtc.obscura;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Packet class that represents session keys that have been symmetrically encrypted.
 */
public class SymmetricKeyEncryptedSessionKeyPacket implements Packet {

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
    {
        // IMPLEMENT ME!
        return null;
    }

}
