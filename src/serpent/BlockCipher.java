package serpent;

public interface BlockCipher {
    public int blockSize();

    public int keySize();

    public void setKey(byte[] key);

    public void encrypt(byte[] text);

}