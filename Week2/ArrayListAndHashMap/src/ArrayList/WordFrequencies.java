package ArrayList;
import edu.duke.FileResource;
import java.util.ArrayList;
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    WordFrequencies()
    {
        myWords= new ArrayList<>();
        myFreqs= new ArrayList<>();
    }
    public void findUnique() {
        myFreqs.clear();
        myWords.clear();
        FileResource fileResource = new FileResource();
        for (String words : fileResource.words()) {
            int index = myWords.indexOf(words);
            if (index == -1) {
                myWords.add(words);
                myFreqs.add(1);
            } else {
                myFreqs.set(index, myFreqs.get(index) + 1);
            }
        }
    }
    public int findIndexOfMax()
    {
        int freq=0,indexmax=-1;
        for(int i=0;i<myFreqs.size();i++)
        {
            if(freq<myFreqs.get(i))
            {
                freq=myFreqs.get(i);
                indexmax=i;
            }
        }
        return indexmax;
    }
    public void tester()
    {
        findUnique();
        System.out.println("Number of unique words :"+myFreqs.size());
        for(int i=0;i<myFreqs.size();i++)
        {
            System.out.println(myFreqs.get(i)+"\t"+myWords.get(i));
        }
        int maxIndex=findIndexOfMax();
        System.out.println("Max ocuured word is :"+myWords.get(maxIndex)+"\t freq :"+myFreqs.get(maxIndex));
    }
    public static  void main(String rgs[])
    {
        WordFrequencies wordFrequencies= new WordFrequencies();
        wordFrequencies.tester();
    }
}