package renderer.scene.actors;

import java.util.ArrayList;

import renderer.infrastructure.math.Vector3;

public class Model {
	public ArrayList<Vector3> vertices;
	public ArrayList<Vector3> normals;
	public ArrayList<Vector3> texCoords;
	public ArrayList<Face> faces;
}
