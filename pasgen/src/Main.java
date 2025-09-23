import java.security.SecureRandom;
import java.util.Random;
public class Main {
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String CHAR_DIGITS = "0123456789";
    private static final String CHAR_SYMBOL = "!@#$%^&*()_+-=[]{};':\",.<>/?";

    private static final int LENGTH = 12;

    public static void main(String[] args) {
        String password = generatePassword();
        System.out.println(password);
    }
    public static String generatePassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        String ALL_CHARS = CHAR_LOWER + CHAR_UPPER + CHAR_DIGITS + CHAR_SYMBOL;
        int len = ALL_CHARS.length();
        for (int i = 0; i < len; i++) {

        }
    }
}
