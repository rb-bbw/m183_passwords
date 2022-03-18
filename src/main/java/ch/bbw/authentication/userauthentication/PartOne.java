package ch.bbw.authentication.userauthentication;

import java.util.Arrays;

public class PartOne {
    public static void main(String[] args) {
        System.out.println(getRandomPW(12));
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
}
