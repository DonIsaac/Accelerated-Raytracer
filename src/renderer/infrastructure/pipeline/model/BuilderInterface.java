package renderer.infrastructure.pipeline.model;

import renderer.scene.actors.Model;

/**
 * Used to interface with {@link OBJParser}. This class is not an original work,
 * but is instead a derivative work from a parser written by
 * <a href="https://github.com/seanrowens/oObjLoader">Sean R. Owens</a>.
 * 
 * @author <a href="https://github.com/seanrowens/oObjLoader">Sean R. Owens</a>,
 *         modified by Don Isaac
 *
 */
public interface BuilderInterface {

	public final int NO_SMOOTHING_GROUP = 0;
	public final int EMPTY_VERTEX_VALUE = Integer.MIN_VALUE;
	public final int MTL_KA = 0;
	public final int MTL_KD = 1;
	public final int MTL_KS = 2;
	public final int MTL_TF = 3;
	public final int MTL_MAP_KA = 0;
	public final int MTL_MAP_KD = 1;
	public final int MTL_MAP_KS = 2;
	public final int MTL_MAP_NS = 3;
	public final int MTL_MAP_D = 4;
	public final int MTL_DECAL = 5;
	public final int MTL_DISP = 6;
	public final int MTL_BUMP = 7;
	public final int MTL_REFL_TYPE_UNKNOWN = -1;
	public final int MTL_REFL_TYPE_SPHERE = 0;
	public final int MTL_REFL_TYPE_CUBE_TOP = 1;
	public final int MTL_REFL_TYPE_CUBE_BOTTOM = 2;
	public final int MTL_REFL_TYPE_CUBE_FRONT = 3;
	public final int MTL_REFL_TYPE_CUBE_BACK = 4;
	public final int MTL_REFL_TYPE_CUBE_LEFT = 5;
	public final int MTL_REFL_TYPE_CUBE_RIGHT = 6;

	public void startParsing(String filename);

	public void addVertexGeometric(double x, double y, double z);

	public void addVertexTexture(double u, double v);

	public void addVertexNormal(double x, double y, double z);

	public void addPoints(int values[]);

	public void addLine(int values[]);

	/**
	 * Adds a face to the <code>Model</code> The param for addFace is an array of
	 * vertex indices. This array should have a l*ength that is a multiple of 3.
	 *
	 * For each triplet of values;
	 * 
	 * The first value is an absolute or relative index to a geometric vertex.
	 * (VertexGeometric) The second value is an absolute or relative index to a
	 * vertex texture coordinate. (VertexTexture) The third vertex is an absolute or
	 * relative index to a vertex normal. (VertexNormal)
	 * 
	 * The indices for the texture and normal MAY be empty in which case they will
	 * be set equal to the special value defined in BuilderInterface,
	 * EMPTY_VERTEX_VALUE.
	 * 
	 * Absolute indices are positive values that specify a vertex/texture/normal by
	 * it's absolute position within the OBJ file.
	 * 
	 * Relative indices are negative values that specify a vertex/texture/normal by
	 * it's position relative to the line the index is on, i.e. a line specifying a
	 * face (triangle) may specify an geometry vertex as -5 which means the 5 most
	 * recently seen geometry vertex.
	 * 
	 * @param vertexIndices the indices
	 */
	public void addFace(int vertexIndices[]);

	public void addObjectName(String name);

	public void addMapLib(String[] names);

	public void setCurrentGroupNames(String[] names);

	public void setCurrentSmoothingGroup(int groupNumber);

	public void setCurrentUseMap(String name);

	public void setCurrentUseMaterial(String name);

	public void newMtl(String name);

	public void setXYZ(int type, double x, double y, double z);

	public void setRGB(int type, double r, double g, double b);

	public void setIllum(int illumModel);

	public void setD(boolean halo, double factor);

	public void setNs(double exponent);

	public void setSharpness(double value);

	public void setNi(double opticalDensity);

	public void setMapDecalDispBump(int type, String filename);

	public void setRefl(int type, String filename);

	public void doneParsingMaterial();

	public Model doneParsingObj();
	
	public void close();
}