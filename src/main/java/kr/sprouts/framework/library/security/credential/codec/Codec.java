package kr.sprouts.framework.library.security.credential.codec;

public interface Codec {
    byte[] encode(byte[] decodedBytes);
    String encodeToString(byte[] decodedBytes);
    byte[] decode(byte[] encodedBytes);
    byte[] decode(String encodedString);
}
