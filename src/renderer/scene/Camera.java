package renderer.scene;

import static renderer.Config.LOG;

import java.awt.image.BufferedImage;
import java.util.logging.Level;

import renderer.infrastructure.math.Transform;
import renderer.infrastructure.math.Vector3;
import renderer.scene.animation.Animateable;

/**
 * Represents a Camera that can be put into a Scene. This class is responsible
 * for taking pictures in the Scene of your choosing. It should be noted that,
 * although each Scene stores a reference to a list of Cameras, Cameras are not
 * unique to a single Scene, allowing you to re-use Cameras for multiple scenes.
 * <p>
 * The Camera class is in charge of both the raytracing and shading portion of
 * this program. This class is basically the meat and potatoes of this whole
 * project.
 * </p>
 * 
 * @author Don Isaac
 *
 */
public class Camera implements Animateable{

	private boolean canEditData;
	private ImageData data;
	private String name;

	public Camera(ImageData data, String name) {
		this.canEditData = true;
		this.data = data.clone();
		
		this.name = name;
	}
	/**
	 * Takes a picture of a Scene.
	 * 
	 * @param s the Scene to take a picture of
	 * 
	 * @return the image taken by the Camera
	 */
	public BufferedImage takePicture(Scene s) {
		//prevent the ImageData from being altered during rendering
		this.canEditData = false;
		
		this.canEditData = true;
		return new BufferedImage(data.width, data.height, data.imageType);
	}
	/**
	 * Gets a read-only copy of this Camera's ImageData.
	 * @return the Camera's ImageData
	 */
	public ImageData getImageData() {
		return data.clone();
	}
	/**
	 * Sets the ImageData used by this class.
	 * @param data the ImageData to set to
	 * @throws IllegalStateException if this method is called while rendering is in progress
	 */
	public void setImageData(ImageData data) {
		if(canEditData)
			this.data = data.clone();
		else
			LOG.log(Level.WARNING, "Cannot edit the Camera's ImageData while rendering is in process", new IllegalStateException());
	}
	@Override
	public void translate(Vector3 v) {
		
	}
	@Override
	public void translate(double x, double y, double z) {
		
	}
	@Override
	public void rotX(double theta, boolean aroundOrigin) {
		
	}
	@Override
	public void rotY(double theta, boolean aroundOrigin) {
		
	}
	@Override
	public void rotZ(double theta, boolean aroundOrigin) {
		
	}
	@Override
	public void applyTransformation(Transform m) {
		
	}
	@Override
	public String getName() {
		return name;
	}
}
