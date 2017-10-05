package renderer.index;

import renderer.infrastructure.math.Transform;

public class Index {
	
    
	public static void main(String[] args) {
		//new TestEngine();
		Transform M = Transform.getIdentityInstance();
		System.out.println(M);
		Transform N = Transform.getTranslationInstance(5,5,5);
		System.out.println(N);
		M.combine(N);
		System.out.println(M);
	}

}
