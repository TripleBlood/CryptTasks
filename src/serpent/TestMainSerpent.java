package serpent;

import java.io.*;
import java.util.Arrays;

import static serpent.Utils.*;

public class TestMainSerpent {

    /**
     * Main function, does one of two things:
     * sets an all-zero-byte key, performs N encryptions of an all-zero-byte plaintext block
     * or
     * encrypts the contents of the input file, storing the result in an output file
     * args either specifies N or
     * input filename, output filename, key (up to 32 bytes in hex), nonce (integer), and [e]ncrypt or [d]ecrypt
     */


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
