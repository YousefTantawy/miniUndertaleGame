package miniUndertaleGame.UI;

import javax.swing.*;
import miniUndertaleGame.logic.InputHandler;
import miniUndertaleGame.logic.ProjectileHandler;


public class Renderer 
{
    public static final int panelWidth = 640;
    public static final int panelHeight = 640;
    private JFrame frame;
    private myPanel panel;

    public Renderer(InputHandler input, ProjectileHandler projectile) 
    {
        panel = new myPanel(input, projectile);

        frame = new JFrame("Undertale: Mini-Undyne version");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel); // <== this adds your drawing panel to the window
        frame.pack(); // Sizes frame to fit the preferred size of the panel
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // Centers the window on screen
        frame.setVisible(true);
    }

    public void render()
    {
        panel.repaint();
    }
}
