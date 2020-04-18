package ObjectOrientedCipher;
import edu.duke.FileResource;
class TestCaesarCipher
{
    public static int[] countLetters(String message) {
        int[] count = new int[26];
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        for (int k = 0; k < message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int index = alphabets.indexOf(ch);
            if (index != -1) {
                count[index] += 1;
            }
        }
        return count;
    }
    public int maxIndex(int []count)
    {
        int maxindex=-1,value=0;
        for(int i=0;i<count.length;i++)
        {
            if(value<count[i])
            {
                value=count[i];
                maxindex=i;
            }
        }
        return  maxindex;
    }
    public int getKey(String str)
    {
        int []count=countLetters(str);
        int maxindex=maxIndex(count);
        int key=maxindex-4;
        if(key<0)
            key=key+26;
        return key;
    }
    public void simpleTests()
    {

        FileResource fr=new FileResource();
        String input=fr.asString();
        CaesarCipher caesarCipher=new CaesarCipher(18);
        String msg=caesarCipher.encrypt(input);
        breakCeasarCipher(msg);
    }
    public void breakCeasarCipher(String input)
    {
        int key=getKey(input);
        CaesarCipher caesarCipher=new CaesarCipher(key);
        System.out.println("Key : "+key);
        System.out.println(caesarCipher.decrypt(input));
    }
    public static void main(String args[])
    {
        TestCaesarCipher testCaesarCipher=new TestCaesarCipher();
        testCaesarCipher.simpleTests();
    }
}
