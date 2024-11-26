/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.game;

/**
 *
 * @author bhlyn
 */
import java.awt.*;
import javax.swing.*;

public class NewWindow {

    JFrame frame;
    
    public NewWindow() {
        frame = new JFrame("Snake Game");
        
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
 
 
}