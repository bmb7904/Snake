//This class contains functions that will move the snake
// the snake can move up, down, left, right
// the logic contained keeps the blocks of the snake together and following the head
// only attribute that is given in the constructor is the number of columns and rows, which again are equal
// this is because the game grid is a square
// i is row or y component
// j is column or x component
package bernardi;

import java.util.List;

public class GameRules
{
    final public int numberOfColumnsAndRows;
    
    
    public GameRules(int num)
    {
        this.numberOfColumnsAndRows = num;
    }
    
    
    
    public List <SnakeParts> moveSnakeRight(List <SnakeParts> snake)
    {
        for(int i = snake.size() - 1; i > 0; i--)
        {
            snake.get(i).setSnakePartsIComp(snake.get(i -1).icomp);
            snake.get(i).setSnakePartsJComp(snake.get(i-1).jcomp);
            
        }
        if((snake.get(0).jcomp + 1) != numberOfColumnsAndRows)
        {
            snake.get(0).setSnakePartsJComp(snake.get(0).jcomp + 1);
        }
        else
        {
            snake.get(0).setSnakePartsJComp(0);
        }
        
        return snake;
    }
    
    
    
    
        public List <SnakeParts> moveSnakeUp(List<SnakeParts> snake)
    {
        for(int i = snake.size() - 1; i > 0; i--)
        {
            snake.get(i).setSnakePartsIComp(snake.get(i-1).icomp);
            snake.get(i).setSnakePartsJComp(snake.get(i-1).jcomp);
            
        }
        if((snake.get(0).icomp) != 0)
        {
            snake.get(0).setSnakePartsIComp(snake.get(0).icomp - 1);
        }
        else
        {
            snake.get(0).setSnakePartsIComp(numberOfColumnsAndRows - 1);
        }
        
        return snake;
    }
        
        
        
        
        public List <SnakeParts> moveSnakeDown(List <SnakeParts> snake)
    {
        for(int i = snake.size() - 1; i > 0; i--)
        {
            snake.get(i).setSnakePartsIComp(snake.get(i-1).icomp);
            snake.get(i).setSnakePartsJComp(snake.get(i-1).jcomp);
        }
        if((snake.get(0).icomp) != numberOfColumnsAndRows -1)
        {
            snake.get(0).setSnakePartsIComp(snake.get(0).icomp + 1);
        }
        else
        {
            snake.get(0).setSnakePartsIComp(0);
        }
        
        return snake;
    }
        
        
        
        
        
        
        public List <SnakeParts> moveSnakeLeft(List <SnakeParts> snake)
    {
        for(int i = snake.size() - 1; i > 0; i--)
        {
            snake.get(i).setSnakePartsIComp(snake.get(i-1).icomp);
            snake.get(i).setSnakePartsJComp(snake.get(i-1).jcomp);
            
        }
        if((snake.get(0).jcomp) != 0)
        {
            snake.get(0).setSnakePartsJComp(snake.get(0).jcomp - 1);
        }
        else
        {
            snake.get(0).setSnakePartsJComp(numberOfColumnsAndRows - 1);
        }
        
        return snake;
    }
        
        // checks to see if snake collides with fruit
        public boolean checkIfFruit(List <SnakeParts> snake, Fruit fruit)
        {
            boolean checkIfHit = false;
            for(int i = 0; i < snake.size(); i ++)
            {
                if(snake.get(i).icomp == fruit.icompFruit && snake.get(i).jcomp == fruit.jcompFruit)
                {
                    checkIfHit = true;
                }
            }
            return checkIfHit;
        }
        
        // checks if snake collides with itself
        // head of snake is always snake[0]
        // only checks the head of the new snake array because this is the only body part that can collide
        // it does not check against the currentSnake head because that's impossible
        public boolean checkIfSnakeCollidesWithItself(List <SnakeParts> currentSnake, List <SnakeParts> newSnake)
        {
            
            // boolean is false if no collision is detected
            boolean collision = false;
            for(int i = 1; i < currentSnake.size(); i ++)
            {
                if(newSnake.get(0).icomp == currentSnake.get(i).icomp && newSnake.get(0).jcomp == currentSnake.get(i).jcomp)
                {
                    collision = true;
                }
            }
            
            return collision;
        }
        
        // pauses the program for the number of milliseconds in the parameter
        public static void pause(int ms) 
        {
        try 
        {
            Thread.sleep(ms);
        } catch (InterruptedException e) 
        {
            System.err.format("IOException: %s%n", e);
        }
        }
        
        public List <SnakeParts> addNewBodyPart(List <SnakeParts> incomingSnake, SnakeParts tail)
        {
            incomingSnake.add(incomingSnake.size(), tail);
            return incomingSnake;
        }
        
        public SnakeParts getFinalBodyPart(List <SnakeParts> snake)
        {
            SnakeParts tail = new SnakeParts(snake.get(snake.size() - 1).getSnakePartsIcomp(),snake.get(snake.size() - 1).getSnakePartsJcomp(), snake.get(snake.size() - 1).getSnakePartsOrder() + 1);
            return tail;
        }
        
}
