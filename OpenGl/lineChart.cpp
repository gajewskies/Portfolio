#include <iostream>
#include <cstdio>
#include <glut.h>

using namespace std;

void initialize() {
	// Set display-window color to white
	glClearColor(1.0, 1.0, 1.0, 1.0);
	// Set projection parameters
	glMatrixMode(GL_PROJECTION);
	gluOrtho2D(0.0, 200.0, 0.0, 150.0);
}

void lineSegment() {
	// Clear display window
	glClear(GL_COLOR_BUFFER_BIT);
	// Set line segment color to green
	glColor3f(0.0, 0.4, 0.2);
	// Begin designing shape
	glBegin(GL_LINES);
	// Specify line-segment geometry
	glVertex2i(180, 15);
	glVertex2i(10, 145);
	glEnd();

	// Process all openGL routines as quickly as possible
	glFlush();
}

GLenum errorCheck() {
	GLenum code;
	const GLubyte *string;

	code = glGetError();
	if (code != GL_NO_ERROR) {
		string = gluErrorString(code);
		fprintf(stderr, "OpenGL error: %s\n", string);
	}
	return code;
}

void main() {
	// Set the display mode
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	// Set top-left display window position
	glutInitWindowPosition(50, 100);
	// set diaply-window width and height
	glutInitWindowSize(400, 300);
	// Create display window
	glutCreateWindow(" A simple openGL line segment program");

	// Execute initialization procedure
	initialize();
	//	Send graphics to display window
	glutDisplayFunc(lineSegment);
	
	errorCheck();
	// Display everything and wait
	glutMainLoop();
}