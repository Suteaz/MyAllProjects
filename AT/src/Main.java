import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.AWTException;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
public class Main {
    public static Robot robot;

    static{
        try{
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static volatile boolean run = false;

    static void click(){
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(1/7);
    }

    public static void main(String[] args){
        Color pink = new Color(255, 136, 249);
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(275,230);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Artificial Timing");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.getContentPane().setBackground(new Color(15,15,15));

        Font font = new Font("Arial", Font.BOLD, 18);

        JLabel label = new JLabel("AT - Artificial Timing");
        label.setFont(font);
        label.setForeground(pink);
        label.setBounds(40,-85,275,230);

        JButton start = new JButton("Start");
        start.setFocusable(false);
        start.setFocusPainted(false);
        start.setBounds(20,60,100,100);
        start.setFont(font);
        start.setBackground(new Color(0, 0, 0));
        start.setForeground(pink);

        JButton stop = new JButton("Stop");
        stop.setFocusable(false);
        stop.setFocusPainted(false);
        stop.setBounds(140,60,100,100);
        stop.setFont(font);
        stop.setEnabled(false);
        stop.setBackground(new Color(0, 0, 0));
        stop.setForeground(pink);
        stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stop.setEnabled(false);
                start.setEnabled(true);
                run = false;
            }
        });

        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                start.setEnabled(false);
                stop.setEnabled(true);
                run = true;
                new Thread(() ->{
                    while (run){
                        click();
                    }
                }).start();
            }
        });

        frame.setVisible(true);
        frame.add(start);
        frame.add(stop);
        frame.add(label);
    }
}
