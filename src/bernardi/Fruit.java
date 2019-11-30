/*
* This class creates the fruit that the snake can run into to get larger
*/
package bernardi;

import java.util.List;

public class Fruit 
{
    public int icompFruit;
    public int jcompFruit;
    public int ORDER;
    public int fruitValue;
    
    // constructor that creates the fruit object
    // creates the fruit location (icomp and jcomp) randomly
    // first checks to make sure it doesn't put the fruit in same location as any snake parts
    public Fruit(List <SnakeParts> snake, int numberOfColumnsAndRows)
    {
        
        boolean loopVar = true;
        
        
        do
        {
            int counter = 0;
            icompFruit = (int)(Math.random() * numberOfColumnsAndRows);
            jcompFruit = (int)(Math.random() * numberOfColumnsAndRows);
            
            for(int i = 0; i < snake.size(); i ++)
            {
                if((snake.get(i).icomp == icompFruit) && (snake.get(i).jcomp == jcompFruit))
                {
                    counter ++;
                }
            }
            
            if(counter == 0)
            {
                loopVar = false;
            }
        } while(loopVar == true);
        
        
        
        int randomNum = (int)(Math.random() * 11) + 1;
        
        // smallest chance of occuring
        // worth most points
        if(randomNum == 6)
        {
            //pineapple
            ORDER = (numberOfColumnsAndRows * numberOfColumnsAndRows) + 4;
        }
        
        else if(randomNum > 9)
        {
            // bananna
            ORDER = (numberOfColumnsAndRows * numberOfColumnsAndRows) + 2;
        }
        
        else if(randomNum > 6)
        {
            // grapes
            ORDER = (numberOfColumnsAndRows * numberOfColumnsAndRows) + 3;
        }
        
        
        
        else
        {
            // apple
            ORDER = (numberOfColumnsAndRows * numberOfColumnsAndRows) + 1;
        }
        
    }
}
