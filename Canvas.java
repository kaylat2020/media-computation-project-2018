//change java.awt.Color; to greenfoot.Color; in newer versions.
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 //RED, BLUE, GREEN, MAGENTA, CYAN, BLACK, WHITE
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Canvas extends World
{
    private static final String fileName = "TRACER.JPG";
    private static final GreenfootImage graffitiTracer = new GreenfootImage(fileName);
    private static Color[][] bg = new Color[graffitiTracer.getHeight()][graffitiTracer.getWidth()];
    public Canvas()
    {    
        super(1280, 720, 1);
        reset();
    }

    public void reset()
    {
        setBackground(fileName);
    }
    
    public static void getPixels()
    {
        for(int y=0; y<graffitiTracer.getHeight(); y++)
        {
            for(int x=0; x<graffitiTracer.getWidth(); x++)
            {
                bg[y][x]=graffitiTracer.getColorAt(x,y);
            }
        }
    }
    
    public static Color[][] getPixels(GreenfootImage oldPic)
    {
        Color[][] pic = new Color[oldPic.getHeight()][oldPic.getWidth()];
        for(int y=0; y<oldPic.getHeight(); y++)
        {
            for(int x=0; x<oldPic.getWidth(); x++)
            {
                pic[y][x]=oldPic.getColorAt(x,y);
            }
        }
        return pic;
    }
    
    public void drawPixels(Color[][] array)
    {
        GreenfootImage bg = new GreenfootImage(array[0].length, array.length);
        for(int y=0; y<array.length; y++)
        {
            for(int x=0; x<array[0].length; x++)
            {
                bg.setColorAt(x,y,array[y][x]);
            }
        }
        setBackground(bg);
    }
    
    public void randomizeOneColor()
    {
        Color random = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
        for(int y=0; y<graffitiTracer.getHeight(); y++)
        {
            for(int x=0; x<graffitiTracer.getWidth(); x++)
            {
                bg[y][x]=random;
            }
        }
        drawPixels(bg);
    }
    
    public void staticScreen()
    {
        for(int y=0; y<graffitiTracer.getHeight(); y++)
        {
            for(int x=0; x<graffitiTracer.getWidth(); x++)
            {
                Color random = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
                bg[y][x]=random;
            }
        }
        drawPixels(bg);
    }
    
    public void grayScale()
    {
        for(int y=0; y<graffitiTracer.getHeight(); y++)
        {
            for(int x=0; x<graffitiTracer.getWidth(); x++)
            {
                bg[y][x]=graffitiTracer.getColorAt(x,y);
                Color c = bg[y][x];
                int thisGray = ((c.getRed() + c.getGreen() + c.getBlue())/3);
                c = new Color(thisGray, thisGray, thisGray);
                bg[y][x]=c;
            }
        }
        drawPixels(bg);
    }
    
    public void invert()
    {
        for(int y=0; y<graffitiTracer.getHeight(); y++)
        {
            for(int x=0; x<graffitiTracer.getWidth(); x++)
            {
                bg[y][x]=graffitiTracer.getColorAt(x,y);
                Color i = bg[y][x];
                Color b = new Color(255-i.getRed(),255-i.getGreen(),255-i.getBlue());
                bg[y][x]=b;
            }
        }
        drawPixels(bg);
    }
    
    public void mirrorTopToBottom()
    {
        for(int y=0; y<graffitiTracer.getHeight()/2; y++)
        {
            for(int x=0; x<graffitiTracer.getWidth(); x++)
            {
                bg[y][x]=graffitiTracer.getColorAt(x,y);
                Color c = bg[y][x];
                bg[719-y][x]=c;
            }
        }
        drawPixels(bg);
    }
    
    public void mirrorBottomToTop()
    {
        for(int y=0; y<graffitiTracer.getHeight(); y++)
        {
            for(int x=0; x<graffitiTracer.getWidth(); x++)
            {
                bg[y][x]=graffitiTracer.getColorAt(x,y);
            }
        }
        for(int y=0; y<graffitiTracer.getHeight()/2; y++)
        {
            for(int x=0; x<graffitiTracer.getWidth(); x++)
            {
                Color c = bg[719-y][x];
                bg[y][x]=c;
            }
        }
        drawPixels(bg);
    }
    
    public void mirrorLeftToRight()
    {
        for(int y=0; y<graffitiTracer.getHeight(); y++)
        {
            for(int x=0; x<graffitiTracer.getWidth()/2; x++)
            {
                bg[y][x]=graffitiTracer.getColorAt(x,y);
                Color c = bg[y][x];
                bg[y][1279-x]=c;
            }
        }
        drawPixels(bg);
    }
    
    public void mirrorRightToLeft()
    {
        for(int y=0; y<graffitiTracer.getHeight(); y++)
        {
            for(int x=0; x<graffitiTracer.getWidth(); x++)
            {
                bg[y][x]=graffitiTracer.getColorAt(x,y);
            }
        }
        for(int y=0; y<graffitiTracer.getHeight(); y++)
        {
            for(int x=0; x<graffitiTracer.getWidth()/2; x++)
            {
                Color c = bg[y][1279-x];
                bg[y][x]=c;
            }
        }
        drawPixels(bg);
    }
    
    public void flipVertical()
    {
        for(int y=0; y<graffitiTracer.getHeight(); y++)
        {
            for(int x=0; x<graffitiTracer.getWidth(); x++)
            {
                bg[y][x]=graffitiTracer.getColorAt(x,y);
            }
        }
        Color temp;
        for (int i = 0; i < bg.length / 2; i++) 
        {
            for (int j = 0; j < bg[i].length; j++) 
            {
                temp = bg[i][j];
                bg[i][j] = bg[bg.length - 1 - i][j];
                bg[bg.length - 1 -i][j] = temp;
            }
        }
        drawPixels(bg);
    }
    
    public void flipHorizontal()
    {
        for(int y=0; y<graffitiTracer.getHeight(); y++)
        {
            for(int x=0; x<graffitiTracer.getWidth(); x++)
            {
                bg[y][x]=graffitiTracer.getColorAt(x,y);
            }
        }
        Color temp;
        for (int i = 0; i < bg.length; i++) 
        {
            for (int j = 0; j < bg[i].length/2; j++) 
            {
                temp = bg[i][j];
                bg[i][j] = bg[i][bg[i].length - 1 - j];
                bg[i][bg[i].length - 1 - j] = temp;
            }
        }
        drawPixels(bg);
    }
    
    //Set threshold from 100-200 for optimum result!!!
    public void detectEdges(int threshold)
    {
        for(int y=0; y<graffitiTracer.getHeight(); y++)
        {
            for(int x=0; x<graffitiTracer.getWidth(); x++)
            {
                bg[y][x]=graffitiTracer.getColorAt(x,y);
            }
        }
        for(int y=0; y<graffitiTracer.getHeight()-1; y++)
        {
            for(int x=0; x<graffitiTracer.getWidth()-1; x++)
            {
                if(Math.sqrt(Math.pow((bg[y][x].getRed()+bg[y][x].getGreen()+bg[y][x].getBlue())/3.0,2)+Math.pow((bg[y][x+1].getRed()+bg[y][x+1].getGreen()+bg[y][x+1].getBlue())/3.0,2))>threshold)
                {
                    bg[y][x]=Color.WHITE;
                }
                else
                {
                    bg[y][x]=Color.BLACK;
                }
            }
        }
        drawPixels(bg);
    }
}
