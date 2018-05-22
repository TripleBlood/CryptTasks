package modularArithmephics;

import java.math.BigInteger;

public class ModAr {

    // Для проверки на простоту можно использовать стандартный метод класса BigInteger – isProbablePrime()

    //Поиск наибольшего общего делителя
    public static BigInteger GreatComDiv(BigInteger bi1, BigInteger bi2) {
        bi1 = bi1.abs();
        bi2 = bi2.abs();
        while (bi1.signum() == 1 && bi2.signum() == 1) {
            if (bi1.compareTo(bi2) == 1) bi1 = bi1.mod(bi2);
            else bi2 = bi2.mod(bi1);
        }
        return bi1.add(bi2);
    }

    //Опреация быстрого возведения в степень
    public static BigInteger FastExpon(BigInteger num, BigInteger exponent, BigInteger n) {
        BigInteger zero = new BigInteger("0");
        BigInteger two = new BigInteger("2");
        BigInteger one = new BigInteger("1");

        BigInteger retVal = new BigInteger("1");

        while (exponent.compareTo(zero) == 1) {
            if (!exponent.mod(two).equals(zero)) {
                retVal = retVal.multiply(num).mod(n);
                exponent = exponent.subtract(one);
            }
            num = num.multiply(num).mod(n);
            exponent = exponent.divide(two);
        }
        return retVal;
    }

    public static BigInteger MultInv(BigInteger num, BigInteger n) {
        BigInteger zero = new BigInteger("0");

        BigInteger d = num;
        BigInteger m = n;
        BigInteger y = new BigInteger("0");
        BigInteger retVal = new BigInteger("1");
        BigInteger r = m.mod(d);
        BigInteger q;
        BigInteger z;

        while (r.compareTo(zero) == 1) {
            q = m.mod(d);
            z = ((y.add(n.subtract(q.multiply(retVal).mod(n)))).mod(n));
            m = d;
            d = r;
            y = retVal;
            retVal = z;
            r = m.mod(d);
        }
        return retVal;
    }
}
