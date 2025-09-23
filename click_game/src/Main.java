import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static int number = 0;
    public static void main(String[] args) {
        Random random = new Random();
        Color cyan = new Color(173, 255, 47);
        Color black = new Color(10, 10, 10);
        Color black1 = new Color(15, 15, 15);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Click Mania");
        frame.getContentPane().setBackground(black);

        Font font = new Font("Arial", Font.PLAIN, 45);
        Font font2 = new Font("Arial", Font.PLAIN, 32);
        Font font3 = new Font("Arial", Font.PLAIN, 20);

        JLabel label = new JLabel();
        label.setBounds(0, -175, 800, 600);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setText("0");
        label.setFont(font);
        label.setForeground(cyan);
        frame.add(label);

        JButton promo = new JButton("Enter promocode");
        promo.setForeground(cyan);
        promo.setBounds(0, 0, 275, 70);
        promo.setFocusable(false);
        promo.setFont(font3);
        promo.setBackground(black1);
        promo.setForeground(cyan);
        promo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user_promo = JOptionPane.showInputDialog("Enter promocode:");
                boolean game_promo_state = false;
                boolean click_promo_state = false;
                boolean luck_promo_state = false;
                if (user_promo.equals("game")) {
                    //game_promo_state = true;
                    number = number + 250;
                    label.setText(String.valueOf(number));
                    JOptionPane.showMessageDialog(null, "Successfully!");
                } else if (user_promo.equals("click")) {
                    number = number + 500;
                    label.setText(String.valueOf(number));
                    JOptionPane.showMessageDialog(null, "Successfully!");
                } else if (user_promo.equals("luck")) {
                    int RandomInt = random.nextInt(10000);
                    number = number + RandomInt;
                    label.setText(String.valueOf(number));
                    JOptionPane.showMessageDialog(null, "Successfully!");
                } else{
                    JOptionPane.showMessageDialog(null, "Invalid promocode!");
                }
            }
        });
        frame.add(promo);

        JButton auth = new JButton("Authors");
        auth.setForeground(cyan);
        auth.setBounds(285, 0, 275, 70);
        auth.setFocusable(false);
        auth.setFont(font3);
        auth.setBackground(black1);
        auth.setForeground(cyan);
        auth.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame avt = new JFrame();
                avt.setSize(400, 300);
                avt.setLayout(null);
                avt.setLocationRelativeTo(null);
                avt.setTitle("Authors");
                avt.getContentPane().setBackground(black);
                avt.setVisible(true);
                Font avtt = new Font("Arial", Font.PLAIN, 64);
                JLabel au = new JLabel();
                au.setText("Suteaz");
                au.setBounds(0,0,400,300);
                au.setHorizontalAlignment(SwingConstants.CENTER);
                au.setVerticalAlignment(SwingConstants.CENTER);
                au.setFont(avtt);
                au.setForeground(cyan);
                avt.add(au);
            }
        });
        frame.add(auth);

        JButton button = new JButton("Click Me");
        button.setForeground(cyan);
        button.setBounds(300, 200, 200, 200);
        button.setFocusable(false);
        button.setFont(font2);
        button.setBackground(black1);
        button.setForeground(cyan);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                number++;
                label.setText(String.valueOf(number));
            }
        });
        frame.add(button);
        }
}
