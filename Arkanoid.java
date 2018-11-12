
package Arkanoid;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.Timer;


public class Arkanoid extends JFrame implements ActionListener,KeyListener {

    public static Arkanoid arkanoid;
    
    public final int WIDTH = 566, HEIGHT = 600;
    
    public boolean Run = false;
    
    public int rows = 3;
    
    public int columns = 7;
    
    public int BrickAmount=rows*columns;
    
    public Renderer renderer;
    
    public Ball ball;
    
    public Blocks blocks; 
    
    private int paddleX=240;
    
    private int paddleY=560;
    
    public boolean pause = false;
    public Arkanoid()
    {
       ball = new Ball();
       
       // Sukuriamas JFrame,naudojantis JPanel.
       
       JFrame jframe = new JFrame();        
      
      
       jframe.setFocusable(true);
       Timer timer = new Timer(20, this);  

       renderer = new Renderer();
       
       
       jframe.add(renderer);
       jframe.setResizable(false);
       jframe.setBounds(0,0,WIDTH, HEIGHT);
       jframe.setVisible(true);
       jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jframe.setTitle("Arkanoid");
       
        //inicializuojame klasę, skirtą blokų sudarymui
       blocks = new Blocks(rows,columns); 
       jframe.addKeyListener(this);
       timer.start();
       
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
     //Ciklas skirtas surasti ar kamuolys(klasė ball) atsirenkė į vieną iš blokų
     if(Run)
     {
       
         for(int i=0; i<blocks.block.length; i++)
            {
               
               for(int j=0;j<blocks.block[0].length;j++)
               {
                    
                   if(blocks.block[i][j]>0)
                   {
                       Rectangle PaintBlock = new Rectangle((j-1)*blocks.blockwidth+80,(i-1)*blocks.blockheight+50, blocks.blockwidth,blocks.blockheight);//Apibrėžiamas blokas kaip stačiakampis objektas
                       
                       
                       
                       Rectangle PaintBall = new Rectangle(ball.kordX,ball.kordY,ball.width,ball.height); 
                        
                       
                       if(PaintBlock.intersects(PaintBall)) 
                       {
                           BrickAmount--;
                           blocks.Destroyed(i,j);
                           
                           if( ball.kordX+19 <= PaintBlock.x || ball.kordX+2 >= PaintBlock.x+PaintBlock.width)
                           {
                               ball.changemovX();
                           }
                           else
                           {
                               ball.changemovY();
                           }
                           i=rows;
                           j=columns;
                           
                       }
                       
                   }
                       
               }
               
            }
        
       ball.movX();
       ball.movY();
       
       //Tikrinama ar kamuolys susiduria su platforma
       if(new Rectangle(ball.kordX,ball.kordY,ball.width,ball.height).intersects(paddleX,paddleY,86,10))
       ball.changemovY();
       
        renderer.repaint();
       
       
       
        
     }
    }
    
    void repaint(Graphics g) { //Metodas skirtas piešimui ant frame'o
        
        g.setColor(Color.black);
        
        g.fillRect(0,0,WIDTH,HEIGHT);
        
        g.setColor(Color.blue);
        
        g.fillRect(paddleX,paddleY,86,10);
        
        g.setColor(Color.red);
        
        g.fillOval(ball.kordX,ball.kordY,ball.width,ball.height);
        
        if(ball.kordY>HEIGHT)
        {
            this.Run=false;
            
            ball=new Ball();
            g.setColor(Color.blue);
            g.setFont(new Font("serif",Font.BOLD,25));
            g.drawString("You Lost, press Enter to play again",100,300);
            
        }
        
        if(pause==true)
        {
            g.setColor(Color.blue);
            g.setFont(new Font("serif",Font.BOLD,25));
            g.drawString("Game is paused,click left or right to continue",50,300);
            Run=false;
        }
        
        if(BrickAmount==0)
        {
            g.setColor(Color.blue);
            g.setFont(new Font("serif",Font.BOLD,25));
            g.drawString("You won! Press Enter to start again",50,300);
            Run=false;
        }
            
       
        
        
        blocks.draw((Graphics2D)g);
        
        
        
    }
    
    public static void main(String[] args) {
        
        arkanoid = new Arkanoid();
  
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            
            if(paddleX<=WIDTH-106)
            {
               
                paddleX+=20;
                Run=true;
                pause=false;
            }
        }
        
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
             if(paddleX-20>=0)
            {
                paddleX-=20;
                Run=true;
                pause=false;
            }
        }
        
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
            if(!Run)
            {
                Run=true;
                ball.kordX=250;
                ball.kordY=350;
                ball.moveY=-4;
                ball.moveX=-2;
                paddleX=240;
                paddleY=540;
                blocks = new Blocks(rows,columns);
                BrickAmount=rows*columns;
                renderer.repaint();
            }
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            pause=true;
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
  
   
}
