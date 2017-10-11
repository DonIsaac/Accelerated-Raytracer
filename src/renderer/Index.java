package renderer;

import static renderer.Config.PATH_LOGGER;
import static renderer.Config.handler;
import static renderer.Config.LOG;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Entry point for the Raytracer.
 * <p>What this class does:</p>
 * <ol>
 * <li>Sets up the logger</li>
 * <li>Sets up the location of RAYTRACER_HOME</li>
 * <li>Sets the status for the DEBUGGER variable</li>
 * </ol>
 * <p>All config data is passed as an argument through main().
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
		} else
			logFile.createNewFile();

		handler = new FileHandler(PATH_LOGGER);
		// TODO allow the user to chose the FileHandler they want
		LOG.addHandler(handler);

		// Set up RAYTRACER_HOME
		switch (args.length) {
		case 0:// default setup
			Config.RAYTRACER_HOME = "D:\\Personal\\Raytrace Files\\";
			// Defaults to my personal computer's Raytracing directory, because I made this
			// thing and I can.
			break;
			
		case 1:// setup if User passes a path for RAYTRACER_HOME
			File f = new File(args[0]);
			if (!f.exists())
				f.createNewFile();
			if (!f.isDirectory())
				LOG.log(Level.SEVERE, "The path to RAYTRACER_HOME must be a directory", new IllegalArgumentException());
			Config.RAYTRACER_HOME = args[0];
			// The first argument is the path for RAYTRACER_HOME.
			// TODO maybe add more arguments, or load from a config file?
			break;
			
		case 2:// setup if User passes path for RAYTRACER_HOME and DEBUG status.
			File f1 = new File(args[0]);// for some reason I cannot use f. ???
			if (!f1.exists())
				f1.createNewFile();
			if (!f1.isDirectory())
				LOG.log(Level.SEVERE, "The path to RAYTRACER_HOME must be a directory", new IllegalArgumentException());
			Config.RAYTRACER_HOME = args[0];

			Config.DEBUG = Boolean.getBoolean(args[1]);
		}
		LOG.info("Config file set up. Starting the Engine.");
		//With the Config file set up, we are finally ready to start the Engine!
		new Engine();
	}

}
