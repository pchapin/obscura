package edu.vtc.obscura;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Packet class that represents symmetrically encrypted data with integrity protection.
 */
public class SymmetricEncryptedIntegrityProtectedDataPacket implements Packet {

    @Override
    public PacketType getType()
    {
        return PacketType.SymmetricEncryptedIntegrityProtectedData;
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

}
