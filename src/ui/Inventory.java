/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.math.Vector2f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.system.AppSettings;
import com.jme3.ui.Picture;
import java.util.ArrayList;
import mygame.gameobject.Item;

/**
 *
 * @author leoze
 */
public class Inventory {
    
    private SimpleApplication app;
    
    private ArrayList<Item> itemList; // list to temp store items for sorting 
    private Item[][] item; // grid to store item 
    private Vector2f[][] position; // positions to place pictures 
    private int pictureSize; // size of all itemPics in pixels
    
    private Item selected;
    
    private static final int SCREENWIDTH = 1500;
    private static final int SCREENHEIGHT = 800;
    
    
    public Inventory(SimpleApplication app){
        this.app = app;
        itemList = new ArrayList<>(); 
        item = new Item[5][10]; 
        position = new Vector2f[5][10];
        selected = null;
        init();
    }
    
    private void init(){
        
        System.out.println("init inventory");
    }
    
    public void initPicture(){
        System.out.println("init inventory pictures");
        
        AppSettings settings = new AppSettings(true);
        
        Picture inventoryBackground = new Picture("inventoryBackground");
        inventoryBackground.setImage(app.getAssetManager(), "UI/inventory background.png", true);
        inventoryBackground.setWidth(SCREENWIDTH);
        inventoryBackground.setHeight(SCREENHEIGHT);
        inventoryBackground.setPosition(0, 0);

        app.getGuiNode().attachChild(inventoryBackground);
        inventoryBackground.setQueueBucket(RenderQueue.Bucket.Gui);
    }
    
    
    public void update(){
        display();
    }
    
    public void add(Item item){
        itemList.add(item);
    }
    
    public void remove(Item item){
        itemList.remove(item);
    }
    
    public void sort(){
        
    }
    
    private void selectItem(Vector2f mousePosition){
        // selected = item at mouse location 
    }
    
    /**
     * drag item from position with mouse 
     * @param item 
     * @param mousePosition 
     */
    public void drag(Item item, Vector2f mousePosition){
        if(item != null){
            // make item follow mouse position 
        }
    }
    
    /**
     * set item down with mouse 
     * @param item 
     * @param mousePosition 
     */
    public void place(Item item, Vector2f mousePosition){
        // called with mouse lets go
        // place item at empty spot
        // if spot is not empty, return item to original location 
        selected = null;
    }
    
    private void display(){
        // loop through each itemPic 
        // display each 
    }
    
    private void displaySelected(Item item, Vector2f mousePosition){
        // display selected item and it's changed position 
    }
    
}
