package renderer;

import java.util.logging.Logger;
import java.util.logging.StreamHandler;

/**
 * Stores configuration data for the Raytracer. A good portion of this data is set up in the {@link Index} class.
 * @author Don Isaac
 *
 */
public class Config {
	/** Should the Raytracer be run in debug mode? */
	public static boolean DEBUG  = true;

	/**
	 * Home directory for all of the Raytracer's necessary directories. Edit this to
	 * suit your own computer.
	 */
	public static String RAYTRACER_HOME;// = "D:\\Personal\\Raytrace Files\\";
	// Sub-directories used by the Raytracer. You do not need to edit these.
	public static final String PATH_PICTURE_SAVE = RAYTRACER_HOME + "Pictures\\";
	public static final String PATH_RESOURCES = RAYTRACER_HOME + "Resourecs\\";
	public static final String PATH_LOGGER = RAYTRACER_HOME + "Logs\\log_file.log";

	//Logging utilities TODO should this go in Config or Util?
	/**The logger used by the Raytracer. All output goes here.*/
	public static Logger LOG;
	/**The handler used by the logger.*/
	public static StreamHandler handler;
}
