package Util;

import java.util.ArrayList;

public class ByteToHexUtils {
    /**
     * Функция, преобразующая массив байтов в строковый шестнадцатиричный вид
     */
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    /**
     * Функция, преобразующая ArrayList массивов байтов в строковый шестнадцатиричный вид
     */
    public static void printHexArrList(ArrayList<byte[]> list) {
        String finalString = bytesToHex(list.get(0));

        System.out.print(bytesToHex(list.get(0)) + " ");
        for (int i = 1; i < list.size(); i++) {
            finalString = finalString.concat(bytesToHex(list.get(i)));
            System.out.print(bytesToHex(list.get(i)) + " ");
        }
        System.out.println("");
    }

    /**
     * Функция, преобразующая байт в строковый шестнадцатиричный вид
     */
    public static String byteToHex(byte initByte){
        char[] hexChars = new char[2];
        int v = initByte & 0xFF;
        hexChars[0] = hexArray[v >>> 4];
        hexChars[1] = hexArray[v & 0x0F];

        return  new String(hexChars);
    }
}
