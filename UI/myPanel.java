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
    private Image heartImag, heartOverImag, blockerVertImag, blockerHorzImag, bulletImag, gameOverImag, temp;
    private static Coordinates heartCoor = new Coordinates(0, 0), blockerCoor = new Coordinates(0, 0);
    private int score = 0;

    private Direction direction;
    private final InputHandler input;
    private final ProjectileHandler projectile;

    private static int projectileWidth, projectileHeight;
    private static int heartWidth, heartHeight;
    private static int blockerHorzWidth, blockerHorzHeight;
    private static int blockerVertWidth, blockerVertHeight;
    private int gameOverHorz, gameOverVert;

      public myPanel(InputHandler input, ProjectileHandler projectile) 
    {
        setPreferredSize(new Dimension(Renderer.panelWidth, Renderer.panelHeight));
        setFocusable(true);
        addKeyListener(input);
        requestFocusInWindow();
        this.input = input;
        this.projectile = projectile;

        //heartImag = ImageIO.read(new File("logos/heart.gif"));
        // for using gif, need of ImageIcon is needed
        heartImag = new ImageIcon("logos/heart.gif").getImage();
        heartOverImag = new ImageIcon("logos/logoGameOver.png").getImage();
        heartWidth = heartImag.getWidth(this);
        heartHeight = heartImag.getHeight(this);

        gameOverImag = new ImageIcon("logos/GameOver.png").getImage(); 
        temp = new ImageIcon("logos/images.png").getImage();
        

        blockerHorzImag = new ImageIcon("logos/blockerHorz.png").getImage();
        blockerHorzWidth = blockerHorzImag.getWidth(this);
        blockerHorzHeight = blockerHorzImag.getHeight(this);

        blockerVertImag = new ImageIcon("logos/blockerVert.png").getImage();
        blockerVertWidth = blockerVertImag.getWidth(this);
        blockerVertHeight = blockerVertImag.getHeight(this);

        bulletImag = new ImageIcon("logos/projectile.png").getImage();
        projectileWidth = bulletImag.getWidth(this);
        projectileHeight = bulletImag.getHeight(this);
    }

    public void blockerDrawing(Graphics g)
{
    int spacing = heartImag.getWidth(this) / 10; // dynamic spacing

    if (blockerVertImag != null && input.getLastDirection() == Direction.LEFT) 
    {
        blockerCoor.setX(heartCoor.getX() - blockerVertImag.getWidth(this) - spacing);
        blockerCoor.setY(heartCoor.getY() + (heartImag.getHeight(this) - blockerVertImag.getHeight(this)) / 2);
        g.drawImage(blockerVertImag, blockerCoor.getX(), blockerCoor.getY(), this);
    } 
    else if (blockerVertImag != null && input.getLastDirection() == Direction.RIGHT) 
    {
        blockerCoor.setX(heartCoor.getX() + heartImag.getWidth(this) + spacing);
        blockerCoor.setY(heartCoor.getY() + (heartImag.getHeight(this) - blockerVertImag.getHeight(this)) / 2);
        g.drawImage(blockerVertImag, blockerCoor.getX(), blockerCoor.getY(), this);
    } 
    else if (blockerHorzImag != null && input.getLastDirection() == Direction.UP) 
    {
        blockerCoor.setX(heartCoor.getX() + (heartImag.getWidth(this) - blockerHorzImag.getWidth(this)) / 2);
        blockerCoor.setY(heartCoor.getY() - blockerHorzImag.getHeight(this) - spacing);
        g.drawImage(blockerHorzImag, blockerCoor.getX(), blockerCoor.getY(), this);
    } 
    else if (blockerHorzImag != null && input.getLastDirection() == Direction.DOWN) 
    {
        blockerCoor.setX(heartCoor.getX() + (heartImag.getWidth(this) - blockerHorzImag.getWidth(this)) / 2);
        blockerCoor.setY(heartCoor.getY() + heartImag.getHeight(this) + spacing);
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

    public void scoreDrawing(Graphics g)
    {
        g.setColor(Color.RED);
        g.setFont(new Font("Papyrus", Font.BOLD, 24));
        g.drawString("Score: " + Game.scoreCount, 20, 30);
        g.drawString("Lives: " + Game.livesCount, 20, 60);
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        if(!Game.gameOver)
        {
            if (heartImag != null) 
            {
                heartCoor.setX((this.getWidth() - heartImag.getWidth(this)) / 2);
                heartCoor.setY((this.getHeight() - heartImag.getHeight(this)) / 2);
                g.drawImage(heartImag, heartCoor.getX(), heartCoor.getY(), this);
            }

            blockerDrawing(g);
            projectileDrawing(g);
            scoreDrawing(g);
        }
        else
        {
            if (heartOverImag != null)
            {
                heartCoor.setX((this.getWidth() - heartOverImag.getWidth(this)) / 2);
                heartCoor.setY((this.getHeight() - heartOverImag.getHeight(this)) / 2);
                g.drawImage(heartOverImag, heartCoor.getX(), heartCoor.getY(), this);
            }

            if (gameOverImag != null) {
                gameOverHorz = (this.getWidth() - gameOverImag.getWidth(this)) / 2;
                gameOverVert = (this.getHeight() - gameOverImag.getHeight(this)) / 2 - this.getHeight()/4;
                g.drawImage(gameOverImag, gameOverHorz, gameOverVert, this);
            }
            
            g.setColor(Color.RED);
            g.setFont(new Font("Papyrus", Font.BOLD, 24));
            g.drawString("Score: " + Game.scoreCount, this.getWidth() / 3 + heartOverImag.getWidth(this), this.getHeight() * 3 / 4);
            //g.drawString("Press R to retry", this.getWidth() / 3 + heartOverImag.getWidth(this) - 20, this.getHeight() * 3 / 4 + 30);
        }
    }



    // Getters 
    public static int getHeartWidth() {
        return heartWidth;
    }

    public static int getHeartHeight() {
        return heartHeight;
    }

    public static Coordinates getHeart() {
        return heartCoor;
    }

    public static Coordinates getBlocker() {
        return blockerCoor;
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
