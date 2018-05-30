package hash;

import Util.ByteToHexUtils;
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
        String string;
        ArrayList<byte[]> list = Hash6Mode.textTo16ByteBlocks(textByteArr);

        System.out.println("Текст до хеширования:");
        System.out.println(text);
        System.out.println("——————");
        System.out.println("Текст до хешированияв шестнадцатиричном виде:");
        ByteToHexUtils.printHexArrList(list);
        System.out.println("——————");
        System.out.println("Текст после хеширования в шестнадцатиричном виде:");
        System.out.println(ByteToHexUtils.bytesToHex(hashArr));
        System.out.println("——————");
        System.out.println(" ");
    }
}
