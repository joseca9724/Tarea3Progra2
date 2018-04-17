package Shapes;

import java.awt.*;
import javax.swing.ImageIcon;
import java.lang.String;

public class Simulator 
{

    private DisplayFrame myDisplayer;  //JFrame
    private Circle myCircle;
    private Rectangle myRectangle;
    
    private int cSpeedX=(int) (Math.random()*6+1);
    private int cSpeedY=(int) (Math.random()*8+1);
    
    private int recSpeedX=(int) (Math.random()*8+1);
    private int recSpeedY=(int) (Math.random()*8+1);
    
    private int X=50;
    private int Y=50;
    private int x=200;
    private int y=200;
    
    private int aux=0;
    private int aux2=0;

    private int leftLimitC=0;
    private int rigthLimitC;
    private int upLimitC=0;
    private int downLimitC;
    
    private int leftLimitRec=0;
    private int rigthLimitRec;
    private int upLimitRec=0;
    private int downLimitRec;


    //constructor
    public Simulator(DisplayFrame myDisplayer_)
    {
        this.setMyDisplayer(myDisplayer_);
        this.setMyCircle(new Circle());
        this.setMyRectangle(new Rectangle());

        //valores de las figuras
        myCircle.setHeight(80);
        myCircle.setWidth(80);
        myRectangle.setHeight(100);
        myRectangle.setWidth(100);
        
        rigthLimitC=myDisplayer.getWidth()-myCircle.getWidth();
        downLimitC=myDisplayer.getHeight()-myCircle.getHeight();
        
        rigthLimitRec=myDisplayer.getWidth()-myRectangle.getWidth();
        downLimitRec=myDisplayer.getHeight()-myRectangle.getHeight();
        
    }

    
    //ciclo infinito para mover las figuras
    public void startSimulation(int waitingTime) throws InterruptedException 
    {
        //ciclo infinito
        while (true)
        {
            this.moveShapeC();
            this.moveShapeR();
            this.createImages();

            //pone en espera el flujo del programa
            Thread.sleep(waitingTime);
        }
    }//end method


    //cambio los valores de las variables de las figuras que tengo
    public void moveShapeC() {
        X += cSpeedX;
        Y += cSpeedY;

        getMyCircle().setRow(Y);
        getMyCircle().setColumn(X);
        
        if (X < this.leftLimitC) {
            X = 0;
            cSpeedX = -cSpeedX;
        } else if (X > rigthLimitC) {
            X = rigthLimitC;
            cSpeedX = -cSpeedX;
        }
        if (Y < this.upLimitC+25) {
            Y =upLimitC+25;
            cSpeedY = -cSpeedY;

        } else if (Y > downLimitC) {
            Y =  downLimitC;
            cSpeedY = -cSpeedY;
        }
        else {
            int aleatorio = (int) (Math.random() * 2000 + 1);
            if (aleatorio < 10) {
                cSpeedX = -cSpeedX;
            } else if (aleatorio < 40 && aleatorio > 20) {
                cSpeedX = -cSpeedX;
            }
            if (aleatorio < 100 && aleatorio > 70) {
                cSpeedY = -cSpeedY;

            } else if (aleatorio < 200 && aleatorio > 150) {
                cSpeedY = -cSpeedY;
            }else if(aleatorio < 300 && aleatorio > 200){
                if(cSpeedY!=0){
                    aux=cSpeedY;
                }
                cSpeedY = 0;
            }
            else if(aleatorio < 400 && aleatorio > 300){
                cSpeedY = aux;
            }
        }
    }
    
    public void moveShapeR() {
        x += recSpeedX;
        y += recSpeedY;
        
        getMyRectangle().setRow(y);
        getMyRectangle().setColumn(x);
        
        
        if (x < this.leftLimitRec) {
            x = 0;
            recSpeedX = -recSpeedX;
        } else if (x > rigthLimitRec) {
            x = rigthLimitRec;
            recSpeedX = -recSpeedX;
        }
        if (y < this.upLimitRec+25) {
            y = upLimitRec+25;
            recSpeedY = -recSpeedY;

        } else if (y > downLimitRec) {
            y =  downLimitRec;
            recSpeedY= -recSpeedY;
        }
        else {
            int aleatorio = (int) (Math.random() * 2000 + 1);
            if (aleatorio < 10) {
                recSpeedY = -recSpeedY;
            } else if (aleatorio < 40 && aleatorio > 20) {
                recSpeedY = -recSpeedY;
            }
            if (aleatorio < 100 && aleatorio > 70) {
                recSpeedX = -recSpeedX;

            } else if (aleatorio < 200 && aleatorio > 150) {
                recSpeedX = -recSpeedX;
            } else if (aleatorio < 300 && aleatorio > 200) {
                if (recSpeedY != 0) {
                    aux2 = recSpeedY;
                }
                recSpeedY = 0;
            } else if (aleatorio < 400 && aleatorio > 300) {
                recSpeedY = aux2;
            }
        }
    }

    //coloca nuevos valores aleatorios en las figuras
    public void createImages()
    {
        myDisplayer.initImage();
        Graphics graphic = myDisplayer.getGraphicsImage();

        graphic.setColor(Color.BLUE);
        graphic.fillOval(getMyCircle().getColumn(),
                getMyCircle().getRow(),
                getMyCircle().getWidth(),
                getMyCircle().getHeight());

        graphic.setColor(Color.PINK);
        graphic.fillRect(getMyRectangle().getColumn(),
                getMyRectangle().getRow(),
                getMyRectangle().getWidth(),
                getMyRectangle().getHeight());

        myDisplayer.paintAgain();
    }



    //**************************************************************************
    /*     metodos accesores      */

    public Circle getMyCircle() {
        return myCircle;
    }

    public void setMyCircle(Circle myCircle) {
        this.myCircle = myCircle;
    }

    public DisplayFrame getMyDisplayer() {
        return myDisplayer;
    }

    public void setMyDisplayer(DisplayFrame myDisplayer) {
        this.myDisplayer = myDisplayer;
    }

    public Shapes.Rectangle getMyRectangle() {
        return myRectangle;
    }

    public void setMyRectangle(Shapes.Rectangle myRectangle) {
        this.myRectangle = myRectangle;
    }
    

}
