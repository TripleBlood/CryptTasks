package digitalSignature;

import hash.Hash6Mode;
import serpent.BlockCipher;
import serpent.Serpent;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Random;

public class DigitalSignature {
    public BigInteger pValue = new BigInteger("97553607833069877720851753590758150859523200990282982100522379573651322066419");
    public BigInteger qValue = new BigInteger("286684287275266243736166399217868759773");

    public BigInteger getrValue() {
        return rValue;
    }

    public BigInteger getsValue() {
        return sValue;
    }

    private BigInteger rValue;

    public void setrValue(BigInteger rValue) {
        this.rValue = rValue;
    }

    public void setsValue(BigInteger sValue) {
        this.sValue = sValue;
    }

    private BigInteger sValue;



    public DigitalSignature(byte[] textSample, BlockCipher blockCipher, byte[] h0) {
        Random random = new Random();
        BigInteger gamma = generateRandomBigIntInRange(new BigInteger("2"), pValue.subtract(new BigInteger("2")));
//        BigInteger gamma = qValue.subtract(new BigInteger(String.valueOf(Math.abs(random.nextInt()) + 1)));
        BigInteger g = gamma.modPow(pValue.subtract(new BigInteger("1")).divide(qValue), pValue);


        BigInteger x = generateRandomBigIntInRange(new BigInteger("2"), qValue.subtract(new BigInteger("1")));
//        BigInteger x = pValue.subtract(new BigInteger(String.valueOf(Math.abs(random.nextInt()) + 1)));
        BigInteger y = g.modPow(x, pValue);

        BigInteger k = generateRandomBigIntInRange(new BigInteger("1"), qValue.subtract(new BigInteger("1")));
//        ByteBuffer w = ByteBuffer.wrap(Hash6Mode.createHash(textSample, blockCipher, h0));
//        BigInteger hash = BigInteger.valueOf(w.getLong());
        BigInteger hash = new BigInteger(Hash6Mode.createHash(textSample, blockCipher, h0));

        BigInteger r = g.modPow(k, pValue);
        BigInteger ro = r.mod(qValue);
        BigInteger s = (ro.multiply(hash).multiply(x).add(new BigInteger("1"))).multiply(k.modPow(new BigInteger("-1"), qValue)).mod(qValue);

        this.rValue = r;
        this.sValue = s;

        //Проверка на правильность
        BigInteger leftPart = r.modPow(s, pValue);
        BigInteger rightPart = y.modPow(ro.multiply(hash), pValue).multiply(g).mod(pValue);

        if (leftPart.compareTo(rightPart) == 0) System.out.println("Подпись составлена, ошибок не обнаружено!");
        else {
            System.out.println("Что-то пошло не так");
        }
    }

    public static BigInteger generateRandomBigIntInRange(BigInteger initVal, BigInteger finVal) {
        BigInteger buffer = finVal.subtract(initVal);
        Random random = new Random();
        BigInteger result;
        do {
            result = new BigInteger(buffer.bitLength(), random);
        } while (result.compareTo(buffer) >= 0);
        return result.add(initVal);
    }

}
