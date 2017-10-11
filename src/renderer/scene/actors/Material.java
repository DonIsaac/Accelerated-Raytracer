package renderer.scene.actors;


import renderer.infrastructure.math.Vector3;
import renderer.infrastructure.pipeline.model.BuilderInterface;

/**
 * A data structure to store WaveFront .mtl file data. This class is not an original work, but is instead a
 * derivative work from a parser written by
 * <a href="https://github.com/seanrowens/oObjLoader">Sean R. Owens</a>.
 * @author Sean R. Owens
 *
 */
public class Material {

 public String name; 
 public Vector3 ka = Vector3.ZERO;
 public Vector3 kd = Vector3.ZERO;
 public Vector3 ks = Vector3.ZERO;
 public Vector3 tf = Vector3.ZERO;
 public int illumModel = 0;
 public boolean dHalo = false;
 public double dFactor = 0.0;
 public double nsExponent = 0.0;
 public double sharpnessValue = 0.0;
 public double niOpticalDensity = 0.0;
 public String mapKaFilename = null;
 public String mapKdFilename = null;
 public String mapKsFilename = null;
 public String mapNsFilename = null;
 public String mapDFilename = null;
 public String decalFilename = null;
 public String dispFilename = null;
 public String bumpFilename = null;
 public int reflType = BuilderInterface.MTL_REFL_TYPE_UNKNOWN;
 public String reflFilename = null;

 public Material(String name) {
     this.name = name;
 }
}