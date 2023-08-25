package entity;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;
    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues() {

        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage() {

        try {
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/SlimeUp1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/SlimeUp2.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/SlimeLeft1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/SlimeLeft2.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/SlimeRight1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/SlimeRight2.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/SlimeDown1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/SlimeDown2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {
        if (keyH.upPressed) {
            direction = "up";
            y -= speed;
        } else if (keyH.downPressed) {
            direction = "down";
            y += speed;
        } else if (keyH.rightPressed) {
            direction = "right";
            x += speed;
        } else if (keyH.leftPressed) {
            direction = "left";
            x -= speed;
        }
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            spriteCounter++;
        }
        if (spriteCounter > 12) {
            if(spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
    }
    public void draw(Graphics2D g2D) {
        g2D.setColor(Color.white);
        g2D.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch(direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
        }
        g2D.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);


    }



}
