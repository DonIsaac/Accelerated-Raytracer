package renderer.infrastructure.pipeline.model;

import static renderer.Config.LOG;

import java.util.logging.Level;

import renderer.infrastructure.math.Vector3;
import renderer.scene.actors.Model;
import renderer.scene.actors.TextureCoordinate;

/**
 * Builds the <code>Model</code> being parsed by the <code>OBJParser</code> that
 * this <code>ModelBuilder</code> is plugged in to. This class fully parses a
 * .obj file and it's respective .mtl files, even though not all the features
 * may be implemented by the Raytracer.
 * <p>
 * Some helpful references: 
 * <br />
 * <a href="http://paulbourke.net/dataformats/obj/">OBJ specification</a>
 * <br />
 * <a href="http://paulbourke.net/dataformats/mtl/">MTL specification</a>
 * </p>
 * 
 * 
 * @author Don Isaac
 *
 */
public class ModelBuilder implements BuilderInterface {

	Model m;
	private boolean isParsing;
	private boolean canClose;

	public ModelBuilder() {
		isParsing = false;
		canClose = false;
	}

	@Override
	public void startParsing(String filename) {
		if (isParsing)
			LOG.log(Level.SEVERE, "Unable to parse " + filename + " parsing is already in progress.",
					new IllegalStateException());
		m = new Model();
		isParsing = true;

		m.fileName = filename;
	}

	@Override
	public void addVertexGeometric(double x, double y, double z) {
		m.vertices.add(new Vector3(x, y, z));
	}

	@Override
	public void addVertexTexture(double u, double v) {
		m.texCoords.add(new TextureCoordinate(u, v));
	}

	@Override
	public void addVertexNormal(double x, double y, double z) {
		m.normals.add(new Vector3(x, y, z));
	}

	@Override
	public void addPoints(int[] values) {

	}

	@Override
	public void addLine(int[] values) {

	}

	@Override
	public void addFace(int[] vertexIndices) {

	}

	@Override
	public void addObjectName(String name) {

	}

	@Override
	public void addMapLib(String[] names) {

	}

	@Override
	public void setCurrentGroupNames(String[] names) {

	}

	@Override
	public void setCurrentSmoothingGroup(int groupNumber) {

	}

	@Override
	public void setCurrentUseMap(String name) {

	}

	@Override
	public void setCurrentUseMaterial(String name) {

	}

	@Override
	public void newMtl(String name) {

	}

	@Override
	public void setXYZ(int type, double x, double y, double z) {

	}

	@Override
	public void setRGB(int type, double r, double g, double b) {

	}

	@Override
	public void setIllum(int illumModel) {

	}

	@Override
	public void setD(boolean halo, double factor) {

	}

	@Override
	public void setNs(double exponent) {

	}

	@Override
	public void setSharpness(double value) {

	}

	@Override
	public void setNi(double opticalDensity) {

	}

	@Override
	public void setMapDecalDispBump(int type, String filename) {

	}

	@Override
	public void setRefl(int type, String filename) {

	}

	@Override
	public void doneParsingMaterial() {

	}

	@Override
	public Model doneParsingObj() {
		if (!isParsing)
			LOG.log(Level.SEVERE, "You must call startParsing() before calling this method!",
					new IllegalStateException());
		canClose = true;
		return m;
	}

	@Override
	public void close() {
		if (!canClose)
			LOG.log(Level.SEVERE, "Unable to close until after doneParsingObj() has been called",
					new IllegalStateException());
		;
		m = null;
		canClose = false;
	}

}
