/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movement;

import java.util.Random;

/**
 *
 * @author Administrator
 */
public class Wandering {
    private Character character;
    private float maxSpeed;
    private float maxRotation;

    public Wandering() {
    }

    public Wandering(Character character, float maxSpeed, float maxRotation) {
        this.character = character;
        this.maxSpeed = maxSpeed;
        this.maxRotation = maxRotation;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public float getMaxRotation() {
        return maxRotation;
    }

    public void setMaxRotation(float maxRotation) {
        this.maxRotation = maxRotation;
    }
    
    public static float randomBionomial(){
        Random r = new Random();
        return r.nextFloat()-r.nextFloat();
    }
    
    public KinematicSteeringOutput generateKinematicSteeringOutput(){
        float x=(float) (Math.sin(character.getOrientation()));
        float z=(float) (Math.cos(character.getOrientation()));
        
        Vector2D velocity=new Vector2D(x,z);
        velocity.mulConstant(maxSpeed);
        float rotation=randomBionomial()*maxRotation;
        return new KinematicSteeringOutput(velocity,rotation);
    }
}
