package renderer.infrastructure.math;

/**
 * Represents a 4x4 column-major transformation matrix. This gives the User the
 * ability to transform things such as the <code>Camera</code> and any
 * <code>Actors</code> in their <code>Scene</code>(s).
 * <p>
 * Transformation matrices apply linear transformations to 3D objects and points.When a <code>Vector3</code>
 * is multiplied with a <code>Transform</code> matrix, that <code>Vector3</code>
 * has the linear transformation specified by the matrix applied to it.
 * </p>
 * 
 * <pre>
 * Vector3 v = new Vector3(1.0, 1.0, 1.0);
 * Transform m = Transform.getTranslationInstance(1.0, 2.0, 3.0);
 * Vector3 vPrime = m.transform(v);
 * *vPrime will be equal to <2.0, 3.0, 4.0>
 * </pre>
 * <p>
 * You can have one <code>Transform</code> matrix apply multiple transformations
 * at the same time. All you need to do is call one of the modifier methods,
 * such as <code>rotX(theta)</code>. By the same principle, you can also combine
 * two <code>Transform</code> matrices together. Be sure to remember that the
 * order in which you multiply the two matrices matters, as matrix
 * multiplication is <b>not</b> communicative.
 * </p>
 * 
 * @author Don Isaac
 * @see renderer.scene.Camera
 * @see renderer.scene.Scene
 * @see renderer.scene.actors.Actor
 * @see renderer.infrastructure.math.Vector3
 */
public class Transform {
	protected double[] matrix;

	/**
	 * <b>**NOTE** DO NOT USE THE CONSTRUCTOR UNLESS YOU KNOW EXACTLY WHAT YOU ARE
	 * DOING! USE THE FACTORY METHODS INSTEAD!</B>
	 * <P>
	 * Creates a new transformation matrix.
	 * 
	 * @param matrix
	 *            the values to use for the matrix
	 */
	public Transform(double[] matrix) {
		this.matrix = matrix;
	}

	// -------------------
	// ~~Factory methods~~
	// -------------------
	/**
	 * Creates a new identity <code>Transform</code> instance.
	 * <p>
	 * The identity matrix looks like:
	 * </p>
	 * 
	 * <pre>
	 * |1 0 0 0|
	 * |0 1 0 0|
	 * |0 0 1 0|
	 * |0 0 0 1|
	 * </pre>
	 * 
	 * @return a identity <code>Transform</code> matrix instance
	 */
	public static Transform getIdentityInstance() {
		return new Transform(blankMat());
	}

	/**
	 * Creates a new <code>Transform</code> instance that has been modified to apply
	 * a translation transformation.
	 * <p>
	 * The resulting matrix looks like:
	 * </p>
	 * 
	 * <pre>
	 * |1 0 0 x|
	 * |0 1 0 y|
	 * |0 0 1 z|
	 * |0 0 0 1|
	 * </pre>
	 * 
	 * @param v
	 *            the <code>Vector3</code> that defines how far to translate the
	 *            matrix in each direction
	 * @return a translated <code>Transform</code> instance
	 */
	public static Transform getTranslationInstance(Vector3 v) {
		return getTranslationInstance(v.x, v.y, v.z);
	}

	/**
	 * Creates a new <code>Transform</code> instance that has been modified to apply
	 * a translation transformation.
	 * <p>
	 * The resulting matrix looks like:
	 * </p>
	 * 
	 * <pre>
	 * |1 0 0 x|
	 * |0 1 0 y|
	 * |0 0 1 z|
	 * |0 0 0 1|
	 * </pre>
	 * 
	 * @param x
	 *            how far to translate along the X axis
	 * @param y
	 *            how far to translate along the Y axis
	 * @param z
	 *            how far to translate along the Z axis
	 * @return a <code>Transform</code> matrix that applies a translation
	 */
	public static Transform getTranslationInstance(double x, double y, double z) {
		double mat[] = blankMat();
		mat[12] = x;
		mat[13] = y;
		mat[14] = z;
		return new Transform(mat);

	}

	/**
	 * Creates a new <code>Transform</code> instance that has been modified to apply
	 * a rotation transformation around the X axis.
	 * <p>
	 * The resulting matrix looks like:
	 * </p>
	 * 
	 * <pre>
	 * |1  0  0  0|
	 * |0  c -s  0|
	 * |0  s  c  0|
	 * |0  0  0  1|
	 * </pre>
	 * 
	 * @param theta
	 *            the angle of the rotation in radians
	 * @return a <code>Transform</code> matrix that applies a rotation around the X
	 *         axis
	 */
	public static Transform getRotationXInstance(double theta) {
		double mat[] = blankMat();
		double s = Math.sin(theta);
		double c = Math.cos(theta);
		mat[5] = c;
		mat[6] = s;
		mat[9] = -s;
		mat[10] = c;

		return new Transform(mat);
	}

	/**
	 * Creates a new <code>Transform</code> instance that has been modified to apply
	 * a rotation transformation around the Y axis.
	 * <p>
	 * The resulting matrix looks like:
	 * </p>
	 * 
	 * <pre>
	 * | c  0  s  0|
	 * | 0  1  0  0|
	 * |-s  s  c  0|
	 * | 0  0  0  1|
	 * </pre>
	 * 
	 * @param theta
	 *            the angle of the rotation in radians
	 * @return a <code>Transform</code> matrix that applies a rotation around the Y
	 *         axis
	 */
	public static Transform getRotationYInstance(double theta) {
		double mat[] = blankMat();
		double s = Math.sin(theta);
		double c = Math.cos(theta);
		mat[0] = c;
		mat[2] = -s;
		mat[8] = s;
		mat[10] = c;

		return new Transform(mat);
	}

	/**
	 * Creates a new <code>Transform</code> instance that has been modified to apply
	 * a rotation transformation around the Z axis.
	 * <p>
	 * The resulting matrix looks like:
	 * </p>
	 * 
	 * <pre>
	 * |c -s  s  0|
	 * |s  c  0  0|
	 * |0  s  1  0|
	 * |0  0  0  1|
	 * </pre>
	 * 
	 * @param theta
	 *            the angle of the rotation in radians
	 * @return a <code>Transform</code> matrix that applies a rotation around the Z
	 *         axis
	 */
	public static Transform getRotationZInstance(double theta) {
		double mat[] = blankMat();
		double s = Math.sin(theta);
		double c = Math.cos(theta);
		mat[0] = c;
		mat[1] = s;
		mat[4] = -s;
		mat[5] = c;

		return new Transform(mat);
	}
	/**
	 * Applies a translation transformation to the <code>Transform</code> matrix.
	 * @param v how much to translate the matrix in each direction
	 * 
	 * @see renderer.infrastructure.math.Vector3
	 */
	public void translate(Vector3 v) {
		translate(v.x, v.y, v.z);
	}
	/**
	 * Applies a translation transformation to the <code>Transform</code> matrix.
	 * @param x how much to translate along the X-axis
	 * @param y how much to translate along the Y-axis
	 * @param z how much to translate along the Z-axis
	 */
	public void translate(double x, double y, double z) {
		matrix[12] += x;
		matrix[13] += y;
		matrix[14] += z;
	}
	
	public void rotX(double theta, boolean aroundOrigin) {
		
	}
	
	public void combine(Transform M) {
		double mat[] = new double[16];
		double[] m1 = matrix;
		double[] m2 = M.matrix;
		/*
		 *| 0  4  8 12|
		 *| 1  5  9 13|
		 *| 2  6 10 14|
		 *| 3  7 11 15|
		 */
		for(int i = 0, m = 0, n = 0; i < 16; i++) {
			n = i % 4;
			m = n == 0 && i > 1? m++:0;
			mat[i] = m1[n]*m2[4*m] + m1[n+4]*m2[4*m+1] + m1[n+8]*m2[4*m+2] + m1[n+12]*m2[4*m+3];
		}
		this.matrix = mat;
	}
	/**
	 * Returns a copy of this <code>Transform</code> matrix.
	 * @return a copy of this matrix
	 */
	public Transform cpy() {
		return new Transform(matrix);
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder("");
		for(int i = 0; i < 4; i++) {
			s.append("|"+matrix[i]+ " "+matrix[i+4]+ " "+matrix[i+8]+ " "+matrix[i+12]+ "|\n");
		}
		return s.toString();
	}
	private static double[] blankMat() {
		double mat[] = new double[16];
		for (int i = 0; i < mat.length; i++) {
			if (i % 5 != 0)
				mat[i] = 0.0;
			else
				mat[i] = 1.0;
		}
		return mat;
	}
}
