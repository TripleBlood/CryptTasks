package rc4;

import Utils.Utils;
import rc4.utils.ElementWithSubstDet;
import rc4.utils.PseudoRndShuffle;

import java.util.ArrayList;

public class TestMainTask1 {

    public static void main(String[] args) {

        // Инициализация датчика
        String key = "Ligai Vyacheslav";
        byte[] keyByteArr = key.getBytes();
        RC4 rc4ex = new RC4(keyByteArr);

        System.out.println("Получение случачайного байта:");
        System.out.println(Utils.byteToHex(rc4ex.getRndByte()));;
        System.out.println("——————");
        System.out.println("Получение случачайного байта в диапозоне от 0 до 200");
        System.out.println(Utils.byteToHex(rc4ex.getRndByteInRange(200)));
        System.out.println("——————");

        ArrayList<ElementWithSubstDet> array = new PseudoRndShuffle().buildSubstitution(20, rc4ex);

        System.out.println("Псевдо-случайная перестановка чисел от 0 до 20");
        for (ElementWithSubstDet element : array) {
            System.out.print(element.getValue() + " ");
        }
        System.out.println("");
        System.out.println("——————");
    }
}
