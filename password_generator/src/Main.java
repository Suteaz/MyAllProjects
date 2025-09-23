import java.security.SecureRandom;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String yellow = "\u001B[38;2;255;255;0m";
        //String green = "\u001B[38;2;0;255;0m";
        String cyan = "\u001B[38;2;135;206;235m";
        String white = "\u001B[37m";
        Scanner scanner = new Scanner(System.in);
        System.out.print(cyan + "OSC Password Generator\n");
        System.out.print(white + "Введите длину пароля: " + yellow);
        int length = scanner.nextInt();
        System.out.print(white + "Введите количество паролей: " + yellow);
        int count = scanner.nextInt();
        for (int w = 0; w < count; w++) {
            System.out.println(cyan + generatePassword(length) + white);
        }
    }
    static String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890#$%&'()*+,-./:;<=>?@[\\]^_`{|}";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(chars.length());
            password.append(chars.charAt(randomIndex));
        }
        return password.toString();
    }
}