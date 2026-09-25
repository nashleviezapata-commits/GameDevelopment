package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Fish extends SuperObject{
public OBJ_Fish() {
		
		name = "Fish";
		try {
			Image = ImageIO.read(getClass().getResourceAsStream("/objects/fishitem.png"));
		
	}catch(IOException e) {
		e.printStackTrace();
	}
}
}
