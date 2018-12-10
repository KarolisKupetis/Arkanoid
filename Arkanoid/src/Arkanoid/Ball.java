package Arkanoid;

public class Ball {
    private final int height=20;
    
    private final int width=20;
    
    private int kordX=280;
    
    private int kordY=350;
    
    private int moveX=-2;
    
    private int moveY=-4;
    
    public int getKordX() {
        return kordX;
    }

    public void setKordX(int kordX) {
        this.kordX = kordX;
    }

    public int getKordY() {
        return kordY;
    }

    public void setKordY(int kordY) {
        this.kordY = kordY;
    }

    public int getMoveX() {
        return moveX;
    }

    public void setMoveX(int moveX) {
        this.moveX = moveX;
    }

    public int getMoveY() {
        return moveY;
    }

    public void setMoveY(int moveY) {
        this.moveY = moveY;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    
    
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
