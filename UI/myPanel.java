package miniUndertaleGame.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;


import miniUndertaleGame.logic.InputHandler;
import miniUndertaleGame.logic.Direction;

public class myPanel extends JPanel 
{
    private BufferedImage heart, blockerVert, blockerHorz;
    int heartX, heartY, blockerX, blockerY;
    Direction direction;

    public myPanel(InputHandler input) 
    {
        setPreferredSize(new Dimension(Renderer.panelWidth, Renderer.panelHeight));
        setFocusable(true);
        addKeyListener(input);
        requestFocusInWindow();

        try 
        {
            heart = ImageIO.read(
                new File("logos/logo.png"));
            blockerHorz = ImageIO.read(
                new File("logos/blockerHorz.png"));
            blockerVert = ImageIO.read(
                new File("logos/blockerVert.png"));
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        heartX = (getWidth() - heart.getWidth()) / 2;
        heartY = (getHeight() - heart.getHeight()) / 2;

        // Heart image
        if (heart != null) 
        {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.drawImage(heart, heartX, heartY, this);
        }

        // Blocker drawing based on direction
        if (blockerVert != null && Renderer.isDrawLeftBlock) 
        {
            int blockerX = heartX - blockerVert.getWidth(); // to the left of the heart
            int blockerY = heartY + (heart.getHeight() - blockerVert.getHeight()) / 2;
            g.drawImage(blockerVert, blockerX, blockerY, this);
            Renderer.isDrawLeftBlock = false;
        } 
        else if (blockerVert != null && Renderer.isDrawRightBlock) 
        {
            int blockerX = heartX + heart.getWidth(); // to the right of the heart
            int blockerY = heartY + (heart.getHeight() - blockerVert.getHeight()) / 2;
            g.drawImage(blockerVert, blockerX, blockerY, this);
            Renderer.isDrawRightBlock = false;
        } 
        else if (blockerHorz != null && Renderer.isDrawUpperBlock) 
        {
            int blockerX = heartX + (heart.getWidth() - blockerHorz.getWidth()) / 2;
            int blockerY = heartY - blockerHorz.getHeight(); // above the heart
            g.drawImage(blockerHorz, blockerX, blockerY, this);
            Renderer.isDrawUpperBlock = false;
        } 
        else if (blockerHorz != null && Renderer.isDrawLowerBlock) 
        {
            int blockerX = heartX + (heart.getWidth() - blockerHorz.getWidth()) / 2;
            int blockerY = heartY + heart.getHeight(); // below the heart
            g.drawImage(blockerHorz, blockerX, blockerY, this);
            Renderer.isDrawLowerBlock = false;
        }
    }
}
