package renderer.scene.animation;

import renderer.infrastructure.math.Transformable;
/**
 * Represents an entity that can be animated.
 * @author Don Isaac
 *
 */
public interface Animateable extends Transformable{

	/**
	 * Gets the name of this entity.
	 * @return the name of this entity.
	 */
	public String getName();
}
