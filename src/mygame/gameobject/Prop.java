/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame.gameobject;

import mygame.Main;

/**
 * prop objects 
 * @author leoze
 */
public abstract class Prop extends Map{

    public Prop(Main main, int x, int y, int z, String name){
        super(main, x, y, z, name);
    }
}