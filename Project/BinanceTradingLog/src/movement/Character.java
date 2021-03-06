/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movement;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Administrator
 */
public class Character {
    private float orientation;
    private Vector2D position;
    private float rotation;
    private Vector2D velocity;
    private int r;
    private Color color;
    private String characterName;

    public Character() {
    }

    public Character(float orientation, Vector2D position, float rotation, Vector2D velocity) {
        this.orientation = orientation;
        this.position = position;
        this.rotation = rotation;
        this.velocity = velocity;
    }

    public float getOrientation() {
        return orientation;
    }

    public void setOrientation(float orientation) {
        this.orientation = orientation;
    }

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public Vector2D getVelocity() {
        return velocity;
    }
    
    public void setVelocity(Vector2D velocity) {
        this.velocity = velocity;
    }
    
    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
    
    public void update(KinematicOutput kinematicOutput,float time){
        this.velocity = kinematicOutput.getVelocity();
        this.rotation = kinematicOutput.getRotation();
        
        this.position.addVector2D(this.velocity.mulConstant(time));
        this.orientation+=this.rotation*time;
    }
    
    public void applyNewOrientation(){
        if(this.velocity.length()>0){
            this.orientation = (float) Math.atan2(-this.velocity.getX(),this.velocity.getZ());
        }
    }
    
    public void initRender(Color color,int r){
        this.color = color;
        this.r = r;
    }
    
    public void reloadCharacter(Character c){
        if(c.getPosition().getX()>800||c.getPosition().getX()<0){
            c.setPosition(new Vector2D((c.getPosition().getX()+800)%800,c.getPosition().getZ()));
        }
        if(c.getPosition().getZ()>800||c.getPosition().getZ()<0){
            c.setPosition(new Vector2D(c.getPosition().getX(),(c.getPosition().getZ()+800)%800));
        }
    }
    
    
    public void render(Graphics g){
        float x = (float)Math.sin(getOrientation());
        float z = (float)Math.cos(getOrientation());
        g.setColor(color);
        g.drawOval((int)this.position.getX(),(int) this.position.getZ(),r*2, r*2);
        g.drawLine((int) (this.position.getX()+r),(int)(this.position.getZ()+r),(int) (this.position.getX()+this.r*(x+1)), (int) (this.position.getZ()+this.r*(z+1)));
    }
    
    private static Character[] result;
    private static Character[] characters;
    private static int sum = 0;
    
    static void Try(int i,int start){
        if(i==result.length) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[j].getCharacterName()+ "\t");
            }
            System.out.println();
            sum++;
            return;
        }
        for(int j=start;j<characters.length;j++){
            result[i] = characters[j];
            Try(i+1,j+1);
        }
    }
    
    public static void main(String[] args) {
        characters = new Character[10];
        result = new Character[3];
        for (int i = 0; i < characters.length; i++) {
            characters[i] = new Character();
            characters[i].setCharacterName("Character A"+i);
        }
        Try(0,0);
        
        
    }
}
