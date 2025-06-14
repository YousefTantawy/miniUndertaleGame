package miniUndertaleGame.music;

import javax.sound.sampled.*;

public class MusicPlayer {
    private Clip clip;

    public void play(String resourcePath, boolean loop) {
        try {
            // Carga el archivo como recurso desde el classpath
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(
                getClass().getClassLoader().getResourceAsStream(resourcePath)
            );

            clip = AudioSystem.getClip();
            clip.open(audioStream);

            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.start();
            }
        } catch (Exception e) {
            System.out.println("Error playing music: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}