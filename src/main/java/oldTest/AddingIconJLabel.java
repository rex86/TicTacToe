package oldTest;


import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class AddingIconJLabel {


  public static void main(String[] args) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame();
    frame.setTitle("JLabel Test");
    frame.setLayout(new FlowLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension (200,200));

    URL urlImage = AddingIconJLabel.class.getResource("/skydive.gif");
    ImageIcon imageIcon = new ImageIcon(urlImage);

    JLabel label = new JLabel("Teszt");
    label.setOpaque(true);
    label.setIcon(imageIcon);
    label.setSize(50, 50);
    frame.revalidate();
    frame.repaint();
    frame.add(label);
    frame.pack();
    frame.setVisible(true);
  }
}