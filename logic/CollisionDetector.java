package miniUndertaleGame.logic;

public class CollisionDetector 
{
    public static boolean isCollide(
        int rect1X, int rect1Y, int rect1Width, int rect1Height,
        int rect2X, int rect2Y, int rect2Width, int rect2Height
    ) 
    {
        return rect1X < rect2X + rect2Width &&
               rect1X + rect1Width > rect2X &&
               rect1Y < rect2Y + rect2Height &&
               rect1Y + rect1Height > rect2Y;
    }    
}
