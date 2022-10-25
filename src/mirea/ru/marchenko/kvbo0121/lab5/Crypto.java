package mirea.ru.marchenko.kvbo0121.lab5;


import java.util.Arrays;
import java.util.Random;

public class Crypto {
    // Shift direction - right
    private final int shiftSize = 2; // bits
    private final int blockSize = 2; // byte
    private final Random generator;

    public Crypto(long seed) {
        generator = new Random(seed);
    }

    public byte[] encode(String message) {
        byte[] bytes = message.getBytes();

        for (int i = 0; i < bytes.length; i += blockSize) {
            final byte[] block = Arrays.copyOfRange(bytes, i, Math.min(i + blockSize, bytes.length));
            System.out.println(Integer.toBinaryString(block[0]));
            System.out.println(Integer.toBinaryString(block[1]));
            System.out.println(Integer.toBinaryString((block[0] << 8) | block[1]));
            break;
        }

        return bytes;
    }

    public String decode(byte[] bytes) {

        return "";
    }
}
