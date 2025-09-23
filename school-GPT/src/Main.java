import java.util.Scanner;
import java.util.HashMap;
public class Main{
    public static boolean gpt = true;
    public static HashMap<String, String> responses = new HashMap<>();
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chat-GPT");
        while (gpt){
            System.out.print("> ");
            responses.put("привет", "Привет, я chat-gpt, чем я могу вам помочь?");
            responses.put("алгебра", "Алгебра - это отдел математики, изучающий свойства величин (выраженных буквами), независимо от числового их значения.");
            responses.put("пока", "Пока!");
            String userInput = scanner.nextLine().toLowerCase();
            boolean found = false;
            for (String key : responses.keySet()) {
                if (userInput.contains(key)) {
                    System.out.println(responses.get(key));
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Я не понял ваш вопрос, попробуйте задать его снова.");
            }

            if (userInput.equals("пока")) {
                gpt = false;
            }
        }
        scanner.close();
        }
    }
}
