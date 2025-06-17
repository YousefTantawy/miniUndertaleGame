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
    public static int scoreCount = 0, livesCount = 3;
    public static boolean gameOver;
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
            musicPlayer.play("miniUndertaleGame/music/undyneOSTNormalVer.wav", true);

            render = new Renderer(input, projectile);

            // 2) Then schedule your fixed‐rate game loop:
            gameTimer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            SwingUtilities.invokeLater(() -> {
                gameOver = (livesCount == 0);
                render.render();
                if(!gameOver)
                    for (int i = 0; i < projectile.getList().size(); i++) {
                        if (CollisionDetector.isCollide(
                                projectile.getList().get(i).getCoor().getX(),
                                projectile.getList().get(i).getCoor().getY(),
                                myPanel.getProjectileWidth(),
                                myPanel.getProjectileHeight(),
                                myPanel.getHeart().getX(),
                                myPanel.getHeart().getY(),
                                myPanel.getHeartWidth(),
                                myPanel.getHeartHeight())) {

                            System.out.println("Heart is hit");
                            livesCount--;
                            projectile.getList().remove(i);
                            i--;
                        }

                        else if (
                            CollisionDetector.isCollide(
                                projectile.getList().get(i).getCoor().getX(),
                                projectile.getList().get(i).getCoor().getY(),
                                myPanel.getProjectileWidth(),
                                myPanel.getProjectileHeight(),
                                myPanel.getBlocker().getX(),
                                myPanel.getBlocker().getY(),
                                myPanel.getBlockerVertWidth(),
                                myPanel.getBlockerVertHeight()
                            ) 
                            ||
                            CollisionDetector.isCollide(
                                projectile.getList().get(i).getCoor().getX(),
                                projectile.getList().get(i).getCoor().getY(),
                                myPanel.getProjectileWidth(),
                                myPanel.getProjectileHeight(),
                                myPanel.getBlocker().getX(),
                                myPanel.getBlocker().getY(),
                                myPanel.getBlockerHorzWidth(),
                                myPanel.getBlockerHorzHeight()
                            )) {

                            System.out.println("Guard is hit");
                            scoreCount++;
                            projectile.getList().remove(i);
                            i--;
                        }
                    }
                else
                {
                    musicPlayer.stop();
                    musicPlayer.play("miniUndertaleGame/music/gameOver.wav", false);

                    gameTimer.cancel();
                    projectileTimer.cancel();

                    return;
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
                    });
                }
            }, 
            0, 
            570);

            projectileTimer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    // Always update Swing components on the EDT:
                    SwingUtilities.invokeLater(() -> {
                        projectile.updatePosition();
                    });
                }
            }, 
            0,
            33);
        });
    }
}
