// this class creates the grid as a 2D array

package bernardi;

import java.util.List;

public class Grid 
{
        final public int rows;
        final public int columns;

        
        
    public Grid(int numberOfColumnsAndRows)
    {
        this.rows = numberOfColumnsAndRows;
        this.columns = numberOfColumnsAndRows;
        
        
    }
    
    public int[][] addSnakeToGrid(List <SnakeParts> snake, Fruit fruit)
    {
        // the outgoing grid will start with blankGrid and then add snake and fruit and return it
        int[][] outgoingGrid = createBlankGrid(rows,columns);
        
        for(int i = 0; i < snake.size(); i ++)
        {
            // this sets the grid to each component in the snake
            outgoingGrid[snake.get(i).icomp][snake.get(i).jcomp] = snake.get(i).order;
        }
        
        outgoingGrid[fruit.icompFruit][fruit.jcompFruit] = fruit.ORDER;
        
        
        return outgoingGrid;

    }
    
    private static int[][] createBlankGrid(int numberOfRows, int numberOfColumns)
   {
       int[][] tempBlankGrid = new int[numberOfRows][numberOfColumns];
       for(int i = 0; i < numberOfRows; i ++)
       {
           for (int j = 0; j < numberOfColumns; j++)
           {
               tempBlankGrid[i][j] = 0;
           }
       }
       
       return tempBlankGrid;
   }
}
