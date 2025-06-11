package miniUndertaleGame.logic;

import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import miniUndertaleGame.logic.Coordinates;
import miniUndertaleGame.logic.Projectile;

public class ProjectileHandler
{
    private int dirDecision;
    private Vector<Projectile> projectileList = new Vector<>(); 
    private final Random rand = new Random();

    public void bulletCreation() 
    {
        dirDecision = rand.nextInt(4);
        projectileList.add(new Projectile(Direction.values()[dirDecision]));
        System.out.println("Projectile fired!");
    }

    public Vector<Projectile> getList()
    {
        return projectileList;
    }
}
