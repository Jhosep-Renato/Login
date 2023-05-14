package main;

import ui.Login;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(()->{
            Login login = new Login();
            JFrame frame = new JFrame();
            frame.setContentPane(login.getPanel());
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            login.getPanel().setPreferredSize(new Dimension(300, 300));
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.pack();
        });
    }
}
