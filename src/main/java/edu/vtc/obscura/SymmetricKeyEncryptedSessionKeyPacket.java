package edu.vtc.obscura;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Packet class that represents session keys that have been symmetrically encrypted.
 */
public class SymmetricKeyEncryptedSessionKeyPacket implements Packet {

    public PacketType getType()
    {
        return PacketType.SymmetricKeyEncryptedSessionKey;
    }

    public void write(OutputStream os)
    {
        // IMPLEMENT ME!
    }

    public void read(InputStream is)
    {
        // IMPLEMENT ME!
    }

}
