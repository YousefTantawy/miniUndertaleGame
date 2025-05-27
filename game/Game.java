package miniUndertaleGame.game;
import miniUndertaleGame.logic.*;
import miniUndertaleGame.UI.*;

public class Game 
{
    InputHandler input = new InputHandler();
    Renderer render = new Renderer(input);    

    public void start()
    {
        render.drawBoard();
    }
}
