package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import gd.GamePanel;
import gd.Keyhandler;

public class Player extends Entity{
	
	GamePanel gp;
	Keyhandler keyH;
	
	public final int screenx;
	public final int screeny;
	int hasKey = 0;
	int hasFish = 0;
	
	public Player(GamePanel gp, Keyhandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		
		screenx = gp.screenWidth/2 - (gp.tileSize/2);
		screeny = gp.screenHeight/2- (gp.tileSize/2);
		
		solidArea = new Rectangle();
		solidArea.x = 12;
		solidArea.y = 20;
		solidAreaDefaultx = solidArea.x;
		solidAreaDefaulty = solidArea.y;
		solidArea.width = 24;
		solidArea.height = 24;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		worldx = gp.tileSize * 23;
		worldy = gp.tileSize * 21;
		speed = 4;
		Direction = "left";
	}
	
	public void getPlayerImage() {
		
		try {
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/catright1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/catright2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/catleft1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/catleft2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/down1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/down2.png"));
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/up1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/up2.png"));
			
		}catch(IOException e) {
			e.printStackTrace();		}
	}
	public void update() {
		
		if(keyH.upPressed == true || keyH.downPressed == true || 
				keyH.leftPressed == true || keyH.rightPressed == true) {
			if (keyH.upPressed == true) {
				Direction = "up";
			}else if (keyH.downPressed == true) {
				Direction = "down";
			}else if (keyH.leftPressed == true) {
				Direction = "left";
			}else if (keyH.rightPressed == true) {
				Direction = "right";
			}
			
			//check tile collision
			collisionOn = false;
			gp.cChecker.checkTile(this);
			
			//check object collision
			int objIndex = gp.cChecker.checkObject(this,true);
			pickUpObject(objIndex);
			
			// if collision = false, player can move
			if (collisionOn == false) {
				
				switch(Direction) {
				case "up": worldy-= speed; break;
				case "down": worldy += speed; break;
				case "left": worldx -= speed; break;
				case "right": worldx += speed; break;	
				}
			}
			
			
			spriteCounter++;
			if(spriteCounter > 20) {
				if(spriteNum == 1) {
					spriteNum = 2;
				} else if (spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}	
		}
	}
	public void pickUpObject(int i) {
		
		if(i != 999) {
			
			String objectName = gp.obj[i].name;
			
			switch(objectName) {
			case "Key":
				hasKey++;
				gp.obj[i] = null;
				System.out.println("Key:"+hasKey);
				break;
			case "Door":
				if(hasKey > 0) {
					gp.obj[i] = null;
					hasKey--;
				}
				System.out.println("Key:"+hasKey);
				break;
			case "Fish":
				hasFish++;
				gp.obj[i] = null;
				System.out.println("Fish:"+hasFish);
				break;
			}

		}
	}
	
	public void draw(Graphics2D g2) {
//		g2.setColor(Color.white);
//		g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		BufferedImage image = null;
		
		switch(Direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			break;
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			break;
		}
		g2.drawImage(image, screenx, screeny,gp.tileSize, gp.tileSize, null);
		
		
	}
	
	
}
