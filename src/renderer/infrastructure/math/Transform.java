package renderer.infrastructure.math;

/**
 * Represents a 4x4 column-major transformation matrix. This gives the User the
 * ability to transform things such as the <code>Camera</code> and any
 * <code>Actors</code> in their <code>Scene<code>(s).
 * 
 * @author Don Isaac
 * @see renderer.scene.Camera
 * @see renderer.scene.Scene
 * @see renderer.scene.actors.Actor
 */
public class Transform {
	private double[] matrix;
	/**
	 * <b>**NOTE** DO NOT USE THE CONSTRUCTOR UNLESS YOU KNOW EXACTLY WHAT YOU ARE DOING! USE THE FACTORY METHODS INSTEAD!</B>
	 * <P>Creates a new transformation matrix.
	 * @param matrix the values to use for the matrix
	 */
	public Transform(double[] matrix) {
		this.matrix = matrix;
	}
	// -------------------
	// ~~Factory methods~~
	// -------------------
	public static Transform getIdentityInstance() {
		double mat[] = new double[16];
		for (int i = 0; i < mat.length; i++) {
			if (i % 5 != 0)
				mat[i] = 0.0;
			else
				mat[i] = 1.0;
		}
		return new Transform(mat);
	}
	
	public static Transform getTranslationInstance(Vector3 v) {
		return getTranslationInstance(v.x,v.y,v.z);
	}
	
	public static Transform getTranslationInstance(double x, double y, double z) {
		
	}
}
