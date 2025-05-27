package miniUndertaleGame.game;

//import miniUndertaleGame.*;
import miniUndertaleGame.logic.*;
import miniUndertaleGame.UI.*;

public class Game 
{
    InputHandler input;
    Renderer render; 

    public Game()
    {
        input = new InputHandler();
        render = new Renderer(input);
        render.drawBoard();
    }

    public void start()
    {
        while(true)
        {
            switch(input.getLastDirection())
            {
                case Direction.LEFT: 
                    render.drawLeftBlock();
                    break;
                case Direction.RIGHT:
                    render.drawRightBlock();
                    break;
                case Direction.UP:
                    render.drawUpperBlock();
                    break;
                case Direction.DOWN:
                    render.drawLowerBlock();
                    break;
                default:
                    break;
            }

            sleep();
        }
    }
    
    private void sleep() 
    {
        try 
        {
            Thread.sleep(17); // controls game speed
        } catch(InterruptedException e)
        {
            e.printStackTrace();
         }
    }
}
