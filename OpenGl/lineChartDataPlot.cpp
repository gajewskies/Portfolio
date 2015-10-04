#include <cstdlib>
#include <glut.h>

// Initial display window size
GLsizei winWidth = 600, winHeight = 500;
// Initial raster position
GLint xRaster = 25, yRaster = 150;

GLubyte label[36] = {
	'J', 'a', 'n',
	'F', 'e', 'b',
	'M', 'a', 'r',
	'A', 'p', 'r',
	'M', 'a', 'y',
	'J', 'u', 'n',
	'J', 'u', 'l',
	'A', 'u', 'g',
	'S', 'e', 'p',
	'O', 'c', 't',
	'N', 'o', 'v',
	'D', 'e', 'c'
};

GLint dataValue[12] = {
	420,
	342,
	324,
	310,
	262,
	185,
	190,
	196,
	217,
	240,
	312,
	438
};

void init(void) {
	// White display window
	glClearColor(1.0, 1.0, 1.0, 1.0);
	glMatrixMode(GL_PROJECTION);
	gluOrtho2D(0.0, 600.0, 0.0, 500.0);
}

void barChart(void) {
	GLint month, i;

	glClear(GL_COLOR_BUFFER_BIT);
	glColor3f(1.0, 0.0, 0.0);
	for (i = 0; i < 12; i++) {
		glRecti(20 + i * 50, 165, 40 + i * 50, dataValue[i]);
	}
	glColor3f(0.0, 0.0, 0.0);
	xRaster = 20;
	for (month = 0; month < 12; month++) {
		glRasterPos2i(xRaster, yRaster);
		for (i = 3 * month; i < 3 * month + 3; i++) {
			glutBitmapCharacter(GLUT_BITMAP_HELVETICA_12, label[i]);
		}
		xRaster += 50;
	}
	glFlush();
}

void lineGraph(void) {
	GLint month, i;
	// Initialize x position for the chart
	GLint x = 30;

	// clear the display window
	glClear(GL_COLOR_BUFFER_BIT);
	// set line color to blue
	glColor3f(0.0, 0.0, 1.0);

	// plot points as a polyline
	glBegin(GL_LINE_STRIP);
		for (i = 0; i < 12; i++) {
			glVertex2i(x + i * 50, dataValue[i]);
		}
	glEnd();

	// Set marker color to red
	glColor3f(1.0, 0.0, 0.0);
	// plot data as asterisk poly markers
	for (i = 0; i < 12; i++) {
		glRasterPos2i(xRaster + i * 50, dataValue[i]);
		glutBitmapCharacter(GLUT_BITMAP_9_BY_15, '*');
	}

	// Set text color to black
	glColor3f(0.0, 0.0, 0.0);
	// display chart lables
	xRaster = 20;
	for (month = 0; month < 12; month++) {
		glRasterPos2i(xRaster, yRaster);
		for (i = 3 * month; i < 3 * month + 3; i++) {
			glutBitmapCharacter(GLUT_BITMAP_HELVETICA_12, label[i]);
		}
		xRaster += 50;
	}
	glFlush();
}

void winReshapeFunc(GLint newWidth, GLint newHeight) {
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluOrtho2D(0.0, GLdouble(newWidth), 0.0, GLdouble(newHeight));
	glClear(GL_COLOR_BUFFER_BIT);
}

void main(int argc, char** argv) {
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowPosition(100, 100);
	glutInitWindowSize(winWidth, winHeight);
	glutCreateWindow("Line Chart Data Plot");

	init();
	//glutDisplayFunc(lineGraph);
	glutDisplayFunc(barChart);
	glutReshapeFunc(winReshapeFunc);

	glutMainLoop();
}