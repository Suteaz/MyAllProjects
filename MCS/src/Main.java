import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static final String key = "ez";
    public static boolean unlock = false;
    static void Enter(){
        while (unlock == false){
            JPasswordField passwordField = new JPasswordField();
            String user_inp_pass = JOptionPane.showInputDialog(null,"Enter key");
            if (!user_inp_pass.equals(key)){
                JOptionPane.showMessageDialog(null, "Key is incorrect");
            } else if (user_inp_pass.equals(key)){
                unlock = true;
            }
        }
    }
    public static void main(String[] args) {
        //Enter();
        //вход
        /*
        String user_inp_pass = JOptionPane.showInputDialog(null, "Enter password");
        if (user_inp_pass.equals(password)){
            frame.setVisible(true);
        } else{
            JOptionPane.showMessageDialog(null, "password is incorrect");
        }*/
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(15,15,15));
        frame.setTitle("MCS");

        Color BG = new Color(5,5,5);
        Color pur = new Color(75,125,255);

        Font bt = new Font("Arial", Font.BOLD, 20);
        Font nv = new Font("Arial", Font.BOLD, 20);

        JLabel name_ver = new JLabel("MCS Beta Version 1.0");
        name_ver.setFont(nv);
        name_ver.setBounds(0, 5, 380, 30);
        name_ver.setHorizontalAlignment(SwingConstants.CENTER);
        name_ver.setForeground(pur);

        JButton start = new JButton("Start");
        start.setFocusPainted(false);
        start.setFont(bt);
        start.setBounds(25, 45, 150, 100);
        start.setBackground(BG);
        start.setForeground(pur);
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(frame, "Click");
            }
        });

        JButton stop = new JButton("Stop");
        stop.setFocusPainted(false);
        stop.setFont(bt);
        stop.setBounds(205, 45, 150, 100);
        stop.setBackground(BG);
        stop.setForeground(pur);

        frame.add(start);
        frame.add(stop);
        frame.add(name_ver, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
