package serpent;

import Util.ByteToHexUtils;

import java.io.*;
import java.util.Arrays;

import static serpent.Utils.*;

public class TestMainSerpent {
    public static void main(String[] args) {
        Serpent serpent = new Serpent();

        String key = "JackShepardOTP";
        byte[] keyByteArr = key.getBytes();
        serpent.setKey(keyByteArr);

        String text = "ILoveMassEffect!";
        byte[] textByteArr = text.getBytes();

        System.out.println("Сообщение до шифрования:");
        System.out.println(text);
        System.out.println("Сообщение до шифрования в шестнадцатиричном виде:");
        System.out.println(ByteToHexUtils.bytesToHex(textByteArr));
        System.out.println("——————");

        //Шифрование
        serpent.encrypt(textByteArr);
        System.out.println("Сообщение после шифрования в шестнадцатиричном виде:");
        System.out.println(ByteToHexUtils.bytesToHex(textByteArr));
        System.out.println("——————");

        //Расшифрование
        serpent.decrypt(textByteArr);
        text = new String(textByteArr);
        System.out.println("Сообщение после расшифрования в шестнадцатиричном виде:");
        System.out.println(ByteToHexUtils.bytesToHex(textByteArr));
        System.out.println("Сообщение после расшифрования:");
        System.out.println(text);
        System.out.println("——————");
        System.out.println("Key: " + key);
    }
}
