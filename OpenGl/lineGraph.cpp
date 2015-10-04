#include <cstdlib>
#include <cstdio>
#include <iostream>
#include <glut.h>

using namespace std;
// Initial display window size
GLsizei winWidth = 1000, winHeight =800;
// Initial raster position
GLint xRaster = 30, yRaster = 150;

int lineWidth = 1;

GLubyte Xlabel[20] = {
	' ', '1', 
	' ', '2',
	' ', '3',
	' ', '4', 
	' ', '5', 
	' ',' 6', 
	' ', '7',
	' ', '8', 
	' ', '9', 
	'1', '0'
};

GLubyte Ylabel[33] = {
	' ', ' ', '0',
	'5', '0', ' ',
	'1', '0', '0',
	'1', '5', '0',
	'2', '0', '0',
	'2', '5', '0',
	'3', '0', '0',
	'3', '5', '0',
	'4', '0', '0',
	'4', '5', '0', 
	'5', '0', '0'
};

GLint SeriesA[10] = {
	318, 324, 315, 282, 157,
	219, 236, 184, 249, 446
};

GLint SeriesB[10] = {
	420, 342, 324, 310, 262,
	185, 190, 196, 217, 240
};

GLint SeriesC[10] = {
	210, 208, 218, 237, 267,
	272, 290, 350, 383, 422
};

void init(void) {
	// White display window
	glClearColor(1.0, 1.0, 1.0, 1.0);
	glMatrixMode(GL_PROJECTION);
	gluOrtho2D(0.0, 600.0, 0.0, 500.0);
}

void lineGraph(void) {
	GLint xScale, k;
	GLint yScale, i;


	// Initialize x position for the chart
	GLint x = 30;

	// clear the display window
	glClear(GL_COLOR_BUFFER_BIT);
	
	// set line color to blue
	glLineWidth(lineWidth);
	glColor3f(0.0, 0.0, 1.0);
	// plot points as a polyline
	glBegin(GL_LINE_STRIP);
		for (i = 0; i < 10; i++) {
			glVertex2i(x + i * 50, SeriesA[i]);
		}
	glEnd();

	// Set marker color to black
	glColor3f(0.0, 0.0, 0.0);
	// plot data as asterisk poly markers
	for (i = 0; i < 10; i++) {
		glRasterPos2i(xRaster + i * 50, SeriesA[i] -1);
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_12, '+');
	}

	// set line color to red
	glColor3f(1.0, 0.0, 0.0);
	// plot points as a polyline
	glBegin(GL_LINE_STRIP);
		for (i = 0; i < 10; i++) {
			glVertex2i(x + i * 50, SeriesB[i]);
		}
	glEnd();


	// Set marker color to black
	glColor3f(0.0, 0.0, 0.0);
	// plot data as asterisk poly markers
	for (i = 0; i < 10; i++) {
		glRasterPos2i(xRaster + i * 50, SeriesB[i] -1);
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_12, '+');
	}

	// set line color to green
	glColor3f(0.0, 1.0, 0.0);
	// plot points as a polyline
	glBegin(GL_LINE_STRIP);
		for (i = 0; i < 10; i++) {
			glVertex2i(x + i * 50, SeriesC[i]);
		}
	glEnd();

	// Set marker color to black
	glColor3f(0.0, 0.0, 0.0);
	// plot data as asterisk poly markers
	for (i = 0; i < 10; i++) {
		glRasterPos2i(xRaster + i * 50, SeriesC[i] -1);
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_12, '+');
	}

	
	// Set color for x axis labels
	glColor3f(0.0, 0.0, 0.0);
	// display the x axis lables

	for (xScale = 0; xScale < 10; xScale++) {
		glRasterPos2i(xRaster, yRaster - 140);
		for (k = 2 * xScale; k < 2 * xScale + 2; k++) {
			glutBitmapCharacter(GLUT_BITMAP_HELVETICA_12, Xlabel[k]);
		}
		xRaster += 50;
	}

	xRaster = 10, yRaster = 150;

	// Set color for y axis labels
	glColor3f(0.0, 0.0, 0.0);
	// display the y axis lables
	for (yScale = 0; yScale < 11; yScale++) {
		glRasterPos2i(xRaster, yRaster -125);
		for (i = 3 * yScale; i < 3 * yScale + 3; i++) {
			glutBitmapCharacter(GLUT_BITMAP_HELVETICA_12, Ylabel[i]);
		}
		yRaster += 45;
	}

	xRaster = 25, yRaster = 25;

	// Add y axis lines
	/*
	glLineWidth(.5);
	glColor3f(0.0, 0.0, 0.0);
	glRasterPos2i(xRaster, yRaster);
	glBegin(GL_LINES);
		for (i = 0; i < 11; i++) {
			glVertex2i(xRaster, yRaster);
			glVertex2i(xRaster + 475, yRaster);
			yRaster += 45;
		}
	glEnd();
	*/
	// displaying the legend
	char labelA[9] = "Series A";
	GLint labelx = 510;
	GLint labely = 200;

	glColor3f(0.0, 0.0, 1.0);
	glRasterPos2i(labelx + 45, labely);
	for (i = 0; i < 8; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, labelA[i]);
	}

	glBegin(GL_LINES);
		glVertex2i(labelx, labely);
		glVertex2i(labelx + 40, labely);
	glEnd();

	glColor3f(1.0, 0.0, 0.0);
	char labelB[9] = "Series B";
	glRasterPos2i(labelx + 45, labely -15);
	for (i = 0; i < 8; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, labelB[i]);
	}

	glBegin(GL_LINES);
		glVertex2i(labelx, labely - 15);
		glVertex2i(labelx + 40, labely - 15);
	glEnd();
	

	glColor3f(0.0, 1.0, 0.0);
	char labelC[9] = "Series C";
	glRasterPos2i(labelx + 45, labely - 30);
	for (i = 0; i < 8; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, labelC[i]);
	}

	glBegin(GL_LINES);
		glVertex2i(labelx, labely -30 );
		glVertex2i(labelx + 40, labely- 30);
	glEnd();

	// Set text color to black
	glColor3f(0.0, 0.0, 0.0);
	// display chart lables

	glFlush();
}

void reshape(GLint newWidth, GLint newheight) {
	// reset the window to original size after trying to resize it
	glutReshapeWindow(winWidth, winHeight);
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

void main(int argc, char** argv) {
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowPosition(100, 100);
	glutInitWindowSize(winWidth, winHeight);
	glutCreateWindow("Line Chart");

	init();


	cout << "Enter the width for the lines: ";
	cin >> lineWidth;

	glutDisplayFunc(lineGraph);
	glutReshapeFunc(reshape);

	glutMainLoop();
}