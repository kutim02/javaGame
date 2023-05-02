import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Game4 extends JFrame implements ActionListener{

    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
    int counter = 200;
    JLabel counterLabel;
    int[] generated;
    Clip clip;
    Timer timer;
    Game4(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLayout(new BorderLayout());
        //clip = new Clip;
        try {
            //File URL relative to project folder
            AudioInputStream audioInputStream  = AudioSystem.getAudioInputStream(new File("music/music1.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(10);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            System.out.println("IO error");
        }

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Mode");
        JMenuItem three = new JMenuItem("3x3 mode");
        JMenuItem four = new JMenuItem("new 4x4 game");
        JMenuItem resign = new JMenuItem("Resign");
        JMenuItem shuffle = new JMenuItem("Shuffle");
        shuffle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Generate g = new Generate(16);
                generated = g.getGenerated();
                if (generated[1] == 0){
                    b1.setText(" ");
                }
                else {
                    b1.setText(Integer.toString(generated[1]));
                }

                if (generated[2] == 0){
                    b2.setText(" ");
                }
                else {
                    b2.setText(Integer.toString(generated[2]));
                }

                if (generated[3] == 0){
                    b3.setText(" ");
                }
                else {
                    b3.setText(Integer.toString(generated[3]));
                }

                if (generated[4] == 0){
                    b4.setText(" ");
                }
                else {
                    b4.setText(Integer.toString(generated[4]));
                }
                if (generated[5] == 0){
                    b5.setText(" ");
                }
                else {
                    b5.setText(Integer.toString(generated[5]));
                }

                if (generated[6] == 0){
                    b6.setText(" ");
                }
                else {
                    b6.setText(Integer.toString(generated[6]));
                }

                if (generated[7] == 0){
                    b7.setText(" ");
                }
                else {
                    b7.setText(Integer.toString(generated[7]));
                }

                if (generated[8] == 0){
                    b8.setText(" ");
                }
                else {
                    b8.setText(Integer.toString(generated[8]));
                }
                if (generated[9] == 0){
                    b9.setText(" ");
                }
                else {
                    b9.setText(Integer.toString(generated[9]));
                }
                if (generated[10] == 0){
                    b10.setText(" ");
                }
                else {
                    b10.setText(Integer.toString(generated[10]));
                }

                if (generated[11] == 0){
                    b11.setText(" ");
                }
                else {
                    b11.setText(Integer.toString(generated[11]));
                }

                if (generated[12] == 0){
                    b12.setText(" ");
                }
                else {
                    b12.setText(Integer.toString(generated[12]));
                }

                if (generated[13] == 0){
                    b13.setText(" ");
                }
                else {
                    b13.setText(Integer.toString(generated[13]));
                }
                if (generated[14] == 0){
                    b14.setText(" ");
                }
                else {
                    b14.setText(Integer.toString(generated[14]));
                }

                if (generated[15] == 0){
                    b15.setText(" ");
                }
                else {
                    b15.setText(Integer.toString(generated[15]));
                }

                if (generated[16] == 0){
                    b16.setText(" ");
                }
                else {
                    b16.setText(Integer.toString(generated[16]));
                }
            }
        });
        resign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    clip.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    AudioInputStream audioInputStream2  = AudioSystem.getAudioInputStream(new File("music/loser.wav"));
                    Clip clip2 = AudioSystem.getClip();
                    clip2.open(audioInputStream2);
                    clip2.start();
                } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e2) {
                    System.out.println("IO error");
                }
                JOptionPane.showMessageDialog(Game4.this, "YOU RESIGNED!\n" + " 0 points " );
            }
        });
        three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    clip.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                new Game();
                setVisible(false);
                dispose();
            }
        });
        four.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    clip.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                new Game4();
                setVisible(false);
                dispose();
            }
        });
        menu.add(three);
        menu.add(four);
        menuBar.add(menu);
        menuBar.add(resign);
        menuBar.add(shuffle);
        this.setJMenuBar(menuBar);

        setVisible(true);

        generated = new int[17];
        Generate g = new Generate(16);
        generated = g.getGenerated();
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        b10 = new JButton("10");
        b11 = new JButton("11");
        b12 = new JButton("12");
        b13 = new JButton("13");
        b14 = new JButton("14");
        b15 = new JButton(" ");
        b16 = new JButton("15");

        /*
        if (generated[1] == 0){
            b1 = new JButton(" ");
        }
        else {
            b1 = new JButton(Integer.toString(generated[1]));
        }

        if (generated[2] == 0){
            b2 = new JButton(" ");
        }
        else {
            b2 = new JButton(Integer.toString(generated[2]));
        }

        if (generated[3] == 0){
            b3 = new JButton(" ");
        }
        else {
            b3 = new JButton(Integer.toString(generated[3]));
        }

        if (generated[4] == 0){
            b4 = new JButton(" ");
        }
        else {
            b4 = new JButton(Integer.toString(generated[4]));
        }
        if (generated[5] == 0){
            b5 = new JButton(" ");
        }
        else {
            b5 = new JButton(Integer.toString(generated[5]));
        }

        if (generated[6] == 0){
            b6 = new JButton(" ");
        }
        else {
            b6 = new JButton(Integer.toString(generated[6]));
        }

        if (generated[7] == 0){
            b7 = new JButton(" ");
        }
        else {
            b7 = new JButton(Integer.toString(generated[7]));
        }

        if (generated[8] == 0){
            b8 = new JButton(" ");
        }
        else {
            b8 = new JButton(Integer.toString(generated[8]));
        }
        if (generated[9] == 0){
            b9 = new JButton(" ");
        }
        else {
            b9 = new JButton(Integer.toString(generated[9]));
        }

        if (generated[10] == 0){
            b10 = new JButton(" ");
        }
        else {
            b10 = new JButton(Integer.toString(generated[10]));
        }

        if (generated[11] == 0){
            b11 = new JButton(" ");
        }
        else {
            b11 = new JButton(Integer.toString(generated[11]));
        }

        if (generated[12] == 0){
            b12 = new JButton(" ");
        }
        else {
            b12 = new JButton(Integer.toString(generated[12]));
        }
        if (generated[13] == 0){
            b13 = new JButton(" ");
        }
        else {
            b13 = new JButton(Integer.toString(generated[13]));
        }

        if (generated[14] == 0){
            b14 = new JButton(" ");
        }
        else {
            b14 = new JButton(Integer.toString(generated[14]));
        }

        if (generated[15] == 0){
            b15 = new JButton(" ");
        }
        else {
            b15 = new JButton(Integer.toString(generated[15]));
        }

        if (generated[16] == 0){
            b16 = new JButton(" ");
        }
        else {
            b16 = new JButton(Integer.toString(generated[16]));
        }
        */
        counterLabel = new JLabel("200 points",SwingConstants.CENTER);

        Container contentPane = this.getContentPane();
        contentPane.add(counterLabel,BorderLayout.NORTH);
        Panel panel = new Panel();
        panel.setLayout(new GridLayout(4,4));
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(b10);
        panel.add(b11);
        panel.add(b12);
        panel.add(b13);
        panel.add(b14);
        panel.add(b15);
        panel.add(b16);
        add(panel,BorderLayout.CENTER);
        counterLabel.setBounds(145,15,200,200);

        b1.setBackground(new Color(187,250,156));
        b2.setBackground(new Color(187,250,156));
        b3.setBackground(new Color(187,250,156));
        b4.setBackground(new Color(187,250,156));
        b5.setBackground(new Color(187,250,156));
        b6.setBackground(new Color(187,250,156));
        b7.setBackground(new Color(187,250,156));
        b8.setBackground(new Color(187,250,156));
        b9.setBackground(new Color(187,250,156));
        b10.setBackground(new Color(187,250,156));
        b11.setBackground(new Color(187,250,156));
        b12.setBackground(new Color(187,250,156));
        b13.setBackground(new Color(187,250,156));
        b14.setBackground(new Color(187,250,156));
        b15.setBackground(new Color(187,250,156));
        b16.setBackground(new Color(187,250,156));

        b1.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b2.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b3.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b4.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b5.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b6.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b7.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b8.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b9.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b10.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b11.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b12.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b13.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b14.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b15.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b16.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        counterLabel.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);
        b16.addActionListener(this);

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (b1.getText().equals("1") && b2.getText().equals("2") && b3.getText()
                        .equals("3") && b4.getText().equals("4") && b5.getText().equals("5")
                        && b6.getText().equals("6") && b7.getText().equals("7") && b8.getText()
                        .equals("8") && b9.getText().equals("9") && b10.getText().equals("10") && b11.getText().equals("11") && b12.getText()
                        .equals("12") && b13.getText().equals("13") && b14.getText().equals("14")
                        && b15.getText().equals("15") && b16.getText().equals(" ")) {

                    try {
                        clip.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    try {
                        //File URL relative to project folder
                        AudioInputStream audioInputStream2  = AudioSystem.getAudioInputStream(new File("music/winner.wav"));
                        Clip clip2 = AudioSystem.getClip();
                        clip2.open(audioInputStream2);
                        clip2.start();
                    } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e2) {
                        System.out.println("IO error");
                    }
                    JOptionPane.showMessageDialog(Game4.this, "YOU WON!\n" + "Your points: " + counter);
                    timer.stop();
                }
            }
        });
        timer.start();
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1){
            String s1 = b1.getText();
            if(b2.getText().equals(" ")){ b2.setText(s1); b1.setText(" ");counter--;}
            else if(b5.getText().equals(" ")){ b5.setText(s1); b1.setText(" ");counter--;}
        }
        if(e.getSource() == b2){
            String s2=b2.getText();
            if(b1.getText().equals(" ")){ b1.setText(s2); b2.setText(" ");counter--;}
            else if(b3.getText().equals(" ")){ b3.setText(s2); b2.setText(" ");counter--;}
            else if(b6.getText().equals(" ")){ b6.setText(s2); b2.setText(" ");counter--;}
        }
        if(e.getSource() == b3){
            String s3=b3.getText();
            if(b2.getText().equals(" ")){ b2.setText(s3); b3.setText(" ");counter--;}
            else if(b7.getText().equals(" ")){ b7.setText(s3); b3.setText(" ");counter--;}
            else if(b4.getText().equals(" ")){ b4.setText(s3); b3.setText(" ");counter--;}
        }
        if(e.getSource() == b4){
            String s4=b4.getText();
            if(b3.getText().equals(" ")){ b3.setText(s4); b4.setText(" ");counter--;}
            else if(b8.getText().equals(" ")){ b8.setText(s4); b4.setText(" ");counter--;}
        }
        if(e.getSource() == b5){
            String s5=b5.getText();
            if(b1.getText().equals(" ")){ b1.setText(s5); b5.setText(" ");counter--;}
            else if(b9.getText().equals(" ")){ b9.setText(s5); b5.setText(" ");counter--;}
            else if(b6.getText().equals(" ")){ b6.setText(s5); b5.setText(" ");counter--;}
        }

        if(e.getSource() == b6){

            String s6=b6.getText();
            if(b2.getText().equals(" ")){ b2.setText(s6); b6.setText(" ");counter--;}
            else if(b7.getText().equals(" ")){ b7.setText(s6); b6.setText(" ");counter--;}
            else if(b5.getText().equals(" ")){ b5.setText(s6); b6.setText(" ");counter--;}
            else if(b10.getText().equals(" ")){ b10.setText(s6); b6.setText(" ");counter--;}

        }
        if(e.getSource() == b7){
            String s7=b7.getText();
            if(b3.getText().equals(" ")){ b3.setText(s7); b7.setText(" ");counter--;}
            else if(b8.getText().equals(" ")){ b8.setText(s7); b7.setText(" ");counter--;}
            else if(b6.getText().equals(" ")){ b6.setText(s7); b7.setText(" ");counter--;}
            else if(b11.getText().equals(" ")){ b11.setText(s7); b7.setText(" ");counter--;}

        }
        if(e.getSource() == b8){
            String s8=b8.getText();
            if(b7.getText().equals(" ")){ b7.setText(s8); b8.setText(" ");counter--;}
            else if(b4.getText().equals(" ")){ b4.setText(s8); b8.setText(" ");counter--;}
            else if(b12.getText().equals(" ")){ b12.setText(s8); b8.setText(" ");counter--;}
        }
        if(e.getSource() == b9) {
            String s9 = b9.getText();
            if (b5.getText().equals(" ")) {b5.setText(s9);b9.setText(" ");counter--;
            } else if (b10.getText().equals(" ")) {b10.setText(s9);b9.setText(" ");counter--;
            } else if (b13.getText().equals(" ")) {b13.setText(s9);b9.setText(" ");counter--;}
        }
        if(e.getSource() == b10){
            String s10=b10.getText();
            if(b6.getText().equals(" ")){ b6.setText(s10); b10.setText(" ");counter--;}
            else if(b9.getText().equals(" ")){ b9.setText(s10); b10.setText(" ");counter--;}
            else if(b14.getText().equals(" ")){ b14.setText(s10); b10.setText(" ");counter--;}
            else if(b11.getText().equals(" ")){ b11.setText(s10); b10.setText(" ");counter--;}
        }
        if(e.getSource() == b11){
            String s11=b11.getText();
            if(b7.getText().equals(" ")){ b7.setText(s11); b11.setText(" ");counter--;}
            else if(b10.getText().equals(" ")){ b10.setText(s11); b11.setText(" ");counter--;}
            else if(b12.getText().equals(" ")){ b12.setText(s11); b11.setText(" ");counter--;}
            else if(b15.getText().equals(" ")){ b15.setText(s11); b11.setText(" ");counter--;}
        }
        if(e.getSource() == b12){
            String s12=b12.getText();
            if(b11.getText().equals(" ")){ b11.setText(s12); b12.setText(" ");counter--;}
            else if(b8.getText().equals(" ")){ b8.setText(s12); b12.setText(" ");counter--;}
            else if(b16.getText().equals(" ")){ b16.setText(s12); b12.setText(" ");counter--;}
        }
        if(e.getSource() == b13){
            String s13=b13.getText();
            if(b9.getText().equals(" ")){ b9.setText(s13); b13.setText(" ");counter--;}
            else if(b14.getText().equals(" ")){ b14.setText(s13); b13.setText(" ");counter--;}
        }
        if(e.getSource() == b14){
            String s14=b14.getText();
            if(b13.getText().equals(" ")){ b13.setText(s14); b14.setText(" ");counter--;}
            else if(b10.getText().equals(" ")){ b10.setText(s14); b14.setText(" ");counter--;}
            else if(b15.getText().equals(" ")){ b15.setText(s14); b14.setText(" ");counter--;}
        }
        if(e.getSource() == b15){
            String s15=b15.getText();
            if(b14.getText().equals(" ")){ b14.setText(s15); b15.setText(" ");counter--;}
            else if(b11.getText().equals(" ")){ b11.setText(s15); b15.setText(" ");counter--;}
            else if(b16.getText().equals(" ")){ b16.setText(s15); b15.setText(" ");counter--;}
        }
        if(e.getSource() == b16) {
            String s16 = b16.getText();
            if (b15.getText().equals(" ")) { b15.setText(s16);b16.setText(" ");counter--;
            } else if (b12.getText().equals(" ")) {b12.setText(s16);b16.setText(" ");counter--;}
        }
        counterLabel.setText(Integer.toString(counter) + " points");
    }
}


