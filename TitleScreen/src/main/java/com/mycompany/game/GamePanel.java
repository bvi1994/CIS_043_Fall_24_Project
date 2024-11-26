package com.mycompany.game;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author brvi
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.Random;

public class GamePanel  extends JPanel {
   
    private static final int SCREEN_WIDTH = 700;
    private static final int SCREEN_HEIGHT = 600;
    private static final int UNIT_SIZE = 25; // This is the size of each "unit grid"
    
    private int snakeXCoordinate;
    private int snakeYCoordinate;
    private int foodXCoordinate;
    private int foodYCoordinate;
    private char snakeMovementDirection = 'U';
    private int snakeDelay = 75; // This is in milliseconds
    private int currentScore = 1;
    private Random random;
    private Timer timer;
    
    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        random = new Random();
        initializeGame();
    }
    
    private void initializeGame(){
        this.currentScore = 0;
        this.snakeXCoordinate = SCREEN_WIDTH / 2;
        this.snakeYCoordinate = SCREEN_HEIGHT / 2;
        spawnFood();
        
        this.timer = new Timer(snakeDelay, e -> {
            moveSnake();
            repaint();
        });
        timer.start();
    }
    
    private void spawnFood(){
        this.foodXCoordinate = random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
        this.foodYCoordinate = random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(timer.isRunning()) {
            drawSnake(g);
            drawFood(g);  
            drawScore(g);
        } else {
            showGameOverScreen(g);
        }
        
    }
    
    private void drawSnake(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(this.snakeXCoordinate, this.snakeYCoordinate, UNIT_SIZE, UNIT_SIZE);
    }
    
    private void drawFood(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(this.foodXCoordinate, this.foodYCoordinate, UNIT_SIZE, UNIT_SIZE);
    }
    
    private void drawScore(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + currentScore, 10, 20);
    }   
    
    private void moveSnake() {
        switch(this.snakeMovementDirection) {
            case 'U':
                this.snakeYCoordinate -= UNIT_SIZE;
                break;
            case 'D':
                this.snakeYCoordinate += UNIT_SIZE;
                break;
            case 'L':
                this.snakeXCoordinate -= UNIT_SIZE;
                break;
            case 'R':
                this.snakeXCoordinate += UNIT_SIZE;
                break;
        }
        checkCollision();
    }
    
    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if(timer.isRunning()) {
                switch(e.getKeyCode()) {
                    // Note: We do not allow the reversing of direction
                    case KeyEvent.VK_UP:
                        if(snakeMovementDirection != 'D') {
                            snakeMovementDirection = 'U';
                        }
                    case KeyEvent.VK_DOWN:
                    if (snakeMovementDirection != 'U') {
                        snakeMovementDirection = 'D';
                    }
                    break;
                    case KeyEvent.VK_LEFT:
                        if (snakeMovementDirection != 'R') {
                            snakeMovementDirection = 'L';
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (snakeMovementDirection != 'L') {
                            snakeMovementDirection = 'R';
                        }
                        break;
                    }
            } else {
                switch(e.getKeyCode()) {
                    // Restarting the game options
                    case KeyEvent.VK_R: 
                        initializeGame();
                        repaint();
                        break;
                    case KeyEvent.VK_ESCAPE:
                        System.exit(0);
                        break;
                    case KeyEvent.VK_Q:
                        System.exit(0);
                        break;
                }
            }
        }
    }
    
     private void checkCollision() {
        if(snakeXCoordinate < 0 || 
                snakeYCoordinate < 0 ||
                snakeXCoordinate >= SCREEN_WIDTH || 
                snakeYCoordinate >= SCREEN_HEIGHT) {
            endGame();
        }
        if (snakeXCoordinate == foodXCoordinate && snakeYCoordinate == foodYCoordinate) {
            currentScore += 1;
            spawnFood();
        }
    }
     
     private void endGame() {
         timer.stop();
         repaint();
     }
     
     private void showGameOverScreen(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        FontMetrics gameOverMetrics = getFontMetrics(g.getFont());
        String gameOverMessage = "Game Over";
        g.drawString(gameOverMessage, (SCREEN_WIDTH - gameOverMetrics.stringWidth(gameOverMessage)) / 2, SCREEN_HEIGHT / 2);
         
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        FontMetrics restartMetrics = getFontMetrics(g.getFont());
        String restartMessage = "Press R to Restart or ESC/Q to Exit";
        g.drawString(restartMessage, (SCREEN_WIDTH - restartMetrics.stringWidth(restartMessage)) / 2, SCREEN_HEIGHT / 2 + 50);
     }
 
}