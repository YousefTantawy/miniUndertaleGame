package miniUndertaleGame.UI;

import javax.swing.*;
import miniUndertaleGame.logic.InputHandler;


public class Renderer 
{
    public static boolean isDrawLeftBlock, isDrawRightBlock, isDrawUpperBlock, isDrawLowerBlock;
    public static final int panelWidth = 640;
    public static final int panelHeight = 560;
    private JFrame frame;
    private myPanel panel;

    public Renderer(InputHandler input) 
    {
        panel = new myPanel(input);

        frame = new JFrame("Undertale: Undyne Score version");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel); // <== this adds your drawing panel to the window
        frame.pack(); // Sizes frame to fit the preferred size of the panel
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // Centers the window on screen
        frame.setVisible(true);
    }

    public void drawBoard()
    {
        panel.repaint();
    }

    public void drawLeftBlock()
    {
        isDrawLeftBlock = true;
        panel.repaint();
    }

    public void drawRightBlock()
    {
        isDrawRightBlock = true;
        panel.repaint();
    }

    public void drawUpperBlock()
    {
        isDrawUpperBlock = true;
        panel.repaint();
    }

    public void drawLowerBlock()
    {
        isDrawLowerBlock = true;
        panel.repaint();
    }
}
