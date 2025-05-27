package miniUndertaleGame.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

import miniUndertaleGame.logic.InputHandler;
import miniUndertaleGame.logic.Direction;

public class myPanel extends JPanel {
    private BufferedImage heart, blockerVert, blockerHorz;
    private final InputHandler input;

    public myPanel(InputHandler input) {
        this.input = input;

        setPreferredSize(new Dimension(640, 560));
        setFocusable(true);
        addKeyListener(input);
        requestFocusInWindow();

        try {
            heart = ImageIO.read(new File("logo.png"));
            blockerHorz = ImageIO.read(new File("blockerHorz.png"));
            blockerVert = ImageIO.read(new File("blockerVert.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Timer to repaint at ~60 FPS
        new Timer(17, e -> repaint()).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int heartX = (getWidth() - heart.getWidth());
        int heartY = (getHeight() - heart.getHeight());

        // Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Heart image
        if (heart != null) 
        {
            g.drawImage(heart, heartX, heartY, this);
        }

        Direction direction = input.getLastDirection();

        // Blocker drawing based on direction
        if (direction == Direction.LEFT && blockerVert != null) {
            int x = heartX - blockerVert.getWidth(); // to the left of the heart
            int y = heartY + (heart.getHeight() - blockerVert.getHeight()) / 2;
            g.drawImage(blockerVert, x, y, this);
        } 
        else if (direction == Direction.RIGHT && blockerVert != null) {
            int x = heartX + heart.getWidth(); // to the right of the heart
            int y = heartY + (heart.getHeight() - blockerVert.getHeight()) / 2;
            g.drawImage(blockerVert, x, y, this);
        } 
        else if (direction == Direction.UP && blockerHorz != null) {
            int x = heartX + (heart.getWidth() - blockerHorz.getWidth()) / 2;
            int y = heartY - blockerHorz.getHeight(); // above the heart
            g.drawImage(blockerHorz, x, y, this);
        } 
        else if (direction == Direction.DOWN && blockerHorz != null) {
            int x = heartX + (heart.getWidth() - blockerHorz.getWidth()) / 2;
            int y = heartY + heart.getHeight(); // below the heart
            g.drawImage(blockerHorz, x, y, this);
        }
    }
}
