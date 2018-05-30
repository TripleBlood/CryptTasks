package encyptionMode;

import digitalSignature.DigitalSignature;

import java.util.ArrayList;

public class EncodedText {
    ArrayList<byte[]> encodedText;
    DigitalSignature signature;

    public EncodedText(){}

    public EncodedText(ArrayList<byte[]> encodedText, DigitalSignature signature) {
        this.encodedText = encodedText;
        this.signature = signature;
    }


}
