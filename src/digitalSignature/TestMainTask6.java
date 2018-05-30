package digitalSignature;

import hash.Hash6Mode;
import serpent.Serpent;

import java.math.BigInteger;
import java.util.ArrayList;

public class TestMainTask6 {
    public static void main(String[] args) {
        Serpent serpent = new Serpent();
        String key = "JackShepardOTP";
        byte[] keyByteArr = key.getBytes();
        serpent.setKey(keyByteArr);

        String text = "Some kind of text, that I want to make hash from";
        byte[] textByteArr = text.getBytes();

        byte[] h0 = {0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00,
                0x00, 0x00, 0x00, 0x00};

        DigitalSignature sign = new DigitalSignature(textByteArr,serpent,h0);
    }
}