package Arkanoid;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class GameRun extends JFrame implements ActionListener, KeyListener {

    private boolean run = false;
    private int BrickAmount = 21;
    private Renderer renderer;
    private Ball ball = new Ball();
    private Blocks blocks = null;
    private int paddleX = 240;
    private int paddleY = 560;
    private boolean pause = false;
    CreateJFrame create = new CreateJFrame();
    CollisionController col = new CollisionController(this);

    public GameRun() {
        renderer = new Renderer();
        JFrame jframe = create.create(renderer);
        jframe.addKeyListener(this);
        Timer timer = new Timer(20, this);
        blocks = new Blocks(3, 7);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (run) {
            col.collision(blocks, ball);
            ball.movX();
            ball.movY();
            if (new Rectangle(ball.getKordX(), ball.getKordY(), ball.getWidth(), ball.getHeight()).intersects(paddleX, paddleY, 86, 10)) {
                ball.changemovY();
            }
            renderer.repaint();
        }
    }

    void repaint(Graphics g) { //Metodas skirtas piešimui ant frame'o
        Repainter repainter = new Repainter();
        repainter.repainting(this, g, ball);
        blocks.draw((Graphics2D) g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (paddleX <= 566 - 106) {
                paddleX += 20;
                run = true;
                pause = false;
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (paddleX - 20 >= 0) {
                paddleX -= 20;
                run = true;
                pause = false;

            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!run) {
                run = true;
                ball.setKordX(250);
                ball.setKordY(350);
                ball.setMoveY(-4);
                ball.setMoveX(-2);
                paddleX = 240;
                paddleY = 540;
                blocks = new Blocks(3, 7);
                BrickAmount = 21;
                renderer.repaint();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            pause = true;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void reduceBricks() {
        this.BrickAmount -= 1;
    }

    public int getPaddleX() {

        return paddleX;
    }

    public int getPaddleY() {

        return paddleY;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public boolean isRun() {
        return run;
    }

    public boolean isPause() {
        return pause;
    }

    public int getBrickAmount() {
        return BrickAmount;
    }

}
