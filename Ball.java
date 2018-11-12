

package Arkanoid;

import java.awt.Rectangle;



public class Ball {
    public static final int height=20;
    public static final int width=20;
    public static int kordX=286;
    public static int kordY=350;
    public static int moveX=-2;
    public static int moveY=-4;
    public void movX()  //Kamuolio judėjimas dešinėn
    {
        
        if(this.kordX<0)
        {
           changemovX();
           this.kordX+=moveX;
        }
        else if(this.kordX>540)
        {
           changemovX();
           this.kordX+=moveX;
        }
        else
            this.kordX+=moveX;
    }
    
    public void movY()//Kamuolio judėjimas kairėn
    {
        this.kordY+=moveY;
         if(this.kordY<0)
        {
           changemovY();
           this.kordY+=moveY;
        }
        else
            this.kordY+=moveY;
    }
    public void changemovX()//Kamuolio anscisės judėjimo krypties keitimas
    {
        this.moveX*=-1;
        
    }
    
    public void changemovY()//Kamuolio ordinatės judėjimo krypties keitimas
    {
        this.moveY*=-1;
    }
}
