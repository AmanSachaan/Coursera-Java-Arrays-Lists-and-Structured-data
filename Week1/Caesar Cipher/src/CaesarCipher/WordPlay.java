package CaesarCipher;
import edu.duke.*;
public class WordPlay {
    public boolean isVowel(char ch) {
        String vowels="aeiouAEIOU";
        if (vowels.indexOf(ch) != -1) {
            return true;
        } else {
            return false;
        }
    }
    public String replaceVowels(String phrase, char ch) {
        StringBuilder newPhrase = new StringBuilder(phrase);
        String vowels="aeiouAEIOU";
        for (int i = 0; i < phrase.length(); i++) {
            if (vowels.indexOf((newPhrase.charAt(i))) != -1) {
                newPhrase.setCharAt(i, ch);
            }
        }
        return newPhrase.toString();
    }

    public String emphasize(String phrase, char ch) {
        StringBuilder newPhrase = new StringBuilder(phrase);
        for (int i = 0; i < phrase.length(); i++) {
            if (newPhrase.charAt(i) == ch) {
                if (i % 2 == 0) {
                    newPhrase.setCharAt(i, '*');
                }
                if (i % 2 == 1) {
                    newPhrase.setCharAt(i, '+');
                }
            }
        }
        return newPhrase.toString();
    }

    public void testIsVowel() {
        System.out.println("a:" + isVowel('a'));
        System.out.println("I:" + isVowel('I'));
        System.out.println("b:" + isVowel('b'));
        System.out.println("Z:" + isVowel('Z'));
    }
    public void testReplaceVowels() {
        System.out.println("Hello World with *: " + replaceVowels("Hello World", '*'));
        System.out.println("Live Long and Prosper with a : " + replaceVowels("Live Long and Prosper", 'a'));
    }
    public void testEmphasize() {
        System.out.println(emphasize("dna ctgaaactga", 'a'));
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }
    public static void main(String args[])
    {
        WordPlay wordPlay=new WordPlay();
        wordPlay.testIsVowel();
        wordPlay.testReplaceVowels();
        wordPlay.testEmphasize();
    }

}