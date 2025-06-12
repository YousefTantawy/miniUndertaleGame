package miniUndertaleGame.logic;

import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import miniUndertaleGame.logic.Coordinates;
import miniUndertaleGame.logic.Projectile;
import miniUndertaleGame.UI.Renderer;
import miniUndertaleGame.UI.myPanel;

public class ProjectileHandler
{
    private int dirDecision;
    private int randSpeed;
    private Vector<Projectile> projectileList = new Vector<>(); 
    private final Random rand = new Random();

    public void bulletCreation() 
{
    dirDecision = rand.nextInt(4); // 0=UP, 1=DOWN, 2=LEFT, 3=RIGHT
    randSpeed = rand.nextInt(20) + 3;
    Direction direction = Direction.values()[dirDecision];

    // Initialize coordinates based on direction
    int x = 0, y = 0;

    switch (direction) 
    {
        case UP:
            x = (Renderer.panelWidth - myPanel.getProjectileWidth()) / 2;
            y = Renderer.panelHeight; // Start from bottom, move up
            break;
        case DOWN:
            x = (Renderer.panelWidth - myPanel.getProjectileWidth()) / 2;
            y = 0; // Start from top, move down
            break;
        case LEFT:
            x = Renderer.panelWidth;
            y = (Renderer.panelHeight - myPanel.getProjectileHeight()) / 2; // Start from right, move left
            break;
        case RIGHT:
            x = 0;
            y = (Renderer.panelHeight - myPanel.getProjectileHeight()) / 2; // Start from left, move right
            break;
        case NULL:
            break;
    }

    Coordinates start = new Coordinates(x, y);
    projectileList.add(new Projectile(direction, randSpeed, start));

    //System.out.println("Projectile fired! Direction: " + direction + ", Speed: " + randSpeed);
}
    public void updatePosition()
    {
        for(int i = 0; i < projectileList.size(); i++)
        {
            switch(projectileList.get(i).getDirection())
            {
            case UP:
                projectileList.get(i).getCoor().setY(projectileList.get(i).getCoor().getY() - projectileList.get(i).getSpeed());
                break;
            case DOWN:
                projectileList.get(i).getCoor().setY(projectileList.get(i).getCoor().getY() + projectileList.get(i).getSpeed());
                break;
            case LEFT:
                projectileList.get(i).getCoor().setX(projectileList.get(i).getCoor().getX() - projectileList.get(i).getSpeed());
                break;
            case RIGHT:
                projectileList.get(i).getCoor().setX(projectileList.get(i).getCoor().getX() + projectileList.get(i).getSpeed());
                break;
            case NULL:
                break;
            }
        }
    }
    public Vector<Projectile> getList()
    {
        return projectileList;
    }
}
