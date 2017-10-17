package renderer.infrastructure.math;

/**
 * Represents an object that can be transformed in 3D space. This interface is
 * meant to be paired with the <code>Transform</code> object.
 * 
 * @author Don Isaac
 *
 */
public interface Transformable {
	/**
	 * Translates this object in 3D space.
	 * 
	 * @param v
	 *            the <code>Vector3</code> to translate along.
	 */
	public void translate(Vector3 v);

	/**
	 * Translates this object in 3D space.
	 * 
	 * @param x
	 *            how far to shift along the X-axis
	 * @param y
	 *            how far to shift along the Y-axis
	 * @param z
	 *            how far to shift along the Z-axis
	 */
	public void translate(double x, double y, double z);

	/**
	 * Rotates this object around the X-axis. Note that this transformation occurs
	 * around the global X-axis, not the local X-axis. If you want to have this
	 * object be rotated around the local axis, change <code>aroundOrigin</code> to
	 * <b>false</b>.
	 * 
	 * @param theta
	 *            the angle to rotate this object in radians
	 * @param aroundOrigin
	 *            <b>true</b> if you want the object to rotate around the global
	 *            axis, <b>false</b> otherwise
	 */
	public void rotX(double theta, boolean aroundOrigin);
	/**
	 * Rotates this object around the Y-axis. Note that this transformation occurs
	 * around the global Y-axis, not the local Y-axis. If you want to have this
	 * object be rotated around the local axis, change <code>aroundOrigin</code> to
	 * <b>false</b>.
	 * 
	 * @param theta
	 *            the angle to rotate this object in radians
	 * @param aroundOrigin
	 *            <b>true</b> if you want the object to rotate around the global
	 *            axis, <b>false</b> otherwise
	 */
	public void rotY(double theta, boolean aroundOrigin);
	/**
	 * Rotates this object around the Z-axis. Note that this transformation occurs
	 * around the global Z-axis, not the local Z-axis. If you want to have this
	 * object be rotated around the local axis, change <code>aroundOrigin</code> to
	 * <b>false</b>.
	 * 
	 * @param theta
	 *            the angle to rotate this object in radians
	 * @param aroundOrigin
	 *            <b>true</b> if you want the object to rotate around the global
	 *            axis, <b>false</b> otherwise
	 */
	public void rotZ(double theta, boolean aroundOrigin);

	/**
	 * Applies a 3D transformation to this object. This transformation could be anything.
	 * @param m the <code>Transform</code> matrix that stores the transformation
	 */
	public void applyTransformation(Transform m);
}
