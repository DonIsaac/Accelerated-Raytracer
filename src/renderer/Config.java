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
	public static String PATH_PICTURE_SAVE = RAYTRACER_HOME + "pictures/";
	public static String PATH_MOVIES_SAVE = RAYTRACER_HOME + "movies/";
	public static String PATH_RESOURCES = RAYTRACER_HOME + "res/";
	public static String PATH_RESOURCES_SCENES = PATH_RESOURCES+"scenes/";
	public static String PATH_RESOURCES_MODELS = PATH_RESOURCES+"models/";
	public static String PATH_RESOURCES_MATERIALS = PATH_RESOURCES+"materials/";
	public static String PATH_RESOURCES_TEXTURES = PATH_RESOURCES+"tex/";
	public static String PATH_RESOURCES_ANIMATIONS = PATH_RESOURCES+"anim/";
	public static String PATH_LOGGER = RAYTRACER_HOME + "logs/log_file.log";

	public static void initPaths() {
		PATH_PICTURE_SAVE = RAYTRACER_HOME + "pictures/";
		PATH_MOVIES_SAVE = RAYTRACER_HOME + "movies/";
		PATH_RESOURCES = RAYTRACER_HOME + "res/";
		PATH_RESOURCES_SCENES = PATH_RESOURCES+"scenes/";
		PATH_RESOURCES_MODELS = PATH_RESOURCES+"models/";
		PATH_RESOURCES_MATERIALS = PATH_RESOURCES+"materials/";
		PATH_RESOURCES_TEXTURES = PATH_RESOURCES+"tex/";
		PATH_RESOURCES_ANIMATIONS = PATH_RESOURCES+"anim/";
		PATH_LOGGER = RAYTRACER_HOME + "logs/log_file.log";
	}
	//Logging utilities TODO should this go in Config or Util?
	/**The logger used by the Raytracer. All output goes here.*/
	public static Logger LOG;
	/**The handler used by the logger.*/
	public static StreamHandler handler;
}
