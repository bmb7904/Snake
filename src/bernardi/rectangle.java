// this class, when the constructor is called will take in a 2D array and draw 
// the grid appropriately
// just calling the constructor and creating an object will draw the grid. make sure
// to ass the rectangle object to a jframe and set visible
// is modular and can be used for other purposes
// just a slight tweek to use for other purposes
// i used the same exact class, with some small modifications, to draw the game of life

package bernardi;

import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class rectangle extends JPanel {

    public static BufferedImage imageDown;
    public static BufferedImage imageLeft;
    public static BufferedImage imageRight;
    public static BufferedImage imageUp;
    public static BufferedImage imageBody;
    public static BufferedImage imageApple;
    
    public int pixelWidthPanel;
    public int pixelHeightPanel;
    public int LsideSquare;
    public int[][] maze;
    // this never changes
    // the head of the snake always have a value in the grid array of 1
    final public static byte SNAKEHEADARRAYVALUE = 1;
    public char direction;

    Random rand = new Random();

    // constructor for Rectangle class
    // will take in and set size of rectangle (square) as well as coordinate 
    // where the rectangle will be drawn
    public rectangle(int pixelWidth, int pixelHeight, int lengthSideSquare, int[][] maze, char direction) {
        this.LsideSquare = lengthSideSquare;
        this.pixelHeightPanel = pixelHeight;
        this.pixelWidthPanel = pixelWidth;
        this.maze = maze;
        this.direction = direction;
    }

    // this is not a user defined function, but a function that comes with the
    // imports. This will draw a rectangle and associate it with the new object 
    // when created. No need to call this function seperately. This gave me a lot of 
    //  headaches trying to figure out!!!
    public void paintComponent(Graphics myPen) 
    {
        // still not exactly sure what this does but it is needed
        super.paintComponent(myPen);
        // sets pen to new graphics 2d for added features
        Graphics2D g2 = (Graphics2D) myPen;
        // sets color used by pen to draw
        
        // imports images here
        // I should have tried to  make this code cleaner but it was too late and this works
        try
        {
            imageDown = ImageIO.read(new File("/Users/brettbernardi/Pictures/snakeHead3 (1).png"));
        }
        catch (IOException e)
        {
            
        }
        
        try
        {
            imageLeft = ImageIO.read(new File("/Users/brettbernardi/Pictures/snakeHead3 (Left).png"));
        }
        catch (IOException e)
        {
            
        }
        
        try
        {
            imageRight = ImageIO.read(new File("/Users/brettbernardi/Pictures/snakeHead3 (Right).png"));
        }
        catch (IOException e)
        {
            
        }
        
        try
        {
            imageUp = ImageIO.read(new File("/Users/brettbernardi/Pictures/snakeHead3 (Up).png"));
        }
        catch (IOException e)
        {
            
        }
        try
        {
            imageBody = ImageIO.read(new File("/Users/brettbernardi/Pictures/bodySnake.png"));
        }
        catch (IOException e)
        {
            
        }
                try
        {
        imageApple = ImageIO.read(new File("/Users/brettbernardi/Pictures/apple.png"));
        }
        catch (IOException e)
        {
            
        }
        
        
        

        for (int i = 0; i < pixelHeightPanel; i = i + LsideSquare) 
        {
            for (int j = 0; j < pixelWidthPanel; j = j + LsideSquare) 
            {
                if (maze[i / LsideSquare][j / LsideSquare] == SNAKEHEADARRAYVALUE) 
                {
                    myPen.setColor(Color.white);
                    myPen.fillRect(j, i, LsideSquare, LsideSquare);
                    
                    switch(direction)
                    {
                        
                        case'D':
                        {
                           myPen.drawImage(imageDown, j, i, this);
                           break;
                        }
                        case 'L': 
                        {
                            myPen.drawImage(imageLeft, j, i, this);
                            break;
                        }
                        case 'R':
                        {
                            myPen.drawImage(imageRight, j, i, this);
                            break;
                        }
                        case 'U':
                        {
                            myPen.drawImage(imageUp, j, i, this);
                            break;
                        }
                        default:
                        {
                            myPen.setColor(Color.red);
                            myPen.fillOval(j, i, LsideSquare, LsideSquare);
                        }
                    }


                } 
                else if (maze[i / LsideSquare][j / LsideSquare] == ((Math.pow((pixelWidthPanel/LsideSquare), 2) + 1) )) 
                {
                    myPen.setColor(Color.white);
                    myPen.fillRect(j, i, LsideSquare, LsideSquare);
                    
                    myPen.drawImage(imageApple, j, i, this);
                } 
                else if (maze[i / LsideSquare][j / LsideSquare] == 0) 
                {
                    myPen.setColor(Color.white);
                    myPen.fillRect(j, i, LsideSquare, LsideSquare);
                } 
                else 
                {
                    myPen.setColor(Color.white);
                    myPen.fillRect(j, i, LsideSquare, LsideSquare);
                    //Color c = new Color();
                    //myPen.setColor(Color.red);
                    //myPen.setColor(Color.getHSBColor(rand.nextFloat(), rand.nextFloat(), rand.nextFloat()));
                    myPen.drawImage(imageBody, j, i, this);
                }

                
            }

        }
        
        /*
        // the following code will draw the nice thick lines separating the blocks
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.black);

        for (int k = 0; k < pixelWidthPanel; k = k + LsideSquare) {
            g2.drawLine(k, 0, k, this.getHeight());

        }

        for (int l = 0; l < pixelHeightPanel; l = l + LsideSquare) {
            g2.drawLine(0, l, this.getWidth(), l);
        }
        */
    

    }

}
