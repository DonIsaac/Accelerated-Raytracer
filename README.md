# Accelerated Raytracer

A GPU Accelerated Raytracer. Not even in Alpha yet.

## Changes From The [Last Raytracer](https://github.com/DonIsaac/Raytrace-Renderer)
1. Improved workflow
2. GPU acceleration
3. Improved math classes
## Why is this in Java?

A couple of reasons:
1) I am the most familiar with Java
2) Because of the JIT compiler optimizations, Java programs can run as fast, if not faster, than C++ programs
3) Java is great for UI stuff

## Workflow Completion

Key:
+ completed
* needs more work (either incomplete or may need future modifications)
- uncompleted

### 1. Loading (Content Pipeline)
	1a. File tree setup *
	1a. Set up config file *
	1b. Write ContentManager
		* Resource storage infrastructure -
		* Model/Material/Texture Parser -
		* Scene parser -
		* Animation parser -
		
### 2. Scene/World/Actors 
	2a. Scene -
	3b. World -
	2c. Camera -
	2d. Model *
	2e. Lighting -
	
### 3. Raytracing
	3a. Initial model intersections -
	3b. GPU Accelerated raytracing -
	3c. Raytracing infrastructure (RaycastHit, etc) -
	
### 4. Shading
	4a. Blinn-Phong shading -
	4b. Texture mapping
		* Bump map -
		* Diffuse map -

### 5. Animation
	5a. Animator -
	5b. Animation -
	5c. Camera adjustment (moving Camera, switching Cameras, etc.) -

### 6. Unloading (Content Pipeline)
	6a. Saving scene data -
	6b. Saving rendered images -
	6c. Converting images into a .mp4 -

### 7. Misc
	7a. Math library +
	7b. Utils library *
	7c. Wiki -

