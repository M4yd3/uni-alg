package mirea.ru.marchenko.kvbo0121.lab5;


import java.util.Arrays;
import java.util.Random;

public class Crypto {
    private final boolean shiftDirection = true; // left = 0, right = 1
    private final int shiftSize = 2;
    private final int blockSize = 4;
    private final long seed;

    public Crypto(long seed) {
        this.seed = seed;
    }

    public byte[] encode(String message) {
        final byte[] bytes = message.getBytes();
        final byte[] encodedBytes = new byte[Math.ceilDiv(bytes.length, blockSize) * blockSize];
        final Random generator = new Random(seed);

        for (int i = 0; i < bytes.length; i += blockSize) {
            // Put bytes into block
            int block = 0;
            for (int j = i; j < Math.min(i + blockSize, bytes.length); j++) {
                block = block << 8 | bytes[j];
            }

            // XOR cipher
            final int gamma = Math.abs(generator.nextInt());
            block ^= gamma;

            // Shifting
            if (shiftDirection) {
                block = Integer.rotateRight(block, shiftSize);
            } else {
                block = Integer.rotateLeft(block, shiftSize);
            }

            for (int j = i; j < i + blockSize; j++) {
                encodedBytes[j] = (byte) (block >>> 24);
                block = block << 8;
            }
        }

        return encodedBytes;
    }

    private void printAsBinary(int x) {
        String s = Integer.toBinaryString(x);
        String f = "%" + (int) Math.ceil(s.length() / 8.0) * 8 + "s";
        s = String.format(f, s).replaceAll(" ", "0");
        System.out.printf("%32s%n", s);
    }

    public String decode(byte[] bytes) {
        Random generator = new Random(seed);
        byte[] decodedBytes = new byte[bytes.length];
        int byteLength = 0;

        for (int i = 0; i < bytes.length; i += blockSize) {
            // Put bytes into block
            int block = 0;
            for (int j = i; j < Math.min(i + blockSize, bytes.length); j++) {
                block = block << 8 | (bytes[j] & 255);
            }

            // Shifting back
            if (!shiftDirection) {
                block = Integer.rotateRight(block, shiftSize);
            } else {
                block = Integer.rotateLeft(block, shiftSize);
            }

            // XOR cipher
            final int gamma = Math.abs(generator.nextInt());
            block ^= gamma;

            int blockLength = 4 - Integer.numberOfLeadingZeros(block) / 8;
            block = Integer.reverseBytes(block);
            for (int j = i + blockLength - 1; j >= i; j--) {
                decodedBytes[j] = (byte) (block >>> 24);
                block = block << 8;
                byteLength++;
            }
        }
        decodedBytes = Arrays.copyOfRange(decodedBytes, 0, byteLength);
        return new String(decodedBytes);
    }
}
