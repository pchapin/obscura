package edu.vtc.obscura;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Packet class that represents symmetrically encrypted data with integrity protection.
 */
public class SymmetricEncryptedIntegrityProtectedDataPacket implements Packet {

    public PacketType getType()
    {
        return PacketType.SymmetricEncryptedIntegrityProtectedData;
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
