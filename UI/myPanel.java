package miniUndertaleGame.UI;

import javax.swing.*;

import miniUndertaleGame.logic.InputHandler;

import java.awt.*;

public class myPanel extends JPanel 
{
    public myPanel(InputHandler input) 
    {
        // setPreferredSize(new Dimension(
        //     GameBoard.getWidth() * Renderer.blockSize,
        //     GameBoard.getHeight() * Renderer.blockSize
        // ));
        setFocusable(true);
        addKeyListener(input);
        requestFocusInWindow();
    }
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);

    }
}
