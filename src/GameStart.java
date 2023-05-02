import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class GameStart extends JFrame implements ActionListener {
    JLabel label;
    JButton b1;
    JButton b2;
    GameStart() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);

        setLayout(new GridLayout(3,1));
        label = new JLabel("Valassz jatekfajtat: ",SwingConstants.CENTER);
        label.setBounds(100,60,500,100);
        b1 = new JButton("3x3 mod");
        b2 = new JButton("4x4 mod");
        b1.setBackground(new Color(187,250,156));
        b2.setBackground(new Color(187,250,156));
        b1.setBounds(90,150,100,100);
        b2.setBounds(250,150,100,100);
        label.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b1.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b2.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        add(label);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1){
            Game g =new Game();
            setVisible(false);
            dispose();
        }
        if(e.getSource() == b2) {
            new Game4();
            setVisible(false);
            dispose();
        }
    }
}



