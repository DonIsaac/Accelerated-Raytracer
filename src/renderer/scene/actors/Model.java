package renderer.scene.actors;

import java.util.ArrayList;
import java.util.HashMap;

import renderer.infrastructure.math.Vector3;

public class Model {
	public String fileName;
	
	public ArrayList<Vector3> vertices;
	public ArrayList<Vector3> normals;
	public ArrayList<TextureCoordinate> texCoords;
	public ArrayList<Face> faces;
	
	public HashMap<Integer, ArrayList<Face>>smoothingGroups;
	public HashMap<String, Material> materialLib;
	public HashMap<String, Material> matLib;

}
