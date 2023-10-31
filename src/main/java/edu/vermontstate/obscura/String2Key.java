package edu.vermontstate.obscura;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Class containing methods for converting strings (pass phrases) into keys. These methods
 * implement the String-to-Key algorithms described in Section 3.7 of RFC-4880.
 */
public class String2Key {

    public static class NotImplementedException extends Exception
    {
        NotImplementedException(String message) {
            super(message);
        }
    }


    public static class UnsupportedException extends Exception
    {
        UnsupportedException(String message) {
            super(message);
        }
    }


    /**
     * Computes a key from a pass phrase using the simple method described in RFC-4880.
     * See section 3.7.1.1
     * @param hashID The ID of the hash algorithm to use (Section 9.4 of RFC-4880).
     * @param keySize The number of bits of key material required. Must be a multiple of 8.
     * @param passPhrase The pass phrase from which to generate the key.
     * @return The required bytes of key material.
     * @throws NotImplementedException If the this method has not yet been implemented.
     */
    public static byte[] simple(int hashID, int keySize, String passPhrase)
            throws NotImplementedException
    {
        throw new NotImplementedException("Simple String-to-Key");
    }


    /**
     * Computes a key from a pass phrase using the salted method described in RFC-4880.
     * See section 3.7.1.2
     * @param hashID The ID of the hash algorithm to use (Section 9.4 of RFC-4880).
     * @param keySize The number of bits of key material required. Must be a multiple of 8.
     * @param passPhrase The pass phrase from which to generate the key.
     * @param salt An 8 octet array of salt bytes used by the method.
     * @return The required bytes of key material.
     * @throws NotImplementedException If the this method has not yet been implemented.
     */
    public static byte[] salted(int hashID, int keySize, String passPhrase, byte[] salt)
            throws NotImplementedException
    {
        throw new NotImplementedException("Salted String-to-Key");
    }


    /**
     * Computes a key from a pass phrase using the iterated and salted method described in
     * RFC-4880. See section 3.7.1.3
     * @param hashID The ID of the hash algorithm to use (Section 9.4 of RFC-4880).
     * @param keySize The number of bits of key material required. Must be a multiple of 8.
     * @param passPhrase The pass phrase from which to generate the key.
     * @param salt An 8 octet array of salt bytes used by the method.
     * @param octetCount The total number of octets to hash during the iteration process.
     * @return The required bytes of key material.
     * @throws NotImplementedException If the this method has not yet been implemented.
     */
    public static byte[] iteratedAndSalted(int hashID, int keySize, String passPhrase, byte[] salt, int octetCount)
            throws NotImplementedException
    {
        byte[] rawPassPhrase = passPhrase.getBytes(StandardCharsets.UTF_8);
        byte[] initialData = Arrays.copyOf(salt, salt.length + rawPassPhrase.length);
        System.arraycopy(rawPassPhrase, 0, initialData, salt.length, rawPassPhrase.length);
        // initialData is now the concatenation of salt followed by rawPassPhrase.

        // COMPLETE ME!
        throw new NotImplementedException("Iterated and Salted String-to-Key");
    }

}
