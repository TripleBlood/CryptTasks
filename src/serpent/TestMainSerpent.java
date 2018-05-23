package serpent;

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
        for (int i = 0; i < textByteArr.length; i++) {
            System.out.print(textByteArr[i] + "   ");
        }
        System.out.println(" ");
        text = new String(textByteArr);
        System.out.println(text);

        //Шифрование
        serpent.encrypt(textByteArr);
        for (int i = 0; i < textByteArr.length; i++) {
            System.out.print(textByteArr[i] + "   ");
        }
        System.out.println(" ");
        text = new String(textByteArr);
        System.out.println(text);

        //Расшифрование
        serpent.decrypt(textByteArr);
        for (int i = 0; i < textByteArr.length; i++) {
            System.out.print(textByteArr[i] + "   ");
        }
        System.out.println(" ");

        text = new String(textByteArr);
        System.out.println(text);
        System.out.println("Key: " + key);
    }
}
