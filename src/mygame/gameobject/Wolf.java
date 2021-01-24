/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.gameobject;

import com.jme3.app.SimpleApplication;
import com.jme3.bounding.BoundingBox;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;

/**
 *
 * @author leoze
 */
public class Wolf extends Enemy{
    
    
    public Wolf(SimpleApplication app, BulletAppState bulletAppState, Vector3f position, String name, int health){
        super(app, bulletAppState, position, name, health);
        
        setAlive(true);
        setHealth(20);
        setDamage(3);
        setSpeed(0.5);
        setRange(10);
        setDetectionRange(100);
        setAttackSpeed(2);
        setCoolDown(2);
        
        init();
        initCollision();
        initAnimation();
        setModelPosition();

    }
    
    @Override
    void init() {
        
        // this is still pigs stuff 
        
        setMat(app.getAssetManager().loadMaterial("Materials/slime.j3m"));
        
        // change to xml file with animation later 
        // using pigs animation as a place holder change later
        setModel(app.getAssetManager().loadModel("Models/Wolf/Wolf.mesh.j3o"));
        
        System.out.println("loaded wolf");
        
        getModel().setMaterial(getMat());
        
        getModel().setShadowMode(RenderQueue.ShadowMode.Cast);
    }
}