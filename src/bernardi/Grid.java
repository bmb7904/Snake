// this class creates the grid as a 2D array

package bernardi;

import java.util.Arrays;
import java.util.List;

public class Grid 
{
        final public int rows;
        final public int columns;
        public static int[][] blankGrid;

        
        
    public Grid(int numberOfColumnsAndRows)
    {
        this.rows = numberOfColumnsAndRows;
        this.columns = numberOfColumnsAndRows;
        
        // creates blank grid using the given dimensions and stores it as a member variable
        // this is used every single time AddSnakeToGrid() is called
        blankGrid = createBlankGrid();
        
    }
    
    // having the blankGrid created only once in the constructor and then used as needed when
    // function is called is a better solution than the original, which created a new blankGrid
    // every single time addSnaketoGrid() was called
    // I suspect this will save computational/memory resources
    public int[][] addSnakeToGrid(List <SnakeParts> snake, Fruit fruit)
    {
        // this solution was found from stack Overflow
        // because arrays are objects, and I don't want to alter the member variable blankGrid ever
        // I need to copy blank grid to a new array
        // setting outgoingGrid = blankGrid only sets the reference(memory addresses) equal and this will
        // then alter the blankGrid from outside the function
        // this solution creates a copy of blankGrid in a new memory address
        int[][] outgoingGrid = Arrays.stream(blankGrid).map(int[]::clone).toArray(int[][]::new);
        
        for(int i = 0; i < snake.size(); i ++)
        {
            // this sets the grid to each component in the snake
            outgoingGrid[snake.get(i).icomp][snake.get(i).jcomp] = snake.get(i).order;
        }
        
        outgoingGrid[fruit.icompFruit][fruit.jcompFruit] = fruit.ORDER;
        
        
        return outgoingGrid;

    }
    // this is only called once when the constructor is called
    private int[][] createBlankGrid()
   {
       int[][] tempBlankGrid = new int[rows][columns];
       for(int i = 0; i < rows; i ++)
       {
           for (int j = 0; j < columns; j++)
           {
               tempBlankGrid[i][j] = 0;
           }
       }
       
       return tempBlankGrid;
   }

}
