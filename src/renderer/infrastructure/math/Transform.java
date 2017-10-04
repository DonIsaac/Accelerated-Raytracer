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
	/**
	 * Creates a new identity <code>Transform</code> instance.
	 * <p>The identity matrix looks like:</p>
	 * <pre>
	 * |1 0 0 0|
	 * |0 1 0 0|
	 * |0 0 1 0|
	 * |0 0 0 1|
	 * </pre>
	 * @return a identity <code>Transform</code> matrix instance
	 */
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
	/**
	 * Creates a new <code>Transform</code> instance that has been modified to apply a translation transformation.
	 *  <p>The resulting matrix looks like:</p>
	 * <pre>
	 * |1 0 0 x|
	 * |0 1 0 y|
	 * |0 0 1 z|
	 * |0 0 0 1|
	 * </pre>
	 * @param v the <code>Vector3</code> that defines how far to translate the matrix in each direction
	 * @return a translated <code>Transform</code> instance
	 */
	public static Transform getTranslationInstance(Vector3 v) {
		return getTranslationInstance(v.x,v.y,v.z);
	}
	/**
	 * Creates a new <code>Transform</code> instance that has been modified to apply a translation transformation.
	 *   <p>The resulting matrix looks like:</p>
	 * <pre>
	 * |1 0 0 x|
	 * |0 1 0 y|
	 * |0 0 1 z|
	 * |0 0 0 1|
	 * </pre>
	 * @param x how far to translate along the X axis
	 * @param y how far to translate along the Y axis
	 * @param z how far to translate along the Z axis
	 * @return a translated <code>Transform</code> instance
	 */
	public static Transform getTranslationInstance(double x, double y, double z) {
		double mat[] = new double[16];
		for (int i = 0; i < mat.length; i++) {
			if (i % 5 != 0)
				mat[i] = 0.0;
			else
				mat[i] = 1.0;
		}
		mat[12] = x;
		mat[13] = y;
		mat[14] = z;
		return new Transform(mat);
		
	}
}
