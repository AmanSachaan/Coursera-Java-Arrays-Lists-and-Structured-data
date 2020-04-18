package ArrayList;
import edu.duke.FileResource;
import java.util.ArrayList;
public class CharactersInPlay {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    CharactersInPlay()
    {
        myWords= new ArrayList<>();
        myFreqs= new ArrayList<>();
    }
    public void update(String person)
    {
        int index = myWords.indexOf(person);
        if (index == -1) {
            myWords.add(person);
            myFreqs.add(1);
        } else {
            myFreqs.set(index, myFreqs.get(index) + 1);
        }
    }
    public void findAllCharacters()
    {
        FileResource fileResource= new FileResource();
        myFreqs.clear();
        myWords.clear();
        for(String line:fileResource.lines())
        {
            int index=line.indexOf(".");
            if(index>0)
                update(line.substring(0,index).trim());
        }
    }
    public void displayCharacters()
    {
        for(int i=0;i<myFreqs.size();i++)
        {
            System.out.println(myWords.get(i)+"\t :  "+myFreqs.get(i));
        }
    }
    public void charactersWithNumParts(int num1,int num2)
    {
        for(int i=0;i<myFreqs.size();i++)
        {
            if(myFreqs.get(i)>num1 && myFreqs.get(i)<num2)
                System.out.println(myWords.get(i)+"\t :  "+myFreqs.get(i));
        }
    }
    public void tester()
    {
        findAllCharacters();
        displayCharacters();
        charactersWithNumParts(1,4);
    }
    public static void main(String args[])
    {
        CharactersInPlay charactersInPlay= new CharactersInPlay();
        charactersInPlay.tester();
    }
}