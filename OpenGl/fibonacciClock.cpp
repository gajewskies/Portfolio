#include <cstdio>
#include <ctime>
#include <iostream>
#include <cmath>
#include <Windows.h>
#include <glut.h>

using namespace std;


void init(float r, float g, float b) {
	// Set the background color
	glClearColor(r, g, b, 1.0);
	// Set projection parameters
	glMatrixMode(GL_PROJECTION);
	// Set the clipping field
	gluOrtho2D(0.0, 1000.0, 0.0, 618.0);
}

void getTime() {
	time_t currentTime;
	struct tm *localTime;

	// Get the current time
	time(&currentTime);
	// Convert the current time to the local time
	localTime = localtime(&currentTime);

	int hour = localTime->tm_hour;
	int min = localTime->tm_min;
	int sec = localTime->tm_sec;

	if (hour < 12 && min < 60) {
		hour = hour;
	}
	else if (hour > 12 && min < 60) {
		hour = hour - 12;
	}

	cout << hour << ":" << min << ":" << sec << endl;
}

void display(void) {
	// clear the buffers
	glClear(GL_COLOR_BUFFER_BIT);
	// set the shape color
	glColor3f(1.0, 1.0, 1.0);

	// Tell the program the time now
	int hour = 4;
	int minutes = 30;
	

	// green square "five"
	if (hour >= 5) {
		glColor3f(1.0, 0.0, 0.0);
		glBegin(GL_QUADS);
			glVertex2i(0, 0);
			glVertex2i(0, 618);
			glVertex2i(0, 618);
			glVertex2i(618, 618);
			glVertex2i(618, 618);
			glVertex2i(618, 0);
			glVertex2i(618, 0);
			glVertex2i(0, 0);
		glEnd();
		hour = hour - 5;
	}
	else {
		glColor3f(1.0, 1.0, 1.0);
		glBegin(GL_QUADS);
			glVertex2i(0, 0);
			glVertex2i(0, 618);
			glVertex2i(0, 618);
			glVertex2i(618, 618);
			glVertex2i(618, 618);
			glVertex2i(618, 0);
			glVertex2i(618, 0);
			glVertex2i(0, 0);
		glEnd();
	}

	// blue sqaure "three"
	if (hour >= 3) {
		glColor3f(1.0, 0.0, 0.0);
		glBegin(GL_QUADS);
			glVertex2i(618, 236);
			glVertex2i(618, 618);
			glVertex2i(618, 618);
			glVertex2i(1000, 618);
			glVertex2i(1000, 618);
			glVertex2i(1000, 236);
			glVertex2i(1000, 236);
			glVertex2i(618, 236);
		glEnd();
		hour = hour - 3;
	}
	else {
		glColor3f(1.0, 1.0, 1.0);
		glBegin(GL_QUADS);
			glVertex2i(618, 236);
			glVertex2i(618, 618);
			glVertex2i(618, 618);
			glVertex2i(1000, 618);
			glVertex2i(1000, 618);
			glVertex2i(1000, 236);
			glVertex2i(1000, 236);
			glVertex2i(618, 236);
		glEnd();
	}

	if (hour >= 2) {
		glColor3f(1.0, 0.0, 0.0);
		glBegin(GL_QUADS);
			glVertex2i(764, 0);
			glVertex2i(764, 236);
			glVertex2i(764, 236);
			glVertex2i(1000, 236);
			glVertex2i(1000, 236);
			glVertex2i(1000, 0);
			glVertex2i(1000, 0);
			glVertex2i(764, 0);
		glEnd();
		hour = hour - 2;
	}
	else {
		glColor3f(1.0, 1.0, 1.0);
		glBegin(GL_QUADS);
			glVertex2i(764, 0);
			glVertex2i(764, 236);
			glVertex2i(764, 236);
			glVertex2i(1000, 236);
			glVertex2i(1000, 236);
			glVertex2i(1000, 0);
			glVertex2i(1000, 0);
			glVertex2i(764, 0);
		glEnd();
	}

	// black sqaure "one"
	if (hour >= 1) {
		glColor3f(1.0, 0.0, 0.0);
		glBegin(GL_QUADS);
			glVertex2i(618, 0);
			glVertex2i(618, 118);
			glVertex2i(618, 118);
			glVertex2i(764, 118);
			glVertex2i(764, 118);
			glVertex2i(764, 0);
			glVertex2i(764, 0);
			glVertex2i(618, 0);
		glEnd();
		hour = hour - 1;
	}
	else {
		glColor3f(1.0, 1.0, 1.0);
		glBegin(GL_QUADS);
			glVertex2i(618, 0);
			glVertex2i(618, 118);
			glVertex2i(618, 118);
			glVertex2i(764, 118);
			glVertex2i(764, 118);
			glVertex2i(764, 0);
			glVertex2i(764, 0);
			glVertex2i(618, 0);
		glEnd();
	}

	// white sqaure "one"
	if (hour >= 1) {
		glColor3f(1.0, 0.0, 0.0);
		glBegin(GL_QUADS);
			glVertex2i(618, 118);
			glVertex2i(618, 236);
			glVertex2i(618, 236);
			glVertex2i(764, 236);
			glVertex2i(764, 236);
			glVertex2i(764, 118);
			glVertex2i(764, 118);
			glVertex2i(618, 118);
		glEnd();
		hour = hour - 1;
	}
	else {
		glColor3f(1.0, 1.0, 1.0);
		glBegin(GL_QUADS);
			glVertex2i(618, 118);
			glVertex2i(618, 236);
			glVertex2i(618, 236);
			glVertex2i(764, 236);
			glVertex2i(764, 236);
			glVertex2i(764, 118);
			glVertex2i(764, 118);
			glVertex2i(618, 118);
		glEnd();
	}

	glFlush();
}

void reshape(GLint newWidth, GLint newHeight) {
	// reset the window to original size after trying to resize it
	glutReshapeWindow(1000, 618);
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

void main(int argc, char **argv) {
	// tell console the time
	getTime();
	// initialize glut
	glutInit(&argc, argv);
	// set the display mode
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	// set the window position
	glutInitWindowPosition((glutGet(GLUT_SCREEN_WIDTH) - 1000) / 2, (glutGet(GLUT_SCREEN_HEIGHT)-618)/2);
	// set the window size
	glutInitWindowSize(1000, 618);
	// create the window
	glutCreateWindow("Fibonacci Clock");
	// Call init()
	init(0.0, 0.0, 0.0);
	// declare display function
	glutDisplayFunc(display);
	// declare reshaping function
	glutReshapeFunc(reshape);
	// call error chekcing
	errorCheck();
	// enter the main loop
	glutMainLoop();

}