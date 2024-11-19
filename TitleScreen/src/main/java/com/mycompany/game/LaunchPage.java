/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.game;

/**
 *
 * @author bhlyn
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class LaunchPage implements ActionListener{
 
 JFrame frame = new JFrame();
 JButton myButton = new JButton("Play");
 JButton exitButton = new JButton("Exit");

 LaunchPage() {
  
  frame.setTitle("Snake Game");//Window
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(700,600);
  frame.setLayout(null);
  frame.setLocationRelativeTo(null);
  frame.setVisible(true);
  
  JLabel titleLabel = new JLabel("The Snake Game", JLabel.CENTER);//Title
  titleLabel.setFont(new Font("Arial", Font.BOLD, 45));
  titleLabel.setForeground(Color.BLACK);
  titleLabel.setBounds(90, 220, 500, 50);
  frame.getContentPane().setBackground(Color.GREEN);
  frame.add(titleLabel);
          
  myButton.setBounds(250,350,200,40);//play button
  myButton.setFocusable(false);
  myButton.addActionListener(this);
  frame.add(myButton);
  
  exitButton.setBounds(250,400,200,40);//exit button
  exitButton.setFocusable(false);
  exitButton.addActionListener(this);
  frame.add(exitButton);
  
 }

 @Override
 public void actionPerformed(ActionEvent e){
  
  if(e.getSource()==myButton){
   frame.dispose();
   NewWindow myWindow = new NewWindow();
  }
  
  if (e.getSource() == exitButton){
            System.exit(0);
        }
 }
}