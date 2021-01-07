/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.gameobject;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;
import java.util.ArrayList;
import mygame.state.Main;

/**
 * chef boy character 
 * @author leoze
 */
public class ChefBoy extends Character implements Action, ChangeHealth{
    
    private CharacterControl user; // object for controling player
    private BulletAppState bulletAppState; 
    
    private Vector3f walkDirection = new Vector3f(); // direction of walking (change in position, not current position)
    
    private boolean blocking; // if chefboy is blocking hits 
    
    
    public ChefBoy(SimpleApplication app, BulletAppState bulletAppState, Vector3f position, String name, int health){
        
        super(app, position, name, health);
        
        this.bulletAppState = bulletAppState;
        
        // this.player = app.gameState.getPlayer();CHANGE
        
        init();
        
    }
    

    @Override
    void init() {
        initCollision();
        setPosition();
    }
    
    /**
     * create collision hit box
     * add gravity and physics to player 
     */
    private void initCollision(){
        
        CapsuleCollisionShape capsuleShape = new CapsuleCollisionShape(1.5f, 6f, 1);
        user = new CharacterControl(capsuleShape, 0.05f);
        user.setJumpSpeed(60);
        user.setFallSpeed(60);
        
        bulletAppState.getPhysicsSpace().add(user);
        
        user.setGravity(new Vector3f(0,-60f,0));
        
       
    }
    
    public void behaviour(ArrayList<Item> items, ArrayList<Enemy> enemies){
        
        for(Item i : items){
            pickUpItem(i);
        }
        
        for(Enemy e : enemies){
            
        }
        
        
    }
    
    
    /**
     * set position of player
     */
    private void setPosition() {
        user.setPhysicsLocation(new Vector3f(-40, 20, 0));
        setPosition(new Vector3f(-40, 20, 0));
    }
    
    private void pickUpItem(Item item){
        
        double distance;
        
        double x = this.getPosition().x;
        double x1 = item.getPosition().x;
        double z = this.getPosition().z;
        double z1 = item.getPosition().z;
        distance = Math.sqrt(Math.pow(x1-x, 2) + Math.pow(z1-z, 2));
        
        if (item.getPickUpRadius() > distance){
            System.out.println("picked up item");
            item.delete();
            // also need to remove from item list 
            //call on item's method 
        }
        
    }
    
    private void addToInventory(Item item){
        
    }
    

    
    public void jump(){
        
        if(user.onGround()){
            user.jump(new Vector3f(0, 20f, 0)); 
        }
    }
    
    @Override
    public void move(Vector3f change){
        

        walkDirection.set(0, 0, 0); // reset walk direction change 
        
        
        walkDirection.addLocal(change);
        
        walkDirection.y = 0; // make sure player does not increase in y axis (up)
        
        user.setWalkDirection(walkDirection);
 
        setPosition(user.getPhysicsLocation());
        
    }
    


    @Override
    public void attack(Character character) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void block(){
        
    }
    
    
    @Override
    public void addHealth(int amount) {
        
    }

    @Override
    public void removeHealth(int amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void takeDamage(int arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   
}
