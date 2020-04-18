package ObjectOrientedCipher;
public class CaesarCipher
{
    private String alphabet;
    private String shiftedalphabet;
    private int mainkey;
    public CaesarCipher(int key)
    {
        mainkey=key;
        alphabet="abcdefghijklmnopqrstuvwxyz";
        shiftedalphabet=alphabet.substring(key)+alphabet.substring(0,key);
    }
    public String encrypt(String input)
    {
        StringBuilder stringBuilder=new StringBuilder(input);
        char ch=stringBuilder.charAt(0),newchar='a';
        int index=0;
        for(int i=0;i<stringBuilder.length();i++)
        {
            index=alphabet.indexOf(stringBuilder.charAt(i));
            if(index>=0)
            {
                stringBuilder.setCharAt(i,shiftedalphabet.charAt(index));
            }
        }
        return stringBuilder.toString();
    }
    public String decrypt(String input)
    {
        CaesarCipher ceasarCipher= new CaesarCipher(26-mainkey);
        return ceasarCipher.encrypt(input);
    }
}
