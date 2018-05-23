package serpent;

public class Utils {
    public static void packIntBigEndian(byte[] src,
                                        int srcPos,
                                        int[] dst,
                                        int dstPos,
                                        int len) {
        if (srcPos + 4 * len > src.length) throw new IndexOutOfBoundsException();
        if (dstPos + len > dst.length) throw new IndexOutOfBoundsException();
        for (int i = 0; i < len; ++i)
            dst[dstPos + i] = packIntBigEndian(src, srcPos + 4 * i);
    }

    public static int packIntBigEndian
            (byte[] src,
             int srcPos) {
        if (srcPos + 4 > src.length) throw new IndexOutOfBoundsException();
        int rv = 0;
        for (int i = 0; i <= 3; ++i)
            rv |= (src[srcPos + i] & 0xFF) << ((3 - i) * 8);
        return rv;
    }

    public static void unpackIntBigEndian
            (int src,
             byte[] dst,
             int dstPos) {
        if (dstPos + 4 > dst.length) throw new IndexOutOfBoundsException();
        for (int i = 0; i <= 3; ++i)
            dst[dstPos + i] = (byte) (src >> ((3 - i) * 8));
    }

    public static void unpackIntBigEndian
            (int[] src,
             int srcPos,
             byte[] dst,
             int dstPos,
             int len) {
        if (srcPos + len > src.length) throw new IndexOutOfBoundsException();
        if (dstPos + 4 * len > dst.length) throw new IndexOutOfBoundsException();
        for (int i = 0; i < len; ++i)
            unpackIntBigEndian(src[srcPos + i], dst, dstPos + 4 * i);
    }

    public static void unpackIntLittleEndian
            (int src,
             byte[] dst,
             int dstPos) {
        if (dstPos + 4 > dst.length) throw new IndexOutOfBoundsException();
        for (int i = 0; i <= 3; ++i)
            dst[dstPos + i] = (byte) (src >> (i * 8));
    }

    public static void unpackIntLittleEndian
            (int[] src,
             int srcPos,
             byte[] dst,
             int dstPos,
             int len) {
        if (srcPos + len > src.length) throw new IndexOutOfBoundsException();
        if (dstPos + 4 * len > dst.length) throw new IndexOutOfBoundsException();
        for (int i = 0; i < len; ++i)
            unpackIntLittleEndian(src[srcPos + i], dst, dstPos + 4 * i);
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
}
