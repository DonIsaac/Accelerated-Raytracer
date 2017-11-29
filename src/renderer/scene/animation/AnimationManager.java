package renderer.scene.animation;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Handler class to animate any entity that is animateable. This class should be
 * paired with a Scene.
 * 
 * @see renderer.scene.Scene
 * 
 * @author Don Isaac
 *
 */
public class AnimationManager {
	public MovieData data;

	private HashMap<String, Animateable> actors;
	private ArrayList<Animation> animations;
	
	private double elapsedTime;

	/**
	 * Default constructor.
	 */
	public AnimationManager() {
		this(new MovieData(), new ArrayList<Animateable>(), new ArrayList<Animation>());
	}

	/**
	 * Creates a new AnimationManager with pre-defined parameters.
	 * 
	 * @param data
	 *            the MovieData to be used
	 * @param actors
	 *            the Actors to manage
	 * @param animations
	 *            the animations that can be applied to the Actors
	 * 
	 * @see renderer.scene.actors.Actor
	 * @see Animation
	 */
	public AnimationManager(MovieData data, ArrayList<Animateable> actors, ArrayList<Animation> animations) {
		this.data = data;

		for (Animateable a : actors)
			this.actors.put(a.getName(), a);

		this.animations = animations;
	}
	/**
	 * Applies all Animations to their respective entities, assuming the animation happens at this specific time.
	 */
	public void update() {
	
		elapsedTime += data.frameRate;
	}
}
