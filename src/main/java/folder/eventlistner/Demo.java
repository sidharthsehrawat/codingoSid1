package folder.eventlistner;

import javax.swing.*;
import java.awt.event.*;

public class Demo {
    public static void main(String[] args) {
        JButton button = new JButton("Click");
        button.addActionListener(e -> {
            System.out.println("Clicked! Command=" + e.getActionCommand() + ", when=" + e.getWhen());
        });

        JFrame f = new JFrame("Listener Demo");
        f.add(button);
        f.setSize(250, 120);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}