// the head of the snake is given position 1
// the rest of the body follows along sequentially from 1.
// so the body part connected to the head has attribute of 2
// and so on
package bernardi;

public class SnakeParts 
{
    // stores the snake part's i component
    // this is the row in the 2D array
    public int icomp;
    // stores the snake part's j component
    // this it the column in the 2D array
    public int jcomp;
    public int sizeOfsnake;
    public int order;
    
    
    public SnakeParts(int icomp, int jcomp, int order)
    {
        this.icomp = icomp;
        this.jcomp = jcomp;
        this.order = order;
    }
    
    public int getSnakePartsIcomp()
    {
        return icomp;
    }
    
    public int getSnakePartsJcomp()
    {
        return jcomp;
    }
    
    public int getSnakePartsOrder()
    {
        return order;
    }
    
    public void setSnakePartsIComp(int icomp)
    {
        this.icomp = icomp;
    }
    
    public void setSnakePartsJComp(int jcomp)
    {
        this.jcomp = jcomp;
    }
    
    public void setSnakePartsOrder(int order)
    {
        this.order = order;
    }
    
}


