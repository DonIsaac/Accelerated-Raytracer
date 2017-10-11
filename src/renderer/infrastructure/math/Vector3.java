package renderer.infrastructure.math;

import static renderer.Utils.*;

/**
 * Represents a vector in 3D space. This class comes equipped with methods
 * designed for chaining, along with some other desirable vector functions.
 * <p>For example, lets say you wanted to implement the equation:</p>
 * <pre>v = 3a x (b - 2d + c)</pre>
 * <p>You can use method chaining (along with the cpy() method to prevent altering your original vectors) by running the code:
 * <pre>Vector3 v = a.cpy().scl(3.0).cross(b.cpy().sub(d.cpy().scl(2.0).add(c));</pre>
 * @author Don Isaac
 *
 */
public class Vector3 {
	public double x;
	public double y;
	public double z;
	/** Shorthand for the zero vector */
	public static final Vector3 ZERO = new Vector3(0.0, 0.0, 0.0);
	/** Shorthand for the unit vector along the X-axis */
	public static final Vector3 I = new Vector3(1.0, 0.0, 0.0);
	/** Shorthand for the unit vector along the Y-axis */
	public static final Vector3 J = new Vector3(0.0, 1.0, 0.0);
	/** Shorthand for the unit vector along the Z-axis */
	public static final Vector3 K = new Vector3(0.0, 0.0, 1.0);

	/**
	 * Creates a new <code>Vector3</code>.
	 * 
	 * @param x
	 *            the X value
	 * @param y
	 *            the Y value
	 * @param z
	 *            the Z value
	 */
	public Vector3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	/**
	 * Default constructor. Creates a <code>Vector3</code> at <0,0,0>.
	 */
	public Vector3() {
		this.x = 0.0;
		this.y = 0.0;
		this.z = 0.0;
	}

	/**
	 * Copy constructor.
	 * 
	 * @param v
	 *            the <code>Vector3</code> to copy
	 */
	public Vector3(Vector3 v) {
		this.x = v.x;
		this.y = v.y;
		this.z = v.z;
	}

	/**
	 * 
	 * @return the length of this <code>Vector3</code>
	 */
	public double len() {

		return Math.sqrt(x * x + y * y + z * z);
	}

	/**
	 * Normalizes the vector.
	 * 
	 * @return A reference to this <code>Vector3</code> for method chaining.
	 */
	public Vector3 nor() {
		double len = len();
		if (len > 0) {
			this.x /= len;
			this.y /= len;
			this.z /= len;
		} else
			throw new ArithmeticException("You can't normalize <0,0,0>");

		return this;
	}

	/**
	 * Gets the distance from this <code>Vector3</code> to another
	 * <code>Vector3</code>.
	 * 
	 * @param v
	 *            the other <code>Vector3</code>
	 * @return the distance between this vector and v
	 */
	public double dist(Vector3 v) {
		double dx = this.x - v.x;
		double dy = this.y - v.y;
		double dz = this.z - v.z;
		return Math.sqrt(dx * dx + dy + dy + dz * dz);
	}

	/**
	 * Calculates the dot product between two <code>Vector3</code> instances.
	 * <p>
	 * The dot product between two vectors a&#8407; and b&#8407; is defined as
	 * follows:
	 * </p>
	 * 
	 * <pre>
	 * a&#8407;<b>&#183;</b>b&#8407; = a<sub>x</sub>*b<sub>x</sub> + a<sub>y</sub>*b<sub>y</sub> + a<sub>z</sub>*b<sub>z</sub>
	 * </pre>
	 * 
	 * @param v
	 *            the second <code>Vector3</code> to use, the first being the
	 *            referenced <code>Vector3</code>
	 * @return the solution from the dot product.
	 */
	public double dot(Vector3 v) {
		return (x * v.x + y * v.y + z * v.z);
	}

	/**
	 * Calculates the cross product between two <code>Vector3</code> instances.
	 * 
	 * @param v
	 *            the second <code>Vector3</code> to use, the first being the
	 *            referenced <code>Vector3</code>
	 * @return the resulting <code>Vector3</code> from the cross product, which is
	 *         normal to both <code>Vector3s</code>.
	 */
	public Vector3 cross(Vector3 v) {
		double tmpx = y * v.z - z * v.y, tmpy = z * v.x - x * v.z, tmpz = x * v.y - y * v.x;
		return new Vector3(tmpx, tmpy, tmpz);
	}

	/**
	 * Scales this <code>Vector3</code>.
	 * 
	 * @param scalar
	 *            the factor to scale by
	 * @return a reference to this <code>Vector3</code> for method chaining
	 */
	public Vector3 scl(double scalar) {
		x *= scalar;
		y *= scalar;
		z *= scalar;

		return this;
	}

	/**
	 * Adds this <code>Vector3</code> with another <code>Vector3</code>. The
	 * resulting <code>Vector3</code> is stored in the instance in which the method
	 * was called.
	 * 
	 * @param v
	 *            the <code>Vector3</code> to add
	 * @return a reference to this <code>Vector3</code> for method chaining
	 */
	public Vector3 add(Vector3 v) {
		x += v.x;
		y += v.y;
		z += v.z;
		return this;
	}

	/**
	 * Subtracts a given <code>Vector3</code> from this <code>Vector3</code>. The
	 * resulting <code>Vector3</code> is stored in the instance in which the method
	 * was called.
	 * 
	 * @param v
	 *            the <code>Vector3</code> to subtract
	 * @return a reference to this <code>Vector3</code> for method chaining
	 */
	public Vector3 sub(Vector3 v) {
		x -= v.x;
		y -= v.y;
		z -= v.z;
		return this;
	}

	/**
	 * A dot product shorthand in which this <code>Vector3</code> is dotted with
	 * itself. Intended to be a convenience.
	 * 
	 * @return the dot product between this <code>Vector3</code> and itself
	 */
	public double square() {
		return x * x + y * y + z * z;
	}

	/**
	 * Determines this <code>Vector3</code> and another <code>Vector3</code> are
	 * equal.
	 * 
	 * @param v
	 *            the <code>Vector3</code> to check against.
	 * @return <b>true</b> if equal, <b>false</b> otherwise
	 */
	public boolean equals(Vector3 v) {
		return nearlyEquals(x, v.x) && nearlyEquals(y, v.y) && nearlyEquals(z, v.z);
	}

	@Override
	public String toString() {
		return "<" + x + "," + y + "," + z + ">";
	}

	/**
	 * Returns a copy of this <code>Vector3</code>. Extremely helpful for method
	 * chaining.
	 * 
	 * @return a copy of this <code>Vector3</code>
	 */
	public Vector3 cpy() {
		return new Vector3(this);
	}
}
