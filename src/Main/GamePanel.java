package Main;

import javax.swing.JPanel;
import java.awt.*;
import java.sql.SQLOutput;

public class GamePanel extends JPanel implements Runnable {

    //Configuración de pantalla
    final int originalTileSize=16; //Tamaño de los sprites 16x16
    final int scale=3; //Escalando x3 los sprites

    final int tileSize = originalTileSize * scale; // acá le doy al tamaño de tiles la escala 48x48px
    final int maxScreenCol = 16; //van a haber 16 tiles de pantalla horizontal
    final int maxScreenRow = 12; //y 12 de alto
    final int screenWidth = tileSize * maxScreenCol; //configuramos tanto alto de pantalla como 768px
    final int screenHeight = tileSize * maxScreenRow; // largo 576px

    //FPS
    int FPS = 60;
    KeyHandler keyH = new KeyHandler();
    Thread gameThread; //generamos un "hilo" basicamente tiempo para que el juego corra sin esperar un input

    //seteo la posicion por defecto del jugador
    int playerX = 100; //en java la esquina superior izquierda es X:0 Y:0 y los valores incrementan hacia la derecha y abajo
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //se explica solo
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); //Doble buffer para mejorar rendimiento
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this); //instancio el "hilo" señalando this como la clase general GamePanel
        gameThread.start();//comienza
    }
/*
    @Override
    public void run() {
        while(gameThread != null){
            double drawInterval = 1000000000/FPS; // 0.01666 secs
            double nextDrawTime = System.nanoTime() + drawInterval;
            //System.out.println("El juego está corriendo!!!");
            long currentTime = System.nanoTime();
            //System.out.println("current time: "+currentTime);;
            // información sobre posición de personaje
            update(); //llama update duh

            // dibujar en la pantalla con la info
            repaint(); //llama paintcomponent

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }*/

    //Otro método de runear
    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long last
    }



    public void update(){
        if(keyH.upPressed == true){
            playerY -= playerSpeed;
        }
        else if (keyH.downPressed == true) {
            playerY+= playerSpeed;
        }
        else if (keyH.leftPressed == true) {
            playerX -= playerSpeed;
        }
        else if (keyH.rightPressed == true) {
            playerX += playerSpeed;
        }
    }
    public void paintComponent(Graphics g){ //graphics es una clase que permite dibujar en pantalla
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRect(playerX,playerY,tileSize,tileSize);
        g2.dispose();

    }
}
