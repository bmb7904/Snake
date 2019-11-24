package bernardi;


public class Snake 
{
    public SnakeParts [] snake;
    public int sizeOfSnake;
    
    public Snake(int size)
    {
        this.sizeOfSnake = size;
    }
    
    public SnakeParts[] createNewSnake()
    {
        SnakeParts[] snake = new SnakeParts[sizeOfSnake];
        int counter = 0;
        int initiali = 10;
        int initialj = 10;
        int order = 1;
        while(counter < sizeOfSnake)
        {
            snake[counter] = new SnakeParts(initiali, initialj, order);
            initialj --;
            order ++;
            
        }
        
        return snake;
        
    }
    
    public int getSizeOfSnake()
    {
        return sizeOfSnake;
    }
    
}
