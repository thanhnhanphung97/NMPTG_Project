/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movement;

import com.sun.media.jfxmedia.logging.Logger;
import java.awt.Color;
import java.util.logging.Level;
import sun.security.util.PropertyExpander;

/**
 *
 * @author Administrator
 */
public class GameLoop implements Runnable{
    
    private boolean isRunning;
    private Demo demo;

    public GameLoop() {
    }

    public GameLoop(boolean isRunning, Demo demo) {
        this.isRunning = isRunning;
        this.demo = demo;
    }

    public boolean isIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public Demo getDemo() {
        return demo;
    }

    public void setDemo(Demo demo) {
        this.demo = demo;
    }
    
    
    
    @Override
    public void run(){
        
            Character character1 = new Character(0,new Vector2D(50,50),0,new Vector2D(200,200));
            Character character2 = new Character(0,new Vector2D(300,300),0,new Vector2D(400,400));
            character1.initRender(Color.red,40);
            character2.initRender(Color.blue, 60);
            Wandering wander1 = new Wandering(character1,3, (float) Math.PI/10);
            Wandering wander2 = new Wandering(character2,3, (float) (Math.PI/12));
            
            while(isRunning){
                demo.getGraphics().clearRect(0, 0, demo.getWidth(), demo.getHeight());
                character1.update(wander1.generateKinematicSteeringOutput(), 1);
                character2.update(wander2.generateKinematicSteeringOutput(), 1);
                character1.render(demo.getGraphics());
                character2.render(demo.getGraphics());
                character1.reloadCharacter(character1);
                character2.reloadCharacter(character2);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    java.util.logging.Logger.getLogger(GameLoop.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    
}
