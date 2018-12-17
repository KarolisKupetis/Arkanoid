package Arkanoid;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Repainter {
    GameRun obj;
    public Repainter(){
        
    }
    
    public void repainting(GameRun obj,Graphics g,Ball ball){
        
        int paddleX  = obj.getPaddleX();
        int paddleY = obj.getPaddleY();
        boolean run = obj.isRun();
        boolean pause = obj.isPause();
        g.setColor(Color.black);
        g.fillRect(0, 0, 566, 600);
        g.setColor(Color.blue);
        g.fillRect(paddleX, paddleY, 86, 10);
        g.setColor(Color.red);
        g.fillOval(ball.getKordX(), ball.getKordY(), ball.getWidth(), ball.getHeight());

        if (ball.getKordY() > 600) {
            obj.setRun(false);
            ball = new Ball();
            g.setColor(Color.blue);
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("You Lost, press Enter to play again", 100, 300);

        }

        if (pause == true) {
            g.setColor(Color.blue);
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("Game is paused,click left or right to continue", 50, 300);
            obj.setRun(false);
        }

        if (obj.getBrickAmount() == 0) {
            g.setColor(Color.blue);
            g.setFont(new Font("serif", Font.BOLD, 25));
            g.drawString("You won! Press Enter to start again", 50, 300);
            obj.setRun(false);
        }
        
    }
}
