/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movement;

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
    
    public static int getBinomial(int n, double p) {
	double log_q = Math.log(1.0 - p);
	int x = 0;
	double sum = 0;
	for(;;) {
            sum += Math.log(Math.random()) / (n - x);
            if(sum < log_q) {
		return x;
            }
            x++;
	}
    }
    
    public KinematicOutput generateKinematicOutput () {
		Vector2D orientation = new Vector2D();
		orientation.setZ((float)Math.cos(character.getOrientation()));
		orientation.setX((float)Math.sin(character.getOrientation()));
		
		Vector2D velocity = new Vector2D();
		velocity =  Vector2D.mulVector2D(orientation, maxSpeed);
		
		float rotation = getBinomial(100, 5.0)*maxRotation;
		
		return new KinematicOutput(velocity, rotation);
	}
}
