package bernardi;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class SnakeGame 
{
    
    // global variables
    // various variables describing size of grid and number of blocks in grid
    // the playing grid is a square
    // the fact that it's a square means that the number of columns and the number of rows are equal
    // the grid is represented as a 2D array and I refer to the rows as i and the columns as j
    // think of the i,j coordinates on the grid
    final public static int numberOfColumnsAndRows = 22;
    final public static int pixelWidth = 946;
    final public static int pixelHeight = 946;
    final public static int lengthSideOfSquare = pixelWidth/numberOfColumnsAndRows;
    
    //greats objects for gameRules and Grid
    // the gamerule class has the functions that move the snake
    // the grid class creates the arrays that update the grid with new snake 
    public static Grid grid = new Grid(numberOfColumnsAndRows);
    public static GameRules game = new GameRules(numberOfColumnsAndRows);
    
    //This creates the global jFrame which is the frame onto which the grid will be drawn;
    public static JFrame mainWindow = new JFrame("The Return Of Snake              Programmer: Brett Bernardi");
    
    public static char userInputSnakeDirection;
    
    
    
    

    
    
    public static void createJframe()
    {
        mainWindow.setVisible(true);
        mainWindow.setSize(pixelWidth, pixelHeight + 20);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setLocation(900, 0);
        mainWindow.setAlwaysOnTop(true);
        mainWindow.setResizable(true);
        //JLabel myLabel = new JLabel();
        //myLabel.
        
        
    }
    
    public static List<SnakeParts> createSnakeArray()
    {
        // creates the snake with each individual elements(heads and body parts)
        // puts them into an array of objects of snakeParts
        // each object holds the snakeParts i and j positions as well as the order(1 == head, 2 + is a body)
        SnakeParts head = new SnakeParts(10,10,1);
        SnakeParts body1 = new SnakeParts(10,9,2);
        SnakeParts body2 = new SnakeParts(10,8,3);
        SnakeParts body3 = new SnakeParts(10,7,4);
        SnakeParts body4 = new SnakeParts(10,6,5);
        SnakeParts body5 = new SnakeParts(10,5,6);
        SnakeParts body6 = new SnakeParts(10,4,7);

        List <SnakeParts> snake = new ArrayList<SnakeParts>();
        snake.add(head);
        snake.add(body1);
        snake.add(body2);
        snake.add(body3);
        snake.add(body4);
        snake.add(body5);
        snake.add(body6);
        
        return snake;
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
    
    public static void updateRect(List <SnakeParts> snake, Fruit fruit, char direction)
    {
      rectangle rect = new rectangle(pixelWidth, pixelHeight, lengthSideOfSquare,grid.addSnakeToGrid(snake, fruit, grid.createBlankGrid()), direction);
      mainWindow.add(rect);
      mainWindow.setVisible(true);
    }
    
    public static List <SnakeParts> moveSnake(List <SnakeParts> snake, char userInput)
    {
        switch (userInput)
        {
            case 'U': 
                
                return game.moveSnakeUp(snake);
                
            case 'D':
               
                return game.moveSnakeDown(snake);
                
            case 'L':
               
                return game.moveSnakeLeft(snake);
                
            case 'R':
                
                return game.moveSnakeRight(snake);
                
            default:
                return snake;
                
                    
        }
    }
    
    public static boolean checkIfHitFruit(List <SnakeParts> snake, Fruit fruit)
    {
        return game.checkIfFruit(snake, fruit);
    }
    
    public static boolean checkIfSnakeCollides(List <SnakeParts> currentSnake, List <SnakeParts> newSnake)
    {
        return game.checkIfSnakeCollidesWithItself(currentSnake, newSnake);
    }
        
    public static Fruit generateNewFruit(List <SnakeParts> snake)
    {
        Fruit fruit = new Fruit(snake, numberOfColumnsAndRows);
        return fruit;
    }
    
    public static List <SnakeParts> addToSnake(List <SnakeParts> snake)
    {
        int sizeOldSnake = snake.size();
        List <SnakeParts> newSnake = new ArrayList<SnakeParts>();
        for(int i = 0; i<snake.size(); i++)
        {
            newSnake.add(i, snake.get(i));
        }
        
        if((snake.get(sizeOldSnake - 1).jcomp) != 0)
        {
            newSnake.add(snake.size(), new SnakeParts(snake.get(sizeOldSnake - 1).icomp, snake.get(sizeOldSnake - 1).jcomp - 1, snake.get(sizeOldSnake - 1).order + 1));
        }
        
        else if (snake.get(sizeOldSnake - 1).icomp != 0)
        {
            newSnake.add(snake.size(), new SnakeParts(snake.get(sizeOldSnake - 1).icomp - 1, snake.get(sizeOldSnake - 1).jcomp , snake.get(sizeOldSnake - 1).order + 1));
        }
        
        return newSnake;
    }

   
    public static void main(String[] args)
    {
        int continueValue = 0;
        
        
        while(continueValue != 1)
        {
            int score = 0;
            
            userInputSnakeDirection = 'R';
        
            List <SnakeParts> currentSnake = createSnakeArray();
            Fruit fruit = generateNewFruit(currentSnake);
            updateRect(currentSnake, fruit,userInputSnakeDirection);

            createJframe();
            KeyListener l;
            l = new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) 
                {
                    // not using this at all
                }

                // this is for any arrow key that is pressed
                // key doesn't have to be released
                // i have if statements to prevent opposite direction being used
                // the game of snake does not allow the snake to travel in the opposite direction
                @Override
                public void keyPressed(KeyEvent e) {
                   if(e.getKeyCode() == KeyEvent.VK_UP)
                   {
                       if(userInputSnakeDirection != 'D')
                       {
                           
                            userInputSnakeDirection = 'U';
                       }

                   }

                   if(e.getKeyCode() == KeyEvent.VK_DOWN)
                   {
                       if(userInputSnakeDirection != 'U')
                       {
                           
                            userInputSnakeDirection = 'D';
                       }
                   }

                   if(e.getKeyCode() == KeyEvent.VK_LEFT)
                   {
                       if(userInputSnakeDirection != 'R')
                       {
                           
                            userInputSnakeDirection = 'L';
                       }
                   }     

                   if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                   {
                       if(userInputSnakeDirection != 'L')
                       {
                           
                           userInputSnakeDirection = 'R';
                       }

                   }              

                }

                @Override
                public void keyReleased(KeyEvent e) 
                {
                    // not using this at all
                }
            };

            mainWindow.addKeyListener(l);

            while(1==1)
            {
                List <SnakeParts> newSnake = moveSnake(currentSnake, userInputSnakeDirection);

                if((checkIfSnakeCollides(currentSnake, newSnake)) == false)
                {
                    // if snake hits fruit
                    if(checkIfHitFruit(newSnake, fruit))
                    {
                        score += 100;
                        // add block to tail of snake
                        newSnake = addToSnake(newSnake);
                        // generate new fruit and new location of fruit
                        fruit = generateNewFruit(newSnake);
                        // draw newly updated snake and fruit on grid
                        updateRect(newSnake, fruit,userInputSnakeDirection);
                        // updates currentSnake to  newSnake
                        currentSnake = newSnake;
                        pause(130);
                    }

                    else
                    {
                        updateRect(newSnake, fruit,userInputSnakeDirection);
                        pause(130);
                    }


                }

                else 
                {
                    updateRect(newSnake, fruit,userInputSnakeDirection);
                    break;
                }



            }

            JFrame optionPane = new JFrame();
            optionPane.setAlwaysOnTop(true);
            optionPane.setLocation(300, 300);
                    // shows ending message

            continueValue = JOptionPane.showConfirmDialog(optionPane, 
             "SCORE: " + score + "\n" +
             "Would you like to play again?", 
             "GAME OVER", 
             JOptionPane.YES_NO_OPTION,
                        3
            );
        
        
        }

        JFrame optionPane = new JFrame();
        optionPane.setAlwaysOnTop(true);
        optionPane.setLocation(300, 300);
        
        JOptionPane.showMessageDialog(optionPane,
                
        "Thanks for playing! \n"
        +
        "Programmer:  Brett Bernardi \n" 
        + "2019",
        "GOOD-BYE!",
        1
        );
        
        System.exit(0);

        

        
    }
}
    

