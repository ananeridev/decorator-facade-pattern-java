package decorator.javaSwing;

import javax.swing.*;
import java.awt.*;

public class Client {

    public static void main(String[] args) {
        JFrame frame =new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(400,200);

		JTextArea textArea = new JTextArea(10, 30);
		frame.add(textArea);

//        JTextArea textArea = new JTextArea(10, 30);
        JScrollPane scroll = new JScrollPane(textArea,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        frame.add(scroll);

        frame.setVisible(true);
    }
}
