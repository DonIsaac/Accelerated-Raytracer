package renderer.scene;

import java.awt.image.BufferedImage;

/**
 * A struct-like class that stores data needed by the Camera to create an image, such as the width/height of the image.
 * @see Camera
 * @author Don Isaac
 *
 */
public class ImageData {
	public int width, height, imageType;
	public double focalLength;
	public boolean antiAliasing;

	/**
	 * Default constructor. Creates a standard ImageData struct with non-custom settings.
	 */
	public ImageData() {
		this.width = 1920;
		this.height = 1080;
		this.focalLength = 1.7;
		this.antiAliasing = true;
		this.imageType = BufferedImage.TYPE_INT_RGB;
	}
	/**
	 * Creates a custom ImageData struct.
	 * @param width the image's width
	 * @param height the image's height
	 * @param focalLength the focal length the Camera's focal length should be
	 * @param antiAliasing should the Camera use anti-aliasing or not
	 * 
	 * @see Camera
	 */
	public ImageData(int width, int height, double focalLength, int imageType, boolean antiAliasing) {
		this.width = width;
		this.height = height;
		this.focalLength = focalLength;
		this.antiAliasing = antiAliasing;
		this.imageType = imageType;
	}
	
	@Override
	public ImageData clone() {
		return new ImageData(width, height, focalLength, imageType, antiAliasing);
	}
}
