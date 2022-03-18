package ch.bbw.authentication.userauthentication;

import java.util.Random;

public class PartOne {
    public static void main(String[] args) {
        System.out.println(generatePWFromPhrase("This is eine 123 Tst @Prh 123"));
    }
    private static String getRandomPW(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890+*%&/()=?@";
        int charLen = chars.length();
        char[] pw = new char[length];

        for (int i = 0; i < length; i++) {
            pw[i] = chars.charAt((int) (Math.random() * charLen));
        }

        return new String(pw);
    }
    private static String generatePWFromTemplate() {
        StringBuilder pw = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            pw.append(getRandomPW(4)).append("-");
        }

        return pw.deleteCharAt(pw.length()-1).toString();
    }
    private static String generatePWFromPhrase(String phrase) {
        StringBuilder pw = new StringBuilder();
        String[] words = phrase.split(" ");

        for (String word : words) {
            try {
                int number = Integer.parseInt(word);
                pw.append(number);
            } catch (NumberFormatException ex) {
                pw.append(word.charAt(0));
            }
        }

        return pw.toString();
    }
}
