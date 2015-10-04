#include <cstdlib>
#include <cmath>
#include <glut.h>

const GLdouble TWO_PI = 6.283185;

class scrPt {
	public:
		GLint x, y;	
};

// Initial window size
GLsizei winWidth = 400, winHeight = 300;

void init(void) {
	glClearColor(1.0, 1.0, 1.0, 1.0);
	glMatrixMode(GL_PROJECTION);
	gluOrtho2D(0.0, 200.0, 0.0, 150.0);

}

void setPixel(GLint x, GLint y){
	glBegin(GL_POINTS);
		glVertex2i(x, y);
	glEnd();
}

void circleMidpoint(scrPt circCtr, GLint radius) {
	scrPt circPt;
	// Initial value of midpoint parameter.
	GLint p = 1 - radius;         
	// Set coordinates for top point of circle.
	circPt.x = 0;             
	circPt.y = radius;

	void circlePlotPoints(scrPt, scrPt);

	/* Plot the initial point in each circle quadrant. */
	circlePlotPoints(circCtr, circPt);

	/* Calculate next points and plot in each octant. */
	while (circPt.x < circPt.y) {
		circPt.x++;
		if (p < 0)
			p += 2 * circPt.x + 1;
		else {
			circPt.y--;
			p += 2 * (circPt.x - circPt.y) + 1;
		}
		circlePlotPoints(circCtr, circPt);
	}
}

void circlePlotPoints(scrPt circCtr, scrPt circPt) {
	setPixel(circCtr.x + circPt.x, circCtr.y + circPt.y);
	setPixel(circCtr.x - circPt.x, circCtr.y + circPt.y);
	setPixel(circCtr.x + circPt.x, circCtr.y - circPt.y);
	setPixel(circCtr.x - circPt.x, circCtr.y - circPt.y);
	setPixel(circCtr.x + circPt.y, circCtr.y + circPt.x);
	setPixel(circCtr.x - circPt.y, circCtr.y + circPt.x);
	setPixel(circCtr.x + circPt.y, circCtr.y - circPt.x);
	setPixel(circCtr.x - circPt.y, circCtr.y - circPt.x);
}


void pieChart(void) {
	scrPt circCtr, piePt;
	// Circle radius
	GLint radius = winWidth / 4;

	GLdouble sliceAngle, previousSliceAngle = 0.0;

	// Number of slices
	GLint i, nSlices = 12;
	GLfloat dataValues[12] = {
		10.0,
		7.0,
		13.0,
		5.0,
		13.0,
		14.0,
		3.0,
		16.0,
		5.0,
		3.0,
		17.0,
		8.0
	};

	GLfloat dataSum = 0.0;

	// Circle center position
	circCtr.x = winWidth / 2;
	circCtr.y = winHeight / 2;
	// Call a midpoint circle plot routine
	circleMidpoint(circCtr, radius);

	for (i = 0; i < nSlices; i++) {
		dataSum += dataValues[i];
	}

	for (i = 0; i < nSlices; i++) {
		sliceAngle = TWO_PI * dataValues[i] / dataSum + previousSliceAngle;
		piePt.x = circCtr.x + radius * cos(sliceAngle);
		piePt.y = circCtr.y + radius * sin(sliceAngle);
		glBegin(GL_LINES);
			glVertex2i(circCtr.x, circCtr.y);
			glVertex2i(piePt.x, piePt.y);
		glEnd();
		previousSliceAngle = sliceAngle;
	}

}

void displayFunc(void) {
	glClear(GL_COLOR_BUFFER_BIT);
	glColor3f(0.0, 0.0, 1.0);
	pieChart();
	glFlush();
}

void winReshapeFunc(GLint newWidth, GLint newHeight) {
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluOrtho2D(0.0, GLdouble(newWidth), 0.0, GLdouble(newHeight));
	glClear(GL_COLOR_BUFFER_BIT);
	
	/*
	Reset display window sixe parameters
	*/
	winWidth = newWidth;
	winHeight = newHeight;
}

void main(int argc, char** argv) {
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowPosition(100, 100);
	glutInitWindowSize(winWidth, winHeight);
	glutCreateWindow("Pie Chart");
	glutDisplayFunc(displayFunc);
	glutReshapeFunc(winReshapeFunc);
	glutMainLoop();
}