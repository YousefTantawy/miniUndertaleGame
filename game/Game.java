package miniUndertaleGame.game;

//import miniUndertaleGame.*;
import miniUndertaleGame.logic.*;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.SwingUtilities;

import miniUndertaleGame.UI.*;

public class Game 
{
    InputHandler input;
    ProjectileHandler projectile;
    Renderer render; 
    private final Timer gameTimer = new Timer("Game-Loop", true);
    private final Timer projectileTimer = new Timer("Projectile-spawn", true);

    public Game()
    {
        input = new InputHandler();
        projectile = new ProjectileHandler();
    }

    public void start()
    {
        // 1) First, create your UI on the EDT:
        SwingUtilities.invokeLater(() -> {
            render = new Renderer(input, projectile);

            // 2) Then schedule your fixed‐rate game loop:
            gameTimer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    // Always update Swing components on the EDT:
                    SwingUtilities.invokeLater(() -> {
                        render.render();
                    });
                }
            }, 
            0, 
            17);

            projectileTimer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    // Always update Swing components on the EDT:
                    SwingUtilities.invokeLater(() -> {
                        projectile.bulletCreation();
                    });
                }
            }, 
            0, 
            300);
        });
    }
}
