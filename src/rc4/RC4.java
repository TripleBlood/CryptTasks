package rc4;

public class RC4 {

    private final byte[] S = new byte[256]; //последовательность, откуда будут извлекаться псевдослучайные байты
    private final byte[] K = new byte[256]; //Для записи ключа
    private final int keylen;
    private int iRC4 = 0;
    private int jRC4 = 0;


    /*
     * Инициализация датчика
     */
    public RC4(final byte[] key) {
        if (key.length < 1 || key.length > 256) {
            throw new IllegalArgumentException("Key must be between 1 and 256 bytes");
        } else {
            keylen = key.length;
            for (int i = 0; i < 256; i++) {
                S[i] = (byte) i;
                K[i] = key[i % keylen];
            }
            int j = 0;
            byte buffer;
            for (int i = 0; i < 256; i++) {
                //чтобы, не дай бог, получить отрицательное число
                //идентично делению по модулю на 256
                j = (j + S[i] + K[i]) & 0xFF;

                buffer = S[i];
                S[i] = S[j];
                S[j] = buffer;
            }
        }
    }

    /*
     * Получение текущего байта
     */
    public byte getRndByte() {
        int t;
        byte buffer;

        iRC4 = (iRC4 + 1) & 0xFF;
        jRC4 = (jRC4 + S[iRC4]) & 0xFF;

        buffer = S[iRC4];
        S[iRC4] = S[jRC4];
        S[jRC4] = buffer;

        t = (S[iRC4] + S[jRC4]) & 0xFF;
        return S[t];
    }

    /*
     * Получение псевдослучайного байта "с" в диапозоне [0...k-1], k<=256
     */
    public byte getRndByteInRange(int k) {
        byte c;
        byte y = (byte)(256 - (256 & 0xFF));

        if (k < 0 || k > 255) {
            throw new IllegalArgumentException("Range should be in range [0,255]");
        } else {
            while (true) {
                c = getRndByte();
                if (c < y) {
                    c = (byte)(c & 0xFF);
                    return c;
                }
            }
        }
    }
}
