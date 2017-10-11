package renderer.infrastructure.pipeline;

import java.io.File;
import java.util.ArrayList;

import renderer.scene.actors.Model;

public class ContentManager {
	public static final int ERROR_NOT_DIRECTORY=1;
	public ArrayList<Model> models;
	
	/**
	 * Reads all the resources from a directory and stores them to memory.
	 * @param directory
	 * @return 0 if the directory is successfully parsed, otherwise an error code is returned.
	 */
	public int parseResourcesFromDirectory(File directory) {
		if(!directory.isDirectory()) {
			return ERROR_NOT_DIRECTORY;
		}
		return 0;
	}
	private Model loadModelFromObj(File objFile) {
	
		return new Model();
	}
	
}
