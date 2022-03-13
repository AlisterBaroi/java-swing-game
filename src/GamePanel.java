import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private Timer aTimer;
    private int gameStatus = 0; // 0 = waiting for start game
                                // 1 = game running
                                // 2 = game over
    private Alister alister;
    private Monster mons;
    private Monster mons1;
    private Monster mons2;
    private int score = 0;

    public int getStatus() {
        return gameStatus;
    }

    public GamePanel() {
        aTimer = new Timer(50, this); // 50 ms 0.05 sec or 20x per second
        addKeyListener(this);
        reset();
    }

    public void reset() {
        alister = new Alister(300, 500, 5);
        mons = new Monster(300, 100, 5);
        mons1 = new Monster(350, 100, 5);
        mons2 = new Monster(250, 100, 5);
        score = 0;
        aTimer.start();
        gameStatus = 0;
    }

    public void startTimer() {
        if (gameStatus == 0) {
            aTimer.start();
            gameStatus = 1;
        }
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == 37) {
            moveLeft();
        } else if (keyCode == 39) {
            moveRight();
        } else if (keyCode == 38) {
            moveUp();
        } else if (keyCode == 40) {
            moveDown();
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void paint(Graphics g) {
        if (gameStatus == 1) {
            score++;
            if (alister.collideBorder()) {
                gameStatus = 2;
            }
            if (alister.collideWithMonster(mons)) {
                gameStatus = 2;
            }
            if (alister.collideWithMonster(mons1)) {
                gameStatus = 2;
            }
            if (alister.collideWithMonster(mons2)) {
                gameStatus = 2;
            }
            if (gameStatus != 2) {
                mons.hunting();
                mons1.hunting();
                mons2.hunting();
                alister.updatePosition();
                mons.updatePosition();
                mons1.updatePosition();
                mons2.updatePosition();
                mons.handleBorderCollision();
                mons1.handleBorderCollision();
                mons2.handleBorderCollision();
            }
        }
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 600, 600);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        g.fillRect(0, 600, 600, 30);
        alister.draw(g);
        mons.draw(g);
        mons1.draw(g);
        mons2.draw(g);
        if (gameStatus == 0) {
            g.setColor(Color.WHITE);
            g.drawString("PRESS START TO BEGIN..", 250, 300);
        }
        if (gameStatus == 2) {
            g.setColor(Color.WHITE);
            g.drawString("G A M E O V E R", 250, 300);
        }

        g.setColor(Color.WHITE);
        g.drawString("S C O R E : " + score, 10, 620);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aTimer) {
            repaint(0, 0, 600, 630);
            requestFocus();
        }
    }

    public void moveLeft() {
        alister.moveLeft();
    }

    public void moveRight() {
        alister.moveRight();
    }

    public void moveUp() {
        alister.moveUp();
    }

    public void moveDown() {
        alister.moveDown();
    }
}
