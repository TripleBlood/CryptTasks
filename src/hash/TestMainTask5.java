package hash;

import serpent.Serpent;

import java.util.ArrayList;

import static hash.Hash6Mode.textTo16ByteBlocks;

public class TestMainTask5 {
    public static void main(String[] args) {
        Serpent serpent = new Serpent();
        String key = "JackShepardOTP";
        byte[] keyByteArr = key.getBytes();
        serpent.setKey(keyByteArr);

        byte[] h0 = {0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00};

        String text = "Some kind of text, that I want to make hash from";
        byte[] textByteArr = text.getBytes();
        byte[] hashArr = Hash6Mode.createHash(textByteArr, serpent, h0);

        System.out.println("Text before using hash-function:");
        System.out.println(text);

        for (int i = 0; i < hashArr.length; i++) {
            System.out.print(hashArr[i] + "   ");
        }
        System.out.println(" ");
        String hash = new String(hashArr);
        System.out.println("Text after using hash-function:");
        System.out.println(hash);


        String string;
        ArrayList<byte[]> list = Hash6Mode.textTo16ByteBlocks(textByteArr);
        for (int i = 0; i < list.size(); i++) {
            string = new String(list.get(i));
            System.out.println(string);
        }
        string = new String(Hash6Mode.xorForArrays(list.get(0),list.get(1)));

        System.out.println(string);
        System.out.println(0);

    }
}
