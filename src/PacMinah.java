import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.*;

public class PacMinah extends JFrame implements ActionListener {

    private final int SWIDTH = 900;
    private final int SHEIGHT = 700;
    private JButton btnStart, btnExit, btnRestart;
    private JButton btnLeft, btnRight, btnUp, btnDown;
    private GamePanel gameP = new GamePanel();

    public PacMinah() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Pac Minah v1.0 - By Alister Animesh Baroi 0340938");
        setSize(SWIDTH, SHEIGHT);
        setLayout(null);
    }

    public void init() {
        gameP.setBounds(25, 25, 600, 630);
        add(gameP);

        btnStart = new JButton("START");
        btnStart.setBounds(650, 150, 100, 25);
        btnStart.addActionListener(this);
        add(btnStart);

        btnRestart = new JButton("RESTART");
        btnRestart.setBounds(762, 150, 100, 25);
        btnRestart.addActionListener(this);
        add(btnRestart);

        btnLeft = new JButton("LEFT");
        btnLeft.setBounds(650, 250, 100, 25);
        btnLeft.addActionListener(this);
        add(btnLeft);

        btnRight = new JButton("RIGHT");
        btnRight.setBounds(750, 250, 100, 25);
        btnRight.addActionListener(this);
        add(btnRight);

        btnUp = new JButton("UP");
        btnUp.setBounds(700, 225, 100, 25);
        btnUp.addActionListener(this);
        add(btnUp);

        btnDown = new JButton("DOWN");
        btnDown.setBounds(700, 275, 100, 25);
        btnDown.addActionListener(this);
        add(btnDown);

        JLabel labName = new JLabel("Tip: Use keyboard arrow keys");
        labName.setBounds(655, 310, 200, 25);
        add(labName);

        btnExit = new JButton("EXIT");
        btnExit.setBounds(650, 350, 200, 25);
        btnExit.addActionListener(this);
        add(btnExit);

        setVisible(true);
        File soundFile = new File("src/alister.wav").getAbsoluteFile();
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
            Clip myClip = AudioSystem.getClip();
            myClip.open(ais);
            myClip.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnExit) {
            System.exit(0);
        } else if (e.getSource() == btnStart) {
            gameP.startTimer();
        } else if (e.getSource() == btnRestart) {
            gameP.reset();
        } else if (e.getSource() == btnLeft) {
            gameP.moveLeft();
        } else if (e.getSource() == btnUp) {
            gameP.moveUp();
        } else if (e.getSource() == btnRight) {
            gameP.moveRight();
        } else if (e.getSource() == btnDown) {
            gameP.moveDown();
        }
    }

    public static void main(String args[]) {
        PacMinah pm = new PacMinah();
        pm.init();
    }
}
