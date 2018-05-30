public class F256 {
    public static final byte polynomialByte = 27;
    public static byte MulGF256(byte a,byte b) {
        byte t = 0;
        byte mask = 1;
        for(int i=0;i<8;i++) {
            if((b&mask) != 0) {
                t = (byte) (t^a);
            } if((a&128)== 0) {
                a = (byte)(a<<1);
            } else {
                a = (byte)((byte)(a<<1)^polynomialByte);
            } mask = (byte)(mask<<1);
        } return t;
    }

    public static byte PowerGF256(byte a, byte b) {
        byte c = 1;
        while((b&0xff)!=0) {
            if((b&0xff)%2!=0) {
                c = MulGF256(c,a);
            } a = MulGF256(a,a);
            b = (byte)((b&0xff)>>1);
        }
        return c;
    }

    public static int polynomeMul(int a, int b) {
        int rez = 0;
        for (int i = 0; i < 8; i++) {
            rez ^=a*b&(1<<i);
        }
        return rez;
    }
}
