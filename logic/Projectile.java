package miniUndertaleGame.logic;

import miniUndertaleGame.logic.Coordinates;

public class Projectile 
{
    private Coordinates projectilePos = new Coordinates(0, 0);
    private Direction projectileDir;

    public Projectile(Direction direction)
    {
        projectileDir = direction;
    }

    public int getX() {
        return projectilePos.getX();
    }
    public int getY() {
        return projectilePos.getY();
    }

    public void setX(int x) {
    projectilePos.setX(x);
    }
    public void setY(int y) {
        projectilePos.setY(y);
    }
}
