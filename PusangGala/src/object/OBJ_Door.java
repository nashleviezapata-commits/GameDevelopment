package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Door extends SuperObject {
	public OBJ_Door() {
		
		name = "Door";
		try {
			Image = ImageIO.read(getClass().getResourceAsStream("/objects/doorobj.png"));
		
	}catch(IOException e) {
		e.printStackTrace();
	}
		collision = true;
}
}
