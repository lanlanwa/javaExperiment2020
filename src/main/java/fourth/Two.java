package fourth;

import javax.swing.*;
import java.awt.*;

/**
 * @author ZD
 * @date 2020-09-16 17:44
 */
public class Two {
    public static void main(String[] args) {
        Frame frame = new Frame("简单计算器");
        frame.setSize(500,300);
        frame.setLayout(new BorderLayout());

        Panel panel1 = new Panel();
        panel1.add(new TextField(60));
        frame.add(panel1, BorderLayout.NORTH);

        Panel panel2 = new Panel();
        panel2.setLayout(new GridLayout(5, 4));

        panel2.add(new JButton("C"));
        panel2.add(new JButton("CE"));
        panel2.add(new JButton("/"));
        panel2.add(new JButton("←"));
        panel2.add(new JButton("7"));
        panel2.add(new JButton("8"));
        panel2.add(new JButton("9"));
        panel2.add(new JButton("*"));
        panel2.add(new JButton("4"));
        panel2.add(new JButton("5"));
        panel2.add(new JButton("6"));
        panel2.add(new JButton("-"));
        panel2.add(new JButton("1"));
        panel2.add(new JButton("2"));
        panel2.add(new JButton("3"));
        panel2.add(new JButton("+"));
        panel2.add(new JButton("%"));
        panel2.add(new JButton("0"));
        panel2.add(new JButton("."));
        panel2.add(new JButton("="));

        frame.add(panel2, BorderLayout.CENTER);

//        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
