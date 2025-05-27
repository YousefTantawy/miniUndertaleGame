package miniUndertaleGame.logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter
{

    private Direction lastDirection = Direction.NULL;

    @Override
    public void keyPressed(KeyEvent e) 
    {
        switch (e.getKeyCode()) 
        {
            case KeyEvent.VK_A:
                System.out.println("A");
                lastDirection = Direction.LEFT;
                break;
            case KeyEvent.VK_D:
                System.out.println("D");
                lastDirection = Direction.RIGHT;
                break;
            case KeyEvent.VK_W:
                System.out.println("W");
                lastDirection = Direction.UP;
                break;
            case KeyEvent.VK_S:
                System.out.println("S");
                lastDirection = Direction.DOWN;
                break;
            default:
                lastDirection = Direction.NULL;
                break;
        }
    }

    public Direction getLastDirection() 
    {
        return lastDirection;
    }
}
