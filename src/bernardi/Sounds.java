/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bernardi;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



public class Sounds 
{
    public Sounds()
    {
        
    }
    
    public  void soundEating() 
    {
        
    try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/eatingshort.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY); 
        // If you want to stop the sound, then use clip.stop();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
    
    public void gameOver()
    {
      try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/gameover.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY); 
        // If you want to stop the sound, then use clip.stop();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    }
    
    public void crash1()
    {
      try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/crash4.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY); 
        // If you want to stop the sound, then use clip.stop();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    }
}
