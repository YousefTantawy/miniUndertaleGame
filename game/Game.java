package miniUndertaleGame.game;

//import miniUndertaleGame.*;
import miniUndertaleGame.logic.*;
import miniUndertaleGame.music.MusicPlayer;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.SwingUtilities;

import miniUndertaleGame.UI.*;
import miniUndertaleGame.logic.CollisionDetector;

public class Game 
{
    InputHandler input;
    ProjectileHandler projectile;
    Renderer render; 
    MusicPlayer musicPlayer;

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
            musicPlayer = new MusicPlayer();
            musicPlayer.play("miniUndertaleGame/music/undyneOST.wav", true);

            render = new Renderer(input, projectile);

            // 2) Then schedule your fixed‐rate game loop:
            gameTimer.scheduleAtFixedRate(new TimerTask() {
    @Override
    public void run() {
        SwingUtilities.invokeLater(() -> {
            render.render();

            for (int i = 0; i < projectile.getList().size(); i++) {
                if (CollisionDetector.isCollide(
                        projectile.getList().get(i).getCoor().getX(),
                        projectile.getList().get(i).getCoor().getY(),
                        myPanel.getProjectileWidth(),
                        myPanel.getProjectileHeight(),
                        myPanel.getHeartX(),
                        myPanel.getHeartY(),
                        myPanel.getHeartWidth(),
                        myPanel.getHeartHeight())) {

                    System.out.println("Heart is hit");
                    projectile.getList().remove(i);
                    i--;
                }

                else if (
                    CollisionDetector.isCollide(
                        projectile.getList().get(i).getCoor().getX(),
                        projectile.getList().get(i).getCoor().getY(),
                        myPanel.getProjectileWidth(),
                        myPanel.getProjectileHeight(),
                        myPanel.getBlockerX(),
                        myPanel.getBlockerY(),
                        myPanel.getBlockerVertWidth(),
                        myPanel.getBlockerVertHeight()
                    ) ||

                    CollisionDetector.isCollide(
                        projectile.getList().get(i).getCoor().getX(),
                        projectile.getList().get(i).getCoor().getY(),
                        myPanel.getProjectileWidth(),
                        myPanel.getProjectileHeight(),
                        myPanel.getBlockerX(),
                        myPanel.getBlockerY(),
                        myPanel.getBlockerHorzWidth(),
                        myPanel.getBlockerHorzHeight()
                    )) {

                    System.out.println("Guard is hit");
                    projectile.getList().remove(i);
                    i--;
                }
            }
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
                        projectile.updatePosition();
                    });
                }
            }, 
            0, 
            570);
        });
    }
}
