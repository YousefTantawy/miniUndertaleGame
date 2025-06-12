package miniUndertaleGame.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;


import miniUndertaleGame.logic.InputHandler;
import miniUndertaleGame.game.Game;
import miniUndertaleGame.logic.Coordinates;
import miniUndertaleGame.logic.Direction;
import miniUndertaleGame.logic.ProjectileHandler;
import miniUndertaleGame.logic.Projectile;
import java.util.Iterator;

public class myPanel extends JPanel 
{
    private BufferedImage heartImag, blockerVertImag, blockerHorzImag, bulletImag;
    private static Coordinates heartCoor = new Coordinates(0, 0), blockerCoor = new Coordinates(0, 0);
    
    private Direction direction;
    private final InputHandler input;
    private final ProjectileHandler projectile;

    private static int projectileWidth, projectileHeight;
    private static int heartWidth, heartHeight;
    private static int blockerHorzWidth, blockerHorzHeight;
    private static int blockerVertWidth, blockerVertHeight;

      public myPanel(InputHandler input, ProjectileHandler projectile) 
    {
        setPreferredSize(new Dimension(Renderer.panelWidth, Renderer.panelHeight));
        setFocusable(true);
        addKeyListener(input);
        requestFocusInWindow();
        this.input = input;
        this.projectile = projectile;

        try 
        {
            heartImag = ImageIO.read(new File("logos/logo.png"));
            heartWidth = heartImag.getWidth();
            heartHeight = heartImag.getHeight();

            blockerHorzImag = ImageIO.read(new File("logos/blockerHorz.png"));
            blockerHorzWidth = blockerHorzImag.getWidth();
            blockerHorzHeight = blockerHorzImag.getHeight();

            blockerVertImag = ImageIO.read(new File("logos/blockerVert.png"));
            blockerVertWidth = blockerVertImag.getWidth();
            blockerVertHeight = blockerVertImag.getHeight();

            bulletImag = ImageIO.read(new File("logos/projectile.png"));
            projectileWidth = bulletImag.getWidth();
            projectileHeight = bulletImag.getHeight();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public void blockerDrawing(Graphics g)
    {
        // Blocker drawing based on direction
        if (blockerVertImag != null && input.getLastDirection() == Direction.LEFT) 
        {
            blockerCoor.setX(heartCoor.getX() - blockerVertImag.getWidth() - 20); // to the left of the heart
            blockerCoor.setY(heartCoor.getY() + (heartImag.getHeight() - blockerVertImag.getHeight()) / 2);
            g.drawImage(blockerVertImag, blockerCoor.getX(), blockerCoor.getY(), this);
        } 
        else if (blockerVertImag != null && input.getLastDirection() == Direction.RIGHT) 
        {
            blockerCoor.setX(heartCoor.getX() + heartImag.getWidth() + 20); // to the right of the heart
            blockerCoor.setY(heartCoor.getY() + (heartImag.getHeight() - blockerVertImag.getHeight()) / 2);
            g.drawImage(blockerVertImag, blockerCoor.getX(), blockerCoor.getY(), this);
        } 
        else if (blockerHorzImag != null && input.getLastDirection() == Direction.UP) 
        {
            blockerCoor.setX(heartCoor.getX() + (heartImag.getWidth() - blockerHorzImag.getWidth()) / 2);
            blockerCoor.setY(heartCoor.getY() - blockerHorzImag.getHeight() - 20); // above the heart
            g.drawImage(blockerHorzImag, blockerCoor.getX(), blockerCoor.getY(), this);
        } 
        else if (blockerHorzImag != null && input.getLastDirection() == Direction.DOWN) 
        {
            blockerCoor.setX(heartCoor.getX() + (heartImag.getWidth() - blockerHorzImag.getWidth()) / 2);
            blockerCoor.setY(heartCoor.getY() + heartImag.getHeight() + 20); // below the heart
            g.drawImage(blockerHorzImag, blockerCoor.getX(), blockerCoor.getY(), this);
        }
    }

    public void projectileDrawing(Graphics g)
    {
        for (Projectile p : projectile.getList()) 
        {
            if (bulletImag != null)
                g.drawImage(bulletImag, p.getCoor().getX(), p.getCoor().getY(), this);
        }
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        
        // heart image
        if (heartImag != null) 
        {
            heartCoor.setX((this.getWidth() - heartImag.getWidth()) / 2);
            heartCoor.setY((this.getHeight() - heartImag.getHeight()) / 2);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.drawImage(heartImag, heartCoor.getX(), heartCoor.getY(), this);
        }

        blockerDrawing(g);
        projectileDrawing(g);

        
    }

    // Getters 
    public static int getHeartWidth() {
        return heartWidth;
    }

    public static int getHeartHeight() {
        return heartHeight;
    }

    public static int getHeartX() {
        return heartCoor.getX();
    }

    public static int getHeartY() {
        return heartCoor.getY();
    }

    public static int getBlockerX() {
        return blockerCoor.getX();
    }

    public static int getBlockerY() {
        return blockerCoor.getY();
    }

    public static int getBlockerHorzWidth() {
        return blockerHorzWidth;
    }

    public static int getBlockerHorzHeight() {
        return blockerHorzHeight;
    }

    public static int getBlockerVertWidth() {
        return blockerVertWidth;
    }

    public static int getBlockerVertHeight() {
        return blockerVertHeight;
    }

    public static int getProjectileWidth() {
        return projectileWidth;
    }

    public static int getProjectileHeight() {
        return projectileHeight;
    }
}
