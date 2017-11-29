package renderer;

import static renderer.Config.*;
import static renderer.Config.handler;
import static renderer.Config.LOG;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Entry point for the Raytracer.
 * <p>
 * What this class does:
 * </p>
 * <ol>
 * <li>Sets up the logger</li>
 * <li>Sets up the location of RAYTRACER_HOME</li>
 * <li>Sets the status for the DEBUGGER variable</li>
 * </ol>
 * <p>
 * All config data is passed as an argument through main().
 * 
 * @author Don Isaac
 *
 */
public class Index {

	public static void main(String[] args) throws IOException {
		// Set up the logger
		LOG = Logger.getLogger(Index.class.getName());
		File logFile = new File(PATH_LOGGER);

		// If the log file exists, remove the previous log. Otherwise, create a new log
		// file.
		if (logFile.exists()) {
			// TODO does the file overwrite work?
			PrintWriter pw = new PrintWriter(new FileWriter(logFile, false), false);
			pw.flush();
			pw.close();
		} else {

			// logFile.createNewFile();
			
			//TODO Files aren't createdd yet, ut I need to log file creation. What do?
		}

		// handler = new FileHandler(PATH_LOGGER);
		// TODO allow the user to chose the FileHandler they want
		LOG.addHandler(new ConsoleHandler());

		// TODO maybe add more arguments, or load from a config file?
		switch (args.length) {
		case 0:// default setup
				// setupFiletree("D:\\Personal\\Raytrace Files\\");
			setupFiletree("/Users/donisaac/Documents/Raytracer_Files/");
			// Defaults to my personal computer's Raytracing directory, because I made this
			// thing and I can.
			break;

		case 1:// setup if User passes a path for RAYTRACER_HOME
			setupFiletree(args[0]);
			// The first argument is the path for RAYTRACER_HOME.
			break;

		default:// setup if User passes path for RAYTRACER_HOME and DEBUG status.
			setupFiletree(args[0]);
			DEBUG = Boolean.getBoolean(args[1]);
			break;
		}
		LOG.info("Config file set up. Starting the Engine.");
		// With the Config file set up, we are finally ready to start the Engine!
		// new Engine();
	}

	/**
	 * Pretty self-explanitory.
	 * 
	 * @param raytracerHome
	 *            path to RAYTRACE_HOME
	 * @throws IOException
	 *             - If an I/O error occurred
	 */
	private static void setupFiletree(String raytracerHome) throws IOException {
		//TODO: remove directory creation; this is now handled by the installation wizard.
		//TODO: method for getting the path of the program is String dir = new File(".").getCanonicalPath();
		File f = new File(raytracerHome);
		LOG.info(Boolean.toString(f.exists()) + " RM: " + raytracerHome);
		if (!f.exists()) {
			f.mkdir();
			LOG.info("Created new home directory at " + raytracerHome);
		}
		if (!f.isDirectory()) {
			LOG.log(Level.SEVERE, "The path to RAYTRACER_HOME must be a directory", new IllegalArgumentException());
			System.exit(1);
		}
		RAYTRACER_HOME = raytracerHome;
		initPaths();
		if (new File(PATH_PICTURE_SAVE).mkdir())
			LOG.info("PICTURE SAVE PATH: " + PATH_PICTURE_SAVE + " has been created");
		if (new File(PATH_MOVIES_SAVE).mkdir())
			LOG.info(PATH_MOVIES_SAVE + " has been created");
		if (new File(PATH_RESOURCES).mkdir())
			LOG.info(PATH_RESOURCES + " has been created");
		if (new File(PATH_RESOURCES_SCENES).mkdir())
			LOG.info(PATH_RESOURCES_SCENES + " has been created");
		if (new File(PATH_RESOURCES_MODELS).mkdir())
			LOG.info(PATH_RESOURCES_MODELS + " has been created");
		if (new File(PATH_RESOURCES_MATERIALS).mkdir())
			LOG.info(PATH_RESOURCES_MATERIALS + " has been created");
		if (new File(PATH_RESOURCES_TEXTURES).mkdir())
			LOG.info(PATH_RESOURCES_TEXTURES + " has been created");
		if (new File(PATH_RESOURCES_ANIMATIONS).mkdir())
			LOG.info(PATH_RESOURCES_ANIMATIONS + " has been created");
		if (new File(PATH_LOGGER).mkdir())
			LOG.info(PATH_LOGGER + " has been created");

	}

}
