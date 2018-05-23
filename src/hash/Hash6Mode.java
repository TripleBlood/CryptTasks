package hash;

import serpent.BlockCipher;

import java.util.ArrayList;
import java.util.Arrays;

public class Hash6Mode {


    public static byte[] createHash(byte[] text, BlockCipher cipher, String h0) {
        byte[] stringByte = h0.getBytes();
        byte[] stringByteFull = new byte[text.length];
        int j = 0;
        int ij = 0;
        while (ij < text.length) {
            if (j != 16) {
                stringByteFull[ij] = stringByte[j];
                ij++;
                j++;
            } else {
                j = 0;
                stringByteFull[ij] = stringByte[j];
                ij++;
                j++;
            }
        }

        byte[] h = stringByteFull;
        ArrayList<byte[]> blockedText = textTo16ByteBlocks(text);
        for (int i = 0; i < blockedText.size(); i++) {
            byte[] miXorH = xorForArrays(blockedText.get(i), h);
            byte[] miXorH2 = Arrays.copyOf(miXorH, 16); //потому что я сделал encrypt void-функцией
            cipher.setKey(blockedText.get(i));
            cipher.encrypt(miXorH);
            h = xorForArrays(miXorH, miXorH2);
        }
        return h;
    }

    public static ArrayList<byte[]> textTo16ByteBlocks(byte[] text) {
        int zero = 0;
        ArrayList<byte[]> list = new ArrayList();
        byte[] bufferArray = new byte[16];
        int j = 0;
        int listIndex = 0;
        for (int i = 0; i < text.length; i++) {
            if (j != 16) {
                bufferArray[j] = text[i];
                j++;
            } else {
                list.add(Arrays.copyOf(bufferArray, 16));
                j = 0;
                bufferArray[j] = text[i];
                j++;
            }
        }
        if (j != 16) {
            for (int i = j; i < bufferArray.length; i++) {
                bufferArray[i] = (byte) zero;
            }
            list.add(Arrays.copyOf(bufferArray, 16));
        } else if (j == 16){
            list.add(Arrays.copyOf(bufferArray, 16));
        }
        return list;
    }

    public static byte[] xorForArrays(byte[] array1, byte[] array2) {
        byte[] buffer = new byte[16];
        for (int i = 0; i < array1.length; i++) {
            buffer[i] = (byte) ((array1[i] ^ array2[i]));
        }
        return buffer;
    }
}
