package CaesarCipher;
import edu.duke.FileResource;

import java.util.LinkedList;

public class WordsLength {
    public void countWordLength(FileResource res, int count[]) {
        String list[]=new String[31];
        LinkedList strList=new LinkedList();
        for(int i=0;i<31;i++)
        {
            strList.add(new LinkedList());
        }
        int length = 0, largestlengthword = 0;
        for (String word : res.words()) {
            length = word.length();

            if (!Character.isLetter(word.charAt(0)) )
                length--;
            if(!Character.isLetter(word.charAt(length - 1)))
                length--;
            count[length] = count[length] + 1;
        }


        for(int i=0;i<count.length;i++)
        {
                if(count[i]!=0)
                System.out.print(count[i]+" word of "+"length "+i+"\n");
        }
        System.out.println("most common word length: "+indexOfMax(count));
}
    public void testCountWordLengths()
    {
        FileResource fr= new FileResource();
        int count[]=new int[31];
        countWordLength(fr,count);
    }

    public int indexOfMax(int []count)
    {
        int max=-1;
        for(int i=0;i<count.length;i++)
        {
            if(max<count[i])
                max=count[i];
        }
        return max;
    }

    public static void main(String args[])
    {
        WordsLength wordsLength = new WordsLength();
        wordsLength.testCountWordLengths();
    }
}