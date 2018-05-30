package encyptionMode;

import hash.Hash6Mode;
import serpent.Serpent;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 */
public class EncryptionMode {

    public static ArrayList<byte[]> PFBEncode(String text, String key, byte[] p0) {

        // Инициализируем блочный шифр, задём ключ;
        Serpent serpent = new Serpent();
        byte[] keyByteArr = key.getBytes();
        serpent.setKey(keyByteArr);

        byte[] textByteArr = text.getBytes();

        // Разбиваем текст на равные блоки по 16 байтов
        ArrayList<byte[]> textPBlocks = Hash6Mode.textTo16ByteBlocks(textByteArr);
        ArrayList<byte[]> textCBlocks = new ArrayList<byte[]>();
        byte[] buffer = new byte[16];
        byte[] bufferForEncryptedPBlocks = Arrays.copyOf(p0, 16);

        //
        serpent.encrypt(bufferForEncryptedPBlocks);

        for (int i = 0; i < textPBlocks.size(); i++) {
            buffer = Hash6Mode.xorForArrays(textPBlocks.get(i), bufferForEncryptedPBlocks);
            textCBlocks.add(Arrays.copyOf(buffer, 16));
            bufferForEncryptedPBlocks = Arrays.copyOf(textPBlocks.get(i), 16);
            serpent.encrypt(bufferForEncryptedPBlocks);
        }
        return textCBlocks;
    }

    public static String PFBDecode(ArrayList<byte[]> textCBlocks, String key, byte[] p0) {
        Serpent serpent = new Serpent();
        byte[] keyByteArr = key.getBytes();
        serpent.setKey(keyByteArr);

        ArrayList<byte[]> textPblocks = new ArrayList<byte[]>();
        byte[] buffer = new byte[16];
        byte[] bufferForEncryptedPBlocks = Arrays.copyOf(p0, 16);

        //
        serpent.encrypt(bufferForEncryptedPBlocks);

        for (int i = 0; i < textCBlocks.size(); i++) {
            buffer = Hash6Mode.xorForArrays(textCBlocks.get(i), bufferForEncryptedPBlocks);
            textPblocks.add(Arrays.copyOf(buffer, 16));
            bufferForEncryptedPBlocks = Arrays.copyOf(textPblocks.get(i), 16);
            serpent.encrypt(bufferForEncryptedPBlocks);
        }
        String finalString = new String(textPblocks.get(0));

        for (int i = 1; i < textPblocks.size(); i++) {
            finalString = finalString.concat(new String(textPblocks.get(i)));
        }
        return finalString;
    }
}
