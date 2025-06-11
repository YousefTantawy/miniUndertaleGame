package miniUndertaleGame.logic;

public class Projectile 
{
    private Coordinates projectilePos;
    private Direction projectileDir;
    private int projectileSpeed;

    public Projectile(Direction direction, int speed, Coordinates startPos)
    {
        this.projectileDir = direction;
        this.projectileSpeed = speed;
        this.projectilePos = startPos;
    }

    public Coordinates getCoor()
    {
        return projectilePos;
    }

    public Direction getDirection()
    {
        return projectileDir;
    }

    public void setSpeed(int speed)
    {
        this.projectileSpeed = speed;
    }

    public int getSpeed()
    {
        return projectileSpeed; 
    }
}
