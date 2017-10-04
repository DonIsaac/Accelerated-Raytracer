package renderer.scene;

import java.awt.image.BufferedImage;

/**
 * A struct-like class for storing data the Camera needs to create an image, such as the width/height of the image.
 * @author Don Isaac
 *
 */
public class ImageData {
	private int width, height, imageType;
	private double focalLength;
	private boolean antiAliasing;

	/**
	 * Creates a standard ImageData struct with non-custom settings.
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

	public int width() {
		return this.width;
	}

	public int height() {
		return this.height;
	}
	
	public double aspectRatio() {
		return (double)width/(double)height;
	}
	
	public double focalLength() {
		return this.focalLength;
	}
	
	public boolean antiAliasting() {
		return this.antiAliasing;
	}
	
	public int imageType() {
		return imageType();
	}
}
