package renderer.infrastructure.pipeline;

import static renderer.Config.LOG;

import java.io.File;
import java.util.HashMap;
import java.util.logging.Level;

import renderer.scene.Animation;
import renderer.scene.Camera;
import renderer.scene.Scene;
import renderer.scene.actors.Light;
import renderer.scene.actors.Material;
import renderer.scene.actors.Model;

public class ContentManager {
	public static final int ERROR_NOT_DIRECTORY = 1;
	public static final int ERROR_DIRECTORY_EMPTY = 2;

	public HashMap<String, Scene> scenes;
	public HashMap<String, Model> models;
	public HashMap<String, Material> materials;
	public HashMap<String, File> textures;
	public HashMap<String, Light> lights;
	public HashMap<String, Animation> animations;
	public HashMap<String, Camera> cameras;

	public ContentManager() {
		scenes = new HashMap<String, Scene>();
		models = new HashMap<String, Model>();
		materials = new HashMap<String, Material>();
		textures = new HashMap<String, File>();
		lights = new HashMap<String, Light>();
		animations = new HashMap<String, Animation>();
		cameras = new HashMap<String, Camera>();

	}

	/**
	 * Reads all the resources from a directory and stores them to memory.
	 * 
	 * @param directory
	 * @return 0 if the directory is successfully parsed, otherwise an error code is
	 *         returned.
	 */
	public int parseResourcesFromDirectory(File directory) {
		LOG.info("Starting to parse directory " + directory.getAbsolutePath());
		if (!directory.isDirectory()) {
			LOG.log(Level.WARNING, "This file must be a directory. Unable to parse", new IllegalArgumentException());
			return ERROR_NOT_DIRECTORY;
		}

		File[] filesInDirectory = directory.listFiles();

		if (filesInDirectory.length == 0) {
			LOG.log(Level.WARNING, "The directory " + directory.getAbsolutePath() + " is empty!");
			return ERROR_NOT_DIRECTORY;
		}

		for (File f : filesInDirectory) {
			// get the file extension
			if (f.isDirectory()) {
				parseResourcesFromDirectory(f);
			} else {
				String ext = f.getName().substring(f.getName().lastIndexOf(".") + 1).toLowerCase();

				if (ext.equals("png") || ext.equals("jpg") || ext.equals("jpeg") || ext.equals("tga")) {
					parseTexture(f);
				} else if (ext.equals("obj")) {
					parseModel(f);
				} else if (ext.equals("mtl")) {
					parseMaterial(f);
				} else if (ext.equals("anim")) {
					parseAnimation(f);
				} else if (ext.equals("scene")) {
					parseScene(f);
				}
			}
		}
		return 0;
	}

	private void parseTexture(File tex) {
		// TODO parse texture
	}

	private void parseModel(File model) {
		// TODO parse model
	}

	private void parseMaterial(File mtl) {
		// TODO parse material
	}

	private void parseAnimation(File anim) {
		// TODO parse animation
	}

	private void parseScene(File scene) {
		// TODO parse scene
	}

}
