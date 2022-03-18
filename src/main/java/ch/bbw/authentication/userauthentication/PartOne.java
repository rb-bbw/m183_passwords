package ch.bbw.authentication.userauthentication;

public class PartOne {
    public static void main(String[] args) {
        System.out.println(generatePWFromTemplate());
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
        String pw = "";
        for (int i = 0; i < 3; i++) {
            pw += getRandomPW(4) + "-";
        }

        return pw.substring(0, pw.length() - 1);
    }
}
