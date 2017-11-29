package renderer.scene.animation;
/**
 * A struct-like class that stores meta data about a movie or a shot (basically anything that is eventually going to be turned into a .mp4).
 * @author Don Isaac
 *
 */
public class MovieData {
	/**
	 * The frame rate of the movie, in Hz (frames per second).
	 */
	public double frameRate;
	/**
	 * Default constructor.
	 */
	public MovieData() {
		//The universally accepted frame rate for films
		//https://en.wikipedia.org/wiki/Frame_rate
		this.frameRate = 24.0;
	}
	/**
	 * Constructs a new MovieData instance.
	 * @param frameRate the frame rate
	 */
	public MovieData(double frameRate) {
		this.frameRate = frameRate;
	}
	
	@Override
	public MovieData clone() {
		return new MovieData(frameRate);
	}
}
