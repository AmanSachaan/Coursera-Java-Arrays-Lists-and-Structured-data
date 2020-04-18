package ObjectOrientedCipher;
import edu.duke.FileResource;
class TestCaesarCipherTwo
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
    public String halfOfString(String msg,int start)
    {
        StringBuilder sb= new StringBuilder();
        for(int i=start;i<msg.length();i+=2)
        {
            sb.append(msg.charAt(i));
        }
        return sb.toString();
    }
    public void simpleTests()
    {
        int key1=2,key2=5;
        CaesarCipherTwo obj=new CaesarCipherTwo(key1,key2);
        FileResource fr=new FileResource();
        String input=fr.asString();
        String input1=halfOfString(input,0);
        String input2=halfOfString(input,1);
        String msg1=obj.encrypt(input1,key1);
        String msg2=obj.encrypt(input2,key2);
//            System.out.println(input);
//            System.out.println("part 1:"+msg1);
//            System.out.println("part 2:"+msg2);
        msg1= breakCeasarCipher(msg1,1);
        msg2= breakCeasarCipher(msg2,2);
        System.out.println(join(msg1,msg2));
    }
    public String breakCeasarCipher(String input,int i)
    {
        int key=getKey(input);
        CaesarCipher caesarCipher=new CaesarCipher(key);
        System.out.println("Key "+i+" :"+key);
        return caesarCipher.decrypt(input);
    }
    public String join(String a,String b)
    {
        int i=0;
        StringBuilder sb=new StringBuilder();
        for(;i<b.length();i++)
        {
            sb.append(a.charAt(i));
            sb.append(b.charAt(i));
        }
        if(i<a.length())
            sb.append(a.charAt(i));
        return  sb.toString();
    }
    public static void main(String args[])
    {
        TestCaesarCipherTwo testCeasarCipherTwo= new TestCaesarCipherTwo();
        testCeasarCipherTwo.simpleTests();
    }
}
