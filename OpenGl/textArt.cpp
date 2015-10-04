#include <glut.h>

void init2D(float r, float g, float b) {
	glClearColor(r, g, b, 0.0);
	glMatrixMode(GL_PROJECTION);
	gluOrtho2D(0.0, 200.0, 0.0, 200.0);
}

void display(void) {
	glClear(GL_COLOR_BUFFER_BIT);
	glColor3f(1.0, 0.0, 0.0);

	char name[15] = "TYLER GAJEWSKI";
	for (int i = 0; i < 14; i++) {
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, name[i]);
	}


	glBegin(GL_LINES);
	// Start F
	glVertex2d(10, 10);
	glVertex2d(10, 20);
	glVertex2d(20, 20);
	glVertex2d(10, 20);
	glVertex2d(10, 15);
	glVertex2d(15, 15);
	// End F

	// Start R
	glVertex2d(30,10);
	glVertex2d(30,20);
	glVertex2d(30,20);
	glVertex2d(40,18);
	glVertex2d(40,18);
	glVertex2d(30,14);
	glVertex2d(30,14);
	glVertex2d(40,10);
	// End R

	glEnd();

	glColor3f(0.0, 0.0, 1.0);
	glBegin(GL_LINES);

	// Start E
	glVertex2d(50, 10);
	glVertex2d(50, 20);
	glVertex2d(50, 20);
	glVertex2d(60, 20);
	glVertex2d(50, 15);
	glVertex2d(55, 15);
	glVertex2d(50, 10);
	glVertex2d(60, 10);
	// End E

	// Start D
	glVertex2d(70, 10);
	glVertex2d(70, 20);
	glVertex2d(70, 10);
	glVertex2d(80, 15);
	glVertex2d(70, 20);
	glVertex2d(80, 15);
	// End D

	glEnd();

	glColor3f(0.0, 1.0, 0.0);
	glBegin(GL_LINES);

	// Start O
	glVertex2d(90, 10);
	glVertex2d(90, 20);
	glVertex2d(90, 10);
	glVertex2d(100, 10);
	glVertex2d(100, 20);
	glVertex2d(100, 10);
	glVertex2d(90, 20);
	glVertex2d(100, 20);
	// End O


	// Start N
	glVertex2d(110, 10);
	glVertex2d(110, 20);
	glVertex2d(110, 20);
	glVertex2d(120, 10);
	glVertex2d(120, 10);
	glVertex2d(120, 20);
	// End N

	glEnd();

	glColor3f(1.0, 1.0, 1.0);
	glBegin(GL_LINES);

	// Start I
	glVertex2d(130, 10);
	glVertex2d(130, 20);
	// End I

	// Start A
	glVertex2d(140, 10);
	glVertex2d(145, 20);
	glVertex2d(145, 20);
	glVertex2d(150, 10);
	glVertex2d(142, 15);
	glVertex2d(148, 15);
	// End A

	glEnd();
	glFlush();
}

int main() {
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowSize(500, 500);
	glutInitWindowPosition(100,100);
	glutCreateWindow("Assignment 1 Draw Words");
	init2D(0.0, 0.75, 0.0);
	glutDisplayFunc(display);
	glutMainLoop();
}