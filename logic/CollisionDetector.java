package miniUndertaleGame.logic;

public class CollisionDetector 
{
    public static boolean isCollide(
        int projectille1X, int projectille1Y, int projectille1Width, int projectille1Height,
        int projectille2X, int projectille2Y, int projectille2Width, int projectille2Height
    ) 
    {
        return projectille1X < projectille2X + projectille2Width &&
               projectille1X + projectille1Width > projectille2X &&
               projectille1Y < projectille2Y + projectille2Height &&
               projectille1Y + projectille1Height > projectille2Y;
    }    
}
