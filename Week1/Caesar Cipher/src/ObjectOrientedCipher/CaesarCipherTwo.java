package ObjectOrientedCipher;
public class CaesarCipherTwo
{
    private String alphabet;
    private String shiftedalphabetkey1;
    private String shiftedalphabetkey2;
    private int key1;
    private int key2;
    public CaesarCipherTwo(int key1,int key2)
    {
        this.key1=key1;
        this.key2=key2;
        alphabet="abcdefghijklmnopqrstuvwxyz";
        shiftedalphabetkey1=alphabet.substring(key1)+alphabet.substring(0,key1);
        shiftedalphabetkey2=alphabet.substring(key2)+alphabet.substring(0,key2);
    }
    public String encrypt(String input,int key)
    {
        CaesarCipher caesarCipher= new CaesarCipher(key);
        return  caesarCipher.encrypt(input);
    }
}
