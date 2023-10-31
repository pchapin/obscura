package edu.vermontstate.obscura;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Interface to all OpenPGP packet types. Subtypes of Packet represent individual OpenPGP
 * packet types. Packets are intended to be treated abstractly. There are no operations in this
 * interface for accessing the raw bytes of a packet; the internal representation of the various
 * packet subtypes may not, and probably do not, store a raw binary encoding.
 */
public interface Packet {

    /**
     * Get the PacketType of this packet. The need for this method is explained in more detail
     * in the documentation for the PacketType enumeration.
     * @return The PacketType corresponding to the runtime type of this packet.
     */
    PacketType getType();

    /**
     * Encodes this Packet object into an OpenPGP formatted collection of raw bytes. This
     * method then sends those bytes to the given OutputStream.
     * @param os The OutputStream that will receive the encoded packet.
     */
    void write(OutputStream os);

    /**
     * Decodes the OpenPGP formatted collection of raw bytes from the given InputStream into a
     * Packet object. The InputStream is advanced to the start of the next packet or to the end
     * of the file.
     * @param is The InputStream from which the decoded packet will be obtained.
     */
    void read(InputStream is);

    /**
     * Reads the next Packet from the given InputStream. This method inspects the packet header,
     * creates a suitable subtype instance, and asks that instance to read and decode its
     * content from the InputStream.
     * @param is The InputStream from which to read the next OpenPGP packet.
     * @return A reference to the packet read.
     */
    static Packet readPacket(InputStream is)
    {
        Packet result = null;

        // IMPLEMENT ME!

        return result;
    }

    /**
     * Reads an entire InputStream, decoding all packets found in that stream. This method
     * repeatedly calls readPacket until the InputStream is exhausted (or an error occurs).
     * @param is The InputStream from which to read OpenPGP packets.
     * @return A list of all Packets found in the stream.
     */
    static List<Packet> readPacketSequence(InputStream is)
    {
        List<Packet> packetList = new LinkedList<>();

        // IMPLEMENT ME!

        return packetList;
    }
}
