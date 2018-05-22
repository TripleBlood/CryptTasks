package rc4;

import rc4.utils.ElementWithSubstDet;
import rc4.utils.PseudoRndShuffle;

import java.util.ArrayList;

public class TestMainTask1 {

    public static void main(String[] args) {

        String key = "EgorNyaaaaaaaa";
        byte[] keyByteArr = key.getBytes();
        RC4 rc4ex = new RC4(keyByteArr);

        rc4ex.getRndByte();
        rc4ex.getRndByteInRange(200);

        ArrayList<ElementWithSubstDet> array = new PseudoRndShuffle().buildSubstitution(20, rc4ex);

        for (ElementWithSubstDet element : array){
            System.out.println(element.getValue());
        }
    }
}
