package renderer.world;

import java.awt.image.BufferedImage;

public class Camera {

	private ImageData data;
	
	public BufferedImage takePicture() {
		
		return new BufferedImage(data.width(), data.height(), data.imageType());
	}
}
