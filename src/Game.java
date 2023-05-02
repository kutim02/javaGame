import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Game extends JFrame implements ActionListener{

    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    int counter = 200;
    JLabel counterLabel;
    int[] generated;
    Clip clip;
    Clip clip2;
    Timer timer;
    Game(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(700,700);
        setLayout(new BorderLayout());

        try {
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
        JMenuItem menu2 = new JMenuItem("Resign");
        JMenuItem three = new JMenuItem("new 3x3 game");
        JMenuItem four = new JMenuItem("4x4 mode");
        JMenuItem shuffle = new JMenuItem("Shuffle");
        shuffle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Generate g = new Generate(9);
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
            }
        });
        menu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    clip.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    //File URL relative to project folder
                    AudioInputStream audioInputStream2  = AudioSystem.getAudioInputStream(new File("music/loser.wav"));
                    Clip clip2 = AudioSystem.getClip();
                    clip2.open(audioInputStream2);
                    clip2.start();
                } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e2) {
                    System.out.println("IO error");
                }
                JOptionPane.showMessageDialog(Game.this, "YOU RESIGNED!\n" + "0 points");

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
        menu.add(three);
        menu.add(four);
        menuBar.add(menu);
        menuBar.add(menu2);
        menuBar.add(shuffle);
        this.setJMenuBar(menuBar);



        generated = new int[10];
        Generate g = new Generate(9);
        generated = g.getGenerated();
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
/*
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton(" ");
        b9 = new JButton("8");
*/
        counterLabel = new JLabel("200 points",SwingConstants.CENTER);

        Container contentPane = this.getContentPane();
        contentPane.add(counterLabel,BorderLayout.NORTH);
        Panel panel = new Panel();
        panel.setLayout(new GridLayout(3,3));
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        add(panel,BorderLayout.CENTER);
        b1.setBounds(90,60,50,40);
        b2.setBounds(160,60,50,40);
        b3.setBounds(230,60,50,40);
        b4.setBounds(90,115,50,40);
        b5.setBounds(160,115,50,40);
        b6.setBounds(230,115,50,40);
        b7.setBounds(90,170,50,40);
        b8.setBounds(160,170,50,40);
        b9.setBounds(230,170,50,40);
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

        b1.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b2.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b3.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b4.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b5.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b6.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b7.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b8.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
        b9.setFont(new Font(Font.DIALOG, Font.ITALIC, 20));
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

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (b1.getText().equals("1") && b2.getText().equals("2") && b3.getText()
                        .equals("3") && b4.getText().equals("4") && b5.getText().equals("5")
                        && b6.getText().equals("6") && b7.getText().equals("7") && b8.getText()
                        .equals("8") && b9.getText().equals(" ")) {

                    try {
                        clip.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    try {
                        //File URL relative to project folder
                        AudioInputStream audioInputStream2  = AudioSystem.getAudioInputStream(new File("music/winner.wav"));
                        clip2 = AudioSystem.getClip();
                        clip2.open(audioInputStream2);
                        clip2.start();
                    } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e2) {
                        System.out.println("IO error");
                    }
                    JOptionPane.showMessageDialog(Game.this, "YOU WON!\n" + counter + " points");

                    timer.stop();
                }
            }
        });
        timer.start();

        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){
            if(e.getSource() == b1){
                String s1 = b1.getText();
                if(b2.getText().equals(" ")){ b2.setText(s1); b1.setText(" ");counter--;}
                else if(b4.getText().equals(" ")){ b4.setText(s1); b1.setText(" ");counter--;}
            }
            if(e.getSource() == b2){
                String s2=b2.getText();
                if(b1.getText().equals(" ")){ b1.setText(s2); b2.setText(" ");counter--;}
                else if(b3.getText().equals(" ")){ b3.setText(s2); b2.setText(" ");counter--;}
                else if(b5.getText().equals(" ")){ b5.setText(s2); b2.setText(" ");counter--;}
            }
            if(e.getSource() == b3){
                String s3=b3.getText();
                if(b2.getText().equals(" ")){ b2.setText(s3); b3.setText(" ");counter--;}
                else if(b6.getText().equals(" ")){ b6.setText(s3); b3.setText(" ");counter--;}
            }
            if(e.getSource() == b4){
                String s4=b4.getText();
                if(b1.getText().equals(" ")){ b1.setText(s4); b4.setText(" ");counter--;}
                else if(b7.getText().equals(" ")){ b7.setText(s4); b4.setText(" ");counter--;}
                else if(b5.getText().equals(" ")){ b5.setText(s4); b4.setText(" ");counter--;}
            }
            if(e.getSource() == b5){
                String s5=b5.getText();
                if(b2.getText().equals(" ")){ b2.setText(s5); b5.setText(" ");counter--;}
                else if(b4.getText().equals(" ")){ b4.setText(s5); b5.setText(" ");counter--;}
                else if(b6.getText().equals(" ")){ b6.setText(s5); b5.setText(" ");counter--;}
                else if(b8.getText().equals(" ")){ b8.setText(s5); b5.setText(" ");counter--;}
            }

            if(e.getSource() == b6){

                String s6=b6.getText();
                if(b9.getText().equals(" ")){ b9.setText(s6); b6.setText(" ");counter--;}
                else if(b3.getText().equals(" ")){ b3.setText(s6); b6.setText(" ");counter--;}
                else if(b5.getText().equals(" ")){ b5.setText(s6); b6.setText(" ");counter--;}

            }
            if(e.getSource() == b7){
                String s7=b7.getText();
                if(b4.getText().equals(" ")){ b4.setText(s7); b7.setText(" ");counter--;}
                else if(b8.getText().equals(" ")){ b8.setText(s7); b7.setText(" ");counter--;}

            }
            if(e.getSource() == b8){
                String s8=b8.getText();
                if(b7.getText().equals(" ")){ b7.setText(s8); b8.setText(" ");counter--;}
                else if(b9.getText().equals(" ")){ b9.setText(s8); b8.setText(" ");counter--;}
                else if(b5.getText().equals(" ")){ b5.setText(s8); b8.setText(" ");counter--;}
            }
            if(e.getSource() == b9) {
                String s9 = b9.getText();
                if (b6.getText().equals(" ")) {
                    b6.setText(s9);
                    b9.setText(" ");
                    counter--;
                } else if (b8.getText().equals(" ")) {
                    b8.setText(s9);
                    b9.setText(" ");
                    counter--;
                }
            }

            counterLabel.setText(counter + " points");
        }

    }

