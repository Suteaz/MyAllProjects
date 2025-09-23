import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static boolean open2 = false;
    public static final Color CBlack = new Color(10, 10, 10);
    public static final Color CBlack1 = new Color(20, 20, 20);
    public static void main(String[] args){
        JFrame frame1 = new JFrame();
        frame1.getContentPane().setBackground(CBlack);
        frame1.setTitle("Page 1");
        JButton button1 = new JButton();
        button1.setText("Page 2");
        button1.setBackground(CBlack1);
        button1.setForeground(Color.WHITE);
        button1.setBorder(null);
        button1.setFocusPainted(false);
        frame1.setLayout(null);
        button1.setBounds(100, 140, 200, 60);
        frame1.add(button1);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(400, 400);
        frame1.setVisible(true);

        JFrame frame2 = new JFrame();
        frame2.setTitle("Page 2");
        frame2.setLayout(new FlowLayout());
        frame2.setSize(400, 400);
        frame2.getContentPane().setBackground(CBlack);
        frame2.setVisible(false);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (open2 == false){
                    open2 = true;
                    frame2.setVisible(true);
                } else {
                    open2 = false;
                    frame2.setVisible(false);
                }
            }
        });
    }
}
