package modularArithmephics;

import java.math.BigInteger;

import modularArithmephics.*;

public class TestMain {

    public static void main(String[] args) {
        BigInteger bi1 = new BigInteger("-265549988754");
        BigInteger bi2 = new BigInteger("95588753");
        System.out.println("bi1+bi2 = " + (bi1.add(bi2)));
        System.out.println(ModAr.GreatComDiv(bi1,bi2));

        BigInteger expBIVal = new BigInteger("3");
        BigInteger expBIExp = new BigInteger("5");
        BigInteger expBIMod = new BigInteger("5");
        System.out.println(ModAr.FastExpon(expBIVal, expBIExp, expBIMod));

        System.out.println(expBIVal.mod(expBIMod));

    }

}
