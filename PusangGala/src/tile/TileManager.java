package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import gd.GamePanel;

public class TileManager {
	
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][];

	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		
		tile = new Tile[100];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/map1.txt");
	}
	
	public void getTileImage() {
		try {
			
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/beigebrick.png"));
			tile[0].collision = true;
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/stairdark.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/spruceplanks.png"));
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/skynocloud.png"));
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/crates.png"));
			tile[4].collision = true;
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
			tile[5].collision = true;
			
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/rose.png"));

			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/stair.png"));
			
			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/darkpassageway.png"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap(String filepath) {
		try {
			InputStream is = getClass().getResourceAsStream("/maps/map1.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
				String line = br.readLine();
				
				while(col < gp.maxWorldCol) {
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
			
		}
		catch(Exception e) {
			 e.printStackTrace();
		}
		}
	
	
	
	
	
	public void draw(Graphics2D g2) {
//		g2.drawImage(tile[1].image, 0, 0, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 48, 0, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 96, 0, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 144, 0, gp.tileSize, gp.tileSize, null);
//		g2.drawImage(tile[1].image, 192, 0, gp.tileSize, gp.tileSize, null);
		int worldcol = 0;
		int worldrow = 0;
//		int x = 0;
//		int y = 0;
		
		
		while(worldcol < gp.maxWorldCol && worldrow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldcol][worldrow];
			
			int worldx = worldcol * gp.tileSize;
			int worldy = worldrow * gp.tileSize;
			int screenx = worldx - gp.player.worldx + gp.player.screenx;
			int screeny = worldy - gp.player.worldy + gp.player.screeny;

			if(worldx + gp.tileSize > gp.player.worldx - gp.player.screenx && 
					worldx - gp.tileSize< gp.player.worldx + gp.player.screenx && 
					worldy + gp.tileSize> gp.player.worldy - gp.player.screeny && 
					worldy - gp.tileSize< gp.player.worldy + gp.player.screeny) {
				g2.drawImage(tile[tileNum].image, screenx, screeny, gp.tileSize, gp.tileSize, null);
			}
			
			worldcol++;
//			x += gp.tileSize;
			
			if (worldcol == gp.maxWorldCol) {
				worldcol = 0;
//				x = 0;
				worldrow++;
//				y += gp.tileSize;
			}
		}
		
		
		
		
		
	}
	
}
