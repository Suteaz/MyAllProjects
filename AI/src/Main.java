import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("AI Chat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        Font font = new Font("Arial", Font.PLAIN, 20);

        JLabel label1 = new JLabel("Введите вопрос");
        label1.setFont(font);
        label1.setBounds(280, 40,240,40);
        frame.add(label1);

        JTextField user_message = new JTextField();
        user_message.setBounds(280,70,240,40);
        user_message.setFont(font);
        frame.add(user_message);

        JLabel label2 = new JLabel("Введите ответ");
        label2.setFont(font);
        label2.setBounds(280,130,240,40);
        frame.add(label2);

        JTextField AI_message = new JTextField();
        AI_message.setBounds(280,160,240,40);
        AI_message.setFont(font);
        frame.add(AI_message);

        JButton add_button = new JButton("Обучить");
        add_button.setFont(font);
        add_button.setBounds(280,230,240,50);
        add_button.setFocusable(false);
        add_button.setFocusable(false);
        add_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("click!");
            }
        });
        frame.add(add_button);

        JLabel ac_text = new JLabel("AI Chat");
        ac_text.setFont(font);
        ac_text.setBounds(365,300,240,40);
        frame.add(ac_text);

        JTextField user_chat_message = new JTextField();
        user_chat_message.setBounds(280,350,240,40);
        user_chat_message.setFont(font);
        frame.add(user_chat_message);

        JButton inp = new JButton("Отправить");
        inp.setFont(font);
        inp.setBounds(280,400,240,50);
        inp.setFocusable(false);
        inp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("123");
            }
        });
        frame.add(inp);

        JTextField AI_inp = new JTextField();
        AI_inp.setBounds(280,460,240,40);
        AI_inp.setFont(font);
        AI_inp.setBackground(new Color(255, 255, 255));
        AI_inp.setEditable(false);
        frame.add(AI_inp);

        frame.setVisible(true);
    }
}