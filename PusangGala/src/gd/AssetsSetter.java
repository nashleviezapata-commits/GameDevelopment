package gd;

import object.OBJ_Door;
import object.OBJ_Fish;
import object.OBJ_Key;

public class AssetsSetter {
	
	GamePanel gp;
	
	public AssetsSetter(GamePanel gp) {
		this.gp = gp;
	}
	
	public void setObject() {
		gp.obj[0] = new OBJ_Key();
		gp.obj[0].worldx = 36 * gp.tileSize;
		gp.obj[0].worldy = 3 * gp.tileSize;
		
		gp.obj[1] = new OBJ_Key();
		gp.obj[1].worldx = 22 * gp.tileSize;
		gp.obj[1].worldy = 11 * gp.tileSize;
		
		gp.obj[2] = new OBJ_Key();
		gp.obj[2].worldx = 40 * gp.tileSize;
		gp.obj[2].worldy = 14 * gp.tileSize;
		
		gp.obj[8] = new OBJ_Key();
		gp.obj[8].worldx = 48 * gp.tileSize;
		gp.obj[8].worldy = 4 * gp.tileSize;
		
		//top left
		gp.obj[3] = new OBJ_Door();
		gp.obj[3].worldx = 32 * gp.tileSize;
		gp.obj[3].worldy = 10 * gp.tileSize;
		
		//bottom left
		gp.obj[4] = new OBJ_Door();
		gp.obj[4].worldx = 24 * gp.tileSize;
		gp.obj[4].worldy = 23 * gp.tileSize;
		
		//bottom middle before passageway
		gp.obj[5] = new OBJ_Door();
		gp.obj[5].worldx = 33 * gp.tileSize;
		gp.obj[5].worldy = 31 * gp.tileSize;
		
		//bottom middle room before passageway
		gp.obj[6] = new OBJ_Door();
		gp.obj[6].worldx = 47* gp.tileSize;
		gp.obj[6].worldy = 10 * gp.tileSize;
		
		gp.obj[7] = new OBJ_Fish();
		gp.obj[7].worldx = 45 * gp.tileSize;
		gp.obj[7].worldy = 28 * gp.tileSize;
		
		
		

		
	}
}
