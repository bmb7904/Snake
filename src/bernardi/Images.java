// This exists solely to prevent the program from loading the background image 
// every single time a new JPanel is painted. 
// I suspect this will save computational/memory resources


package bernardi;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Images 
{
    public BufferedImage background;
    
    
    public Images()
    {
        
    }
    
    public BufferedImage returnBackgroundImage()
    {
        try
        {
         background = ImageIO.read(getClass().getResource("/background.png"));
            System.out.println("ANAL");
        }
        
        catch(IOException e)
        {
            
        }
        
        return background;
    }
}
