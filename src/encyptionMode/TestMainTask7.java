package encyptionMode;

import Util.ByteToHexUtils;
import serpent.Serpent;

import java.util.ArrayList;

public class TestMainTask7 {
    public static void main(String[] args) {
        Serpent serpent = new Serpent();

        String key = "JackShepardOTP";
        byte[] keyByteArr = key.getBytes();
        serpent.setKey(keyByteArr);

        String text = "Recognition of phonemes is very important in speech recognition technologies. It can be used in many different spheres of life, for example in auto-creating subtitles to video or script to any speech.";
        byte[] p0 = {0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00};

        System.out.println("Сообщение до шифрования:");
        System.out.println(text);
        System.out.println("——————");
        //EncodedText encodedText = EncryptionMode.PFBEncode(text,key,p0);
        ArrayList<byte[]> arrayList = EncryptionMode.PFBEncode(text,key,p0);
        System.out.println("Сообщение после шифрования:");
        //ByteToHexUtils.printHexArrList(encodedText.encodedText);
        ByteToHexUtils.printHexArrList(arrayList);
        System.out.println("——————");
        System.out.println("Сообщение после дешифрования:");
        System.out.println(EncryptionMode.PFBDecode(arrayList, key, p0));
        System.out.println("——————");

        System.out.println("——————");
        System.out.println("Сообщение до шифрования:");
        System.out.println(text);
        System.out.println("——————");
        EncodedText encodedText = EncryptionMode.PFBEncodeSing(text,key,p0);
        System.out.println("Сообщение после шифрования:");
        ByteToHexUtils.printHexArrList(encodedText.encodedText);
        System.out.println("——————");
        System.out.println("Сообщение после дешифрования:");
        System.out.println(EncryptionMode.PFBDecodeSign(encodedText, key, p0));
        System.out.println("——————");


    }
}
