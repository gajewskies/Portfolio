#include <iostream>
#include <glew.h>
#include <glut.h>
#include <glfw3.h>
#include <stdio.h>										// Used for fprintf and stderr
#include <stdlib.h>	
#include <wglew.h>
#include <string>
#include <fstream>

class GLFWManager : public WindowManager
{
public:

	// Create an empty constructor and have the deconstructor release our memory
	GLFWManager()	{ }
	~GLFWManager()	{ Destroy(); }

	// This initialized the window and creates the OpenGL context
	virtual int Initialize(int width, int height, std::string strTitle, bool bFullScreen = false);

	// This swaps the backbuffer to the front and should be called every frame
	virtual void SwapTheBuffers();

	// This processes any needed input for the application, like the Escape key
	virtual bool ProcessInput(bool continueGame);

	// This destroys the window and OpenGL context
	virtual void Destroy();

protected:

	// This is the GLFW window object that manages the window and input
	GLFWwindow* Window;
};

class GLApplication
{
public:

	// Create a default constructor and deconstructor which cleans up
	GLApplication() {}
	~GLApplication() { Destroy(); }

	// This is the main function for our application, which is called by the main() function
	// in the WindowManager.cpp file.  This helps abstract out the environments entry point.
	int GLMain();

	// This gets and sets the window manager for the application.  This should be set right
	// after the GLApplication is created in the main() function.
	WindowManager *GetWindowManager() { return WindowManager; }
	void SetWindowManager(WindowManager *pWindowManager) { WindowManager = pWindowManager; }

	// This initializes the application
	void Initialize();

	// This runs the game loop and only quits when the user hits Escape or closes the window
	void GameLoop();

	// This cleans up the application and tells other objects to also cleanup
	void Destroy();

private:

	// Our abstract window manager to create the window and manage input, which should be
	// environment agnostic.  Our main application shouldn't know if it's Win32 or GLFW.
	// This is instantiated and set in GLFWManager.cpp in the main() function.
	WindowManager *WindowManager;
};

class Vertex3
{
public:

	// The x, y, z values for our 3D points
	float xyz[3];
};


// The Model class to handle initializing, rendering and destroying of a 3D object
class Model
{
public:

	// These are created to standardize the index properties used for vertex properties.
	// In this tutorial we only use the kVertexIndex, but in later ones we will use all of them.
	static const GLuint kVertexIndex = 0;				// This is for the x,y,z vertices
	static const GLuint kColorIndex = 1;				// This is for the r,g,b,a colors
	static const GLuint kTextureIndex = 2;				// This is for the u,v texture coordinates
	static const GLuint kNormalIndex = 3;				// This is for the x,y,z normals

	// Create an empty constructor and have the deconstructor release our memory.
	Model()		{ }
	~Model()	{ Destroy(); }

	// Takes in a list of x,y,z vertices and vertex length to create the VBO and VAO's from,
	// as well as the text file locations for the vertex and fragment shaders to load.
	void Initialize(Vertex3 vertices[], int length, std::string strVertex, std::string strFragment);

	// This draws the Model to the backbuffer
	void Render();

	// This cleans up the VBO and VAO's
	void Destroy();

private:

	Vertex3 *Vertices;									// The list of the vertices
	GLint VerticesLength;								// The length of the vertices
	GLuint VertexBufferId;								// The VBO Id stored by the VAO
	GLuint VertexArrayObjectId;							// The VAO Id to bind when drawing

	// Our shader object to initialize and run the shaders
	Shader Shader;
};

class Shader
{
public:

	// Create an empty constructor and have the deconstructor release our memory.
	Shader()	{ }
	~Shader()	{ Destroy(); }

	// This loads our text file for each shader and returns it in a string
	std::string LoadShaderFile(std::string strFile);

	// This loads a vertex and fragment shader from a text file (relative or full path)
	void Initialize(std::string strVertexFile, std::string strFragmentFile);

	// This returns an ID for a variable in our shader, to be used with a Set*() function
	GLint GetVariable(std::string strVariable);

	// Below are functions to set an integer, a set of floats or a matrix (float[16])
	void SetInt(GLint id, int newValue)											{ glUniform1i(id, newValue); }
	void SetFloat(GLint id, GLfloat newValue)									{ glUniform1f(id, newValue); }
	void SetFloat2(GLint id, GLfloat v0, GLfloat v1)							{ glUniform2f(id, v0, v1); }
	void SetFloat3(GLint id, GLfloat v0, GLfloat v1, GLfloat v2)				{ glUniform3f(id, v0, v1, v2); }
	void SetFloat4(GLint id, GLfloat v0, GLfloat v1, GLfloat v2, GLfloat v3)	{ glUniform4f(id, v0, v1, v2, v3); }

	// This allows us to pass in 4x4 matrix (float array of 16) to a shader by the Id received from GetVariable()
	void SetMatrix4(GLint id, GLsizei count, GLboolean transpose, const GLfloat *value)
	{
		glUniformMatrix4fv(id, count, transpose, value);
	}

	// These 2 functions turn on and off our shader, which uses the OpenGL glUseProgram() function
	void TurnOn()		{ glUseProgram(ShaderProgramId); }
	void TurnOff()		{ glUseProgram(0); }

	// This releases our memory for our shader
	void Destroy();

private:

	// This Id stores our vertex shader information
	GLuint VertexShaderId;

	// This Id stores our fragment shader information
	GLuint FragmentShaderId;

	// This Id stores our program information which encompasses our shaders
	GLuint ShaderProgramId;
};

class WindowManager
{
public:

	// This is needed so that the class inheriting this will have it's deconstructor called
	virtual ~WindowManager() {}

	// This initialized the window and creates the OpenGL context
	virtual int Initialize(int width, int height, std::string strTitle, bool bFullScreen = false) = 0;

	// This swaps the backbuffer to the front and should be called every frame
	virtual void SwapTheBuffers() = 0;

	// This processes any needed input for the application, like the Escape key
	virtual bool ProcessInput(bool continueGame) = 0;

	// This destroys the window and OpenGL context
	virtual void Destroy() = 0;
};

int main()
{
	// First create our desired WindowManager implementation so we can set it below
	GLFWManager *pWindowManager = new GLFWManager();

	// Create a local instance of our GLApplication (defined in Main.cpp) and set its
	// WindowManager implementation (in this case, GLFW).
	GLApplication application;
	application.SetWindowManager(pWindowManager);

	// Return the GLMain() defined in Main.cpp, which handles the flow of our application
	// and immediately starts our game loop.
	return application.GLMain();
}


// This initializes our window and creates the OpenGL context
int GLFWManager::Initialize(int width, int height, std::string strTitle, bool bFullScreen)
{
	// This tries to first init the GLFW library and make sure it is available
	if (!glfwInit())
	{
		fprintf(stderr, "Failed to initialize GLFW\n");
		return -1;
	}

	// Now we need to use GLFW to tell OpenGL what settings we want, and most importantly, 
	// which version of OpenGL we are using.  We do this with glfwWindowHint() function calls.
	// See http://www.glfw.org/docs/latest/window.html#window_hints for all the window hints.

	// This tells OpenGL that our OpenGL context will have a multisampling value of 4, which means
	// it will use antialiasing to smooth out the jagged pixels when rendering.  So it will same
	// the final rendered image 4 times to make it smooth as silk.  Comment this out to see it jagged.
	glfwWindowHint(GLFW_SAMPLES, 4);

	// This requires that we must be using OpenGL 4 and by specifying the CORE_PROFILE we are saying
	// that we don't want to support any older OpenGL version and don't care about compatibility.
	// If you want to use older OpenGL functions, you would need to pass in GLFW_OPENGL_COMPAT_PROFILE.
	// If your computer doesn't run with 4, try changing it to 3 or download the latest drivers here:
	// https://www.opengl.org/wiki/Getting_Started
	glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 4);
	glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 4);
	glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);

	// This next function creates the window with the settings given above. It takes the window width 
	// and height, the title, and monitor information that tells GLFW if we want a fullscreen window or not.
	// To make the window fullscreen you pass in glfwGetPrimaryMonitor() to the second to last parameter.
	if (bFullScreen)
		Window = glfwCreateWindow(width, height, strTitle.c_str(), glfwGetPrimaryMonitor(), nullptr);
	else
		Window = glfwCreateWindow(width, height, strTitle.c_str(), nullptr, nullptr);

	// Make sure the window is valid, if not, throw an error.
	if (Window == nullptr)
	{
		fprintf(stderr, "Failed to create a GLFW window, you might need to download the latest drivers or change the OpenGL version to 3\n");
		Destroy();

		return -1;
	}

	// Create the OpenGL context from the window and settings specified
	glfwMakeContextCurrent(Window);

	// This turns on STICKY_KEYS for keyboard input, so that glfwgetKey() returns GLFW_PRESS the next 
	// time it's called if the key has been released before the call.  We pass in our Window object
	// as the first parameter, then the settings to turn STICKY_KEYS set to TRUE.  Keyboard input will 
	// still work without this, just not "sticky".
	glfwSetInputMode(Window, GLFW_STICKY_KEYS, GL_TRUE);

	// This is an important part, at least for my system I had to set this parameter to true otherwise
	// OpenGL wouldn't work and the GLEW library would fail to load.  Apparently, this is because by
	// setting it to Experimental, it goes and search for all supported OpenGL functions even if the
	// video card doesn't mark them as standard.  So be sure to set this TRUE if you have the same issue.
	glewExperimental = GL_TRUE;

	// Initialize the GLEW library so that it can go and find the correct OpenGL functions for the
	// current environment, and any new functions that were defined after OpenGL 1.1, since if you
	// are on Windows for instance, the gl.h library won't recognize anything after version 1.1.
	// That means no shader support or OpenGL 4 support.  We could define them ourselves like we
	// did in our old shader tutorials, but this just makes it easier and has become a standard.
	GLenum err = glewInit();

	// If we had an error, return -1.  Be sure to see if glewExperimental isn't true, this worked for me.
	if (GLEW_OK != err)
	{
		fprintf(stderr, "Failed to initialize glew\n");
		return -1;
	}

	// Return success
	return 0;
}


// This swaps the backbuffer with the front buffer to display the content rendered in OpenGL
void GLFWManager::SwapTheBuffers()
{
	// This takes the Window and swaps the backbuffer to the front.  This way we don't see tearing
	// as the content is drawn to the screen each frame.  This is called double buffering.  This
	// should be called at the end of the Render() function in the GLApplication, once all content
	// in done rendering.  We pass in the GLFW window object to this function.
	glfwSwapBuffers(Window);
}


// This function processes all the application's input and returns a bool to tell us if we should continue
bool GLFWManager::ProcessInput(bool continueGame = true)
{
	// Use the GLFW function to check for the user pressing the Escape button, as well as a window close event.
	// If any of these checks return true, return false back to the caller to let them know the user has quit.
	if (glfwGetKey(Window, GLFW_KEY_ESCAPE) == GLFW_PRESS || glfwWindowShouldClose(Window) != 0)
		return false;

	// Poll the input events to see if the user quit or closed the window.  This can only be called
	// in the main thread of the application, so apparently you can't spin off another thread for this.
	glfwPollEvents();

	// Return the value passed in to tell the game loop that we should continue or not.  This would be used
	// to have an external variable tracking the state of the game, like from a menu or something.
	return continueGame;
}


// This destroys the window
void GLFWManager::Destroy()
{
	// This closes the OpenGL window and terminates the application
	glfwTerminate();
}

Model g_Triangle;										// Our class to handle initializing and drawing our triangle


// This is our own main() function which abstracts the required main() function to run this application.
// This way if we want to run a Win32 application which requires a WinMain(), we can hide that in a Win32Manager,
// which our GLFWManager currently has a regular console application main() function that just immediately calls 
// this function after setting the WindowManager class. You can look to this function as the first thing that will 
// happen in our OpenGL applications that is outside the general one-time initialization for our window.
int GLApplication::GLMain()
{
	// This calls our Initialize() function below which sets up the creation of the window and initializes
	// the triangle vertices and associated shaders.
	Initialize();

	// This is our main game loop which will run until we close the window or hit Escape.
	GameLoop();

	// Once we hit Escape this will clean up the application's resources.  The same functions will be called
	// in the individual classes' deconstructors, but we do it anyway as a good practice in always cleaning up.
	Destroy();

	return 0;
}


// This function initializes the window, the shaders and the triangle vertex data.
void GLApplication::Initialize()
{
	// Make sure the window manager is initialzed prior to calling this and creates the OpenGL context.
	// This takes in a window width, height, title and a fullscreen boolean.
	if (!WindowManager || WindowManager->Initialize(1024, 768, "GameTutorials - First OpenGL 4 Program", false) != 0)
	{
		// Quit the application if the window couldn't be created with an OpenGL context
		exit(-1);
	}

	// Initialize the three XYZ points of the triangle.  This is our own class which stores the vertex
	// and later in other tutorials the associated color, texture coordinates and normals together.
	// We need 3 points to create a triangle in 3D.  We pass them in a clock-wise order.  The winding order 
	// of the vertices is incredibly important because it tells OpenGL what is the front and back side of
	// our triangle.  This comes into play when we turn on backface culling to only draw triangles facing
	// the camera.  This adds an optimization to your rendering if you know you aren't going inside objects.
	// Notice that the Z value is 0, so that means this will render right on the X,Y axis like it would in 2D.
	// The W column that the vertex shader's gl_Position needs is hard coded to 1 in the shader for now, and 
	// eventually is calculated for us when we do our matrix math in later tutorials (see the Matrices tutorial).
	Vertex3 vertices[] =
	{	//    X 	 Y	   Z   		
		{ -0.6f, -0.6f, 1.0 },		// Bottom-left vertex
		{ 0.0f, 0.6f, 1.0 },		// Top vertex
		{ 0.6f, -0.6f, 1.0 }, 		// Bottom-right vertex
	};

	// A note about the coordinates above, since we are not doing any matrix multiplication with a
	// model, view and projection matrix, we are just hard coding "Clipping Coordinates" that will be
	// passed into the gl_Position of our vertex shader.  This means that our coordinates can only
	// be between -1 to 1 along all the axises before being clipped because that's what the clipping 
	// coordinates are, a box made up of -1 to 1 on each axis. So if you wanted to make the triangle fill
	// the screen you would put the coordinates at (-1, -1, 0, 1), (0, 1, 0, 1), (1, -1, 0, 1).
	// Try and change the Z values to 1.01 and you will notice that it dissappears due to being clipped.
	// In a later tutorial we will go over matrices, which will then be taking the W value of the
	// vertices and dividing each the X,Y,Z by that W value to give the "Perspective Division".  I chose
	// to handle the W value in the shader and hard code it as 1.0 since we won't be using it in our code.
	// Notice that if you start changing the W values you can see the triangle get bigger and smaller.
	// This is kind of confusing, but just know that no one works in the Clipping Coordinate Space, we do
	// in this tutorial to just do the very basics to show a triangle, and later we will use matrices which
	// convert our model and view matrix to the clipping space for us.

	// Initialize the triangle with the vertex array and give the length of 3.  This will create our
	// Vertex Buffer Object and Vertex Array Object.
	g_Triangle.Initialize(vertices, 3, "Shaders/Shader.vertex", "Shaders/Shader.fragment");
}


// This is our game loop where all the magic happens every frame
void GLApplication::GameLoop()
{
	// Loop until the user hits the Escape key or closes the window.  We created a ProcessInput function to
	// abstract the input from the main application flow so that we can make it easier for different 
	// environments.  We pass in true to always keep the loop running, but this could be replaced with a
	// custom boolean variable like bGameNotOver that could be set somewhere else like a menu system.
	while (WindowManager->ProcessInput(true))
	{
		// This clears the screen every frame to black (color can be changed with glClearColor).
		// Since our triangle isn't moving it doesn't really matter, but once you have moving objects
		// this is necessary otherwise the last frame will still have the old pixels and cause artifacts.
		glClear(GL_COLOR_BUFFER_BIT);

		// This renders our triangle to the back buffer (not the screen yet).
		g_Triangle.Render();

		// Now that we have told OpenGL to draw our white triangle, it isn't on screen yet until we swap
		// the back buffer with the front (visible) buffer.  This is so we don't see tearing artifacts
		// happening as we draw many objects to the screen during a single frame.  This is the same as drawing
		// objects in 2D, you don't swap the buffers until all the objects have been drawn on the screen.
		// Since each cross-platform framework has their own method for this, we abstract it in our own class.
		WindowManager->SwapTheBuffers();
	}
}


// This can be used to free all of our resources in the application.
void GLApplication::Destroy()
{
	// Free the vertex buffers and array objects
	g_Triangle.Destroy();

	// If we have a window manager still allocated then destroy and delete it
	if (WindowManager)
	{
		WindowManager->Destroy();

		delete WindowManager;
		WindowManager = nullptr;
	}
}

void Model::Initialize(Vertex3 vertices[], GLint length, std::string strVertex, std::string strFragment)
{
	// Create and compile our GLSL vertex and fragment shaders from the shader text files passed
	// in.  Please refer to Shader.cpp to see how these shaders are loaded, compiled then assigned.
	Shader.Initialize(strVertex, strFragment);

	// Store the list of vertices and the length in our member variables
	Vertices = vertices;
	VerticesLength = length;

	// This function gets the last error that happened from OpenGL, after the last time this
	// function was called.  So by calling it now, we reset the errors and then call it below again.
	GLenum ErrorCheckValue = glGetError();

	// This is where we create our Vertex Array Object (VAO), which saves the state and property information
	// about the Vertex Buffer Object (which stores the vertices in a buffer to pass to the GPU).
	// glGenVertexArrays() sends back a new unique unsigned number that represents the VAO.  Once we
	// receive the newly created VAO index we need to bind it to tell OpenGL we are using is right away.
	// This can generate many VAO's, but we just need one so we just pass in a single GLuint and just say
	// that we want to 1 returned.
	glGenVertexArrays(1, &VertexArrayObjectId);
	glBindVertexArray(VertexArrayObjectId);

	// Now we need to create our Vertex Buffer Object (VBO) which stores a buffer of all the vertices,
	// which can then be quickly passed to our video card's GPU to render them every frame.  Similar to
	// generating the VAO, we need to also get a unique number for the VBO with glGenBuffers, which we
	// tell it that we want 1 number back.  We then immediately bind the buffer to memory to tell OpenGL
	// we want to be working with that newly created buffer going forward.  GL_ARRAY_BUFFER tells OpenGL
	// that this buffer is a standard array of data instead of an indexed array with GL_ELEMENT_ARRAY_BUFFER.
	// Indexed arrays works as long as you aren't doing texture coordinates, which can't be shared so
	// you end up having to pass all the duplicated vertices in anyways if you want texture mapping.
	glGenBuffers(1, &VertexBufferId);
	glBindBuffer(GL_ARRAY_BUFFER, VertexBufferId);

	// The next steps is actually storing the list of vertices in our buffer.  We use the same target
	// GL_ARRAY_BUFFER as what we bound to above, and then the length of the buffer, then the actual
	// buffer which is the vertices passed in, then a "hint" to OpenGL to tell it if it will be a static
	// buffer or will be changing (DYNAMIC).  We will always just choose STATIC in our case.  This "hint"
	// just helps OpenGL know if the data will be changing often so it knows how to optimize the usage.
	glBufferData(GL_ARRAY_BUFFER, sizeof(Vertices[0]) * length, Vertices, GL_STATIC_DRAW);

	// Here is where we tell OpenGL what the format each vertex is within our buffer.  In our case, we
	// have 3 floats. In this tutorial we only have vertices, but if we had colors and other things like
	// texture coordinates and normals, we would need to call this function for each attribute.  The
	// next tutorial on colors will go over this.  First we pass in the index used to refer to the
	// attribute, in our case, the vertices, and I pass in a constant value kVertexIndex which is 0.
	// I created a constant for each type of attribute we will use, defined in the Model.h file.
	// Later when we render we need to turn on this index with glEnableVertexAttribArray().  The next
	// parameters are the number of floats which is 3 for the xyz, then the format (GL_FLOAT), then
	// FALSE since we don't need OpenGL to normalize our fixed-point data, then the size in bytes each
	// attribute is, then a pointer to the location the attribute is within the Vertex3 class.  The
	// default is 0, which means that it's the first property in the class, which xyz is.  In the
	// next tutorial you will see how we need to pass in a pointer to the location of the color
	// attribute within the Vector3 class.
	glVertexAttribPointer(kVertexIndex, 3, GL_FLOAT, GL_FALSE, sizeof(Vertices[0]), 0);

	// Now check to see if any errors happened in this function, which saves us tons of time instead
	// of trying to figure out why our screen is black and we would have no idea why.
	ErrorCheckValue = glGetError();

	// If there was an error found, print it to the screen and close the OpenGL window.
	if (ErrorCheckValue != GL_NO_ERROR)
	{
		// Use gluErrorString(ErrorCheckValue) if you want to get the string value of the
		// error, but I removed this since Mac OSX 10.9 (Mavericks) deprecated this function.
		fprintf(stderr, "ERROR: Could not create a VAO and VBO with error Id: %d\n", ErrorCheckValue);
		exit(-1);
	}
}


// This is the function that will actually render the model to the backbuffer, usually every frame
// if called in the GameLoop() function in Main.cpp.  
void Model::Render()
{
	// This turns our shader on before we tell OpenGL to render the triangle.
	Shader.TurnOn();

	// First we want to tell OpenGL with VAO is going to be used for rendering.  SInce there could
	// be other Model objects being rendered with their own VAO, we need to set it every time we render.
	glBindVertexArray(VertexArrayObjectId);

	// Before drawing our model, we need to specify the attribute index that will be used when drawing
	// this model, which in our case is just the vertex attribute (0).  Later we will also enable color.
	glEnableVertexAttribArray(kVertexIndex);

	// glDrawArrays() is the function that actually tells OpenGL to draw the triangles from our VBO,
	// according to the VAO which stores the state and glVertexAttribPointer() properties used when we 
	// created the VBO in our Initialize() function.  We first pass in GL_TRIANGLES since we are rendering
	// triangles, then a starting position of 0 within the array since we want to render all of the
	// vertices from the the begiining of the array, and then finally the amount of vertices to draw.
	glDrawArrays(GL_TRIANGLES, 0, VerticesLength);

	// Now we do our cleanup, which is to disable the current vertex attribute for our VAO/VBO.
	glDisableVertexAttribArray(kVertexIndex);

	// Next, let's reset the current VAO binding to 0, which clears out any binding. This isn't necessary
	// since the next time a glBindVertexArray() would be called from another Model it will override 
	// the current one, but just to show how to clear a VAO binding I added this for those interested.
	glBindVertexArray(0);

	// This turns off the shader so that other objects rendered after this won't be using this shader.
	// The idea is that this is how you would turn on and off shaders for different objects being drawn
	// with their own shaders. Say for instance, one character might have a cartoon-rendered look and
	// another would have a more realistic rendering that requires completely separate shaders.
	Shader.TurnOff();
}


// This handles all the cleanup for our model, like the VBO/VAO buffers and shaders.
void Model::Destroy()
{
	// If we have a valid vertex buffer, reset it's binding, delete it and clear the property
	if (VertexBufferId)
	{
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		glDeleteBuffers(1, &VertexBufferId);
		VertexBufferId = 0;
	}

	// If we have a valid vertex array, reset it's binding, delete it and clear the property
	if (VertexArrayObjectId)
	{
		glBindVertexArray(0);
		glDeleteVertexArrays(1, &VertexArrayObjectId);
		VertexArrayObjectId = 0;
	}

	// Release the memory for the compiled shaders
	Shader.Destroy();
}

std::string Shader::LoadShaderFile(std::string strFile)
{
	// Open the file passed in
	std::ifstream fin(strFile.c_str());

	// Make sure we opened the file correctly
	if (!fin)
		return "";

	std::string strLine = "";
	std::string strText = "";

	// Go through and store each line in the text file within a "string" object
	while (getline(fin, strLine))
	{
		strText = strText + "\n" + strLine;
	}

	// Close our file
	fin.close();

	// Return the text file's data
	return strText;
}


// This function loads a vertex and fragment shader file and creates them
void Shader::Initialize(std::string strVertexFile, std::string strFragmentFile)
{
	// This function actually loads, compiles and links our shaders.  Basically,
	// we create some pointers for shaders, then load in text files for
	// each shader, then compile the shader.  We also need to create a
	// program object that represents all of our shaders.  We link the
	// loaded shaders to our program object and then can turn it on when needed.

	// These will hold the shader's text file data
	std::string strVShader, strFShader;

	// Make sure the user passed in a vertex and fragment shader file
	if (!strVertexFile.length() || !strFragmentFile.length())
		return;

	// If any of our shader pointers are set, let's free them first
	if (VertexShaderId || FragmentShaderId || ShaderProgramId)
		Destroy();

	// This function gets the last error that happened from OpenGL, after the last time this
	// function was called.  So by calling it now, we reset the errors and then call it below again.
	GLenum ErrorCheckValue = glGetError();

	// Here we get an Id to our vertex and fragment shaders
	VertexShaderId = glCreateShader(GL_VERTEX_SHADER);
	FragmentShaderId = glCreateShader(GL_FRAGMENT_SHADER);

	// Now we load the shaders from the respective files and store it in a string
	strVShader = LoadShaderFile(strVertexFile.c_str());
	strFShader = LoadShaderFile(strFragmentFile.c_str());

	// Do a quick switch so we can do a double pointer below
	const char *szVShader = strVShader.c_str();
	const char *szFShader = strFShader.c_str();

	// Now this assigns the shader text file to each shader pointer
	glShaderSource(VertexShaderId, 1, &szVShader, nullptr);
	glShaderSource(FragmentShaderId, 1, &szFShader, nullptr);

	// Now we actually compile the shader code
	glCompileShader(VertexShaderId);
	glCompileShader(FragmentShaderId);

	// Next we create a program object to represent our shaders
	ShaderProgramId = glCreateProgram();

	// We attach each shader we just loaded to our program object
	glAttachShader(ShaderProgramId, VertexShaderId);
	glAttachShader(ShaderProgramId, FragmentShaderId);

	// Our last init function is to link our program object with OpenGL
	glLinkProgram(ShaderProgramId);

	// Now check to see if any errors happened in this function, which saves us tons of time instead
	// of trying to figure out why our screen is black and we would have no idea why.
	ErrorCheckValue = glGetError();

	// If there was an error found, print it to the screen and close the OpenGL window.
	if (ErrorCheckValue != GL_NO_ERROR)
	{
		// Use gluErrorString(ErrorCheckValue) if you want to get the string value of the
		// error, but I removed this since Mac OSX 10.9 (Mavericks) deprecated this function.
		fprintf(stderr, "ERROR: Could not create the shader program with error Id: %d\n", ErrorCheckValue);
		exit(-1);
	}
}

// This function returns a variable Id for a shader variable.  This is used
// when we need to pass in variables into a shader like numbers and matrices.
GLint Shader::GetVariable(std::string strVariable)
{
	// If we don't have an active program object, let's return -1
	if (!ShaderProgramId)
		return -1;

	// This returns the variable Id for a variable that is used to find
	// the address of that variable in memory.
	return glGetUniformLocation(ShaderProgramId, strVariable.c_str());
}


// This function frees all of our shader data
void Shader::Destroy()
{
	// To free a shader we need to detach the vertex and fragment
	// shader pointers from the program object, then free each one.
	// Once that is done we can finally delete the program object.

	// If our vertex shader pointer is valid, free it
	if (VertexShaderId)
	{
		glDetachShader(ShaderProgramId, VertexShaderId);
		glDeleteShader(VertexShaderId);
		VertexShaderId = 0;
	}

	// If our fragment shader pointer is valid, free it
	if (FragmentShaderId)
	{
		glDetachShader(ShaderProgramId, FragmentShaderId);
		glDeleteShader(FragmentShaderId);
		FragmentShaderId = 0;
	}

	// If our program object pointer is valid, free it
	if (ShaderProgramId)
	{
		glDeleteShader(ShaderProgramId);
		ShaderProgramId = 0;
	}
}







