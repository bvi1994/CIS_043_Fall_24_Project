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

 JFrame frame = new JFrame();
 JLabel label = new JLabel("Hello!");
 
 NewWindow(){
  
  label.setBounds(0,0,100,50);
  label.setFont(new Font(null,Font.PLAIN,25));
  
  frame.add(label);
  
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(700,600);
  frame.setLayout(null);
  frame.setLocationRelativeTo(null);
  frame.setVisible(true);
 }
}