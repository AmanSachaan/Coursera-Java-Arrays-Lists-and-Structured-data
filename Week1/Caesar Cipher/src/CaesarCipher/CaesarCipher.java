package CaesarCipher;
import edu.duke.*;
public class CaesarCipher {
    public String encrypt(String input, int key) {

        StringBuilder encrypted = new StringBuilder(input);
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lettersShifted = letters.substring(key) + letters.substring(0, key);

        for (int i = 0; i < encrypted.length(); i++) {

            char currChar = encrypted.charAt(i);
            if (Character.isLowerCase(currChar)) {
                currChar = Character.toUpperCase(currChar);
                if (letters.indexOf(currChar) != -1) {
                    int index = letters.indexOf(currChar);
                    encrypted.setCharAt(i, Character.toLowerCase(lettersShifted.charAt(index)));
                }
            } else {
                if (letters.indexOf(currChar) != -1) {
                    int index = letters.indexOf(currChar);
                    encrypted.setCharAt(i, lettersShifted.charAt(index));
                }

            }
        }
        return encrypted.toString();
    }

    public String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encryptedWithKey1 = new StringBuilder();
        StringBuilder encryptedWithKey2 = new StringBuilder();
        StringBuilder encryptedWithKey1andkey2 = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0)
                encryptedWithKey1.append(input.charAt(i));
            else
                encryptedWithKey2.append(input.charAt(i));
        }

        String encryptKey1 = encrypt(encryptedWithKey1.toString(), key1);
        String encryptKey2 = encrypt(encryptedWithKey2.toString(), key2);
        int length1 = encryptKey1.length();
        int length2 = encryptKey2.length();
        int i = 0;
        for (i = 0; i < Math.min(length1, length2); i++) {
            encryptedWithKey1andkey2.append(encryptKey1.charAt(i));
            encryptedWithKey1andkey2.append(encryptKey2.charAt(i));
        }

        if ((length1 > length2)) {
            encryptedWithKey1andkey2.append(encryptKey1.charAt(i));
        }
        else if(length1<length2) {
            encryptedWithKey1andkey2.append(encryptKey1.charAt(i));
        }
        return encryptedWithKey1andkey2.toString();

    }

    public void testEncrypt() {
        System.out.println(encrypt("First Legion", 17));
        System.out.println(encrypt("My name is Aman", 23));


    }

    public void testEncryptTwoKeys() {

       System.out.println(encryptTwoKeys("My name is Aman", 23, 17));
       System.out.println(encryptTwoKeys("This is Coursera Assignment", 3, 8));


    }

    public static void main(String args[]) {
        CaesarCipher caesarCipher = new CaesarCipher();
        System.out.println("testing encrypt");
        caesarCipher.testEncrypt();
        System.out.println("\ntesting encrypt two keys");
        caesarCipher.testEncryptTwoKeys();

    }
}