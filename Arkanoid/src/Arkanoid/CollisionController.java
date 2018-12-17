/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arkanoid;

import java.awt.Rectangle;

public class CollisionController {

    boolean play;
    GameRun obj;
    int blockWidth;
    int blockHeight;

    public CollisionController(GameRun obj) {
        this.obj = obj;
    }

    public void collision(Blocks blocks, Ball ball) {

        blockWidth = blocks.getBlockwidth();
        blockHeight = blocks.getBlockheight();
        
        Rectangle temporary = new Rectangle(ball.getKordX(), ball.getKordY(), ball.getWidth(), ball.getHeight());
        
        for (int i = 0; i < blocks.getBlock().length; i++) {
            for (int j = 0; j < blocks.getBlock()[0].length; j++) {
                if (blocks.getBlock()[i][j] > 0) {
                    
                    Rectangle PaintBlock=new Rectangle((j-1)*blockWidth+80,(i-1)*blockHeight+50,blockWidth,blockHeight);
                    
                    if (PaintBlock.intersects(temporary)) {
                        
                        boolean stmt = ball.getKordX() + 19 <= PaintBlock.x;
                        boolean stmt2 = ball.getKordX() + 2 >= PaintBlock.x + PaintBlock.width;

                        if (stmt || stmt2) {
                            ball.changemovX();
                        } else {
                            ball.changemovY();
                        }

                        obj.reduceBricks();
                        blocks.Destroyed(i, j);
                        i = 3;
                        j = 7;
                    }

                }

            }

        }
    }
}
