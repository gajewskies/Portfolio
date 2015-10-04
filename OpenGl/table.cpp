#include <cstdio>
#include <glut.h>

using namespace std;

void init(float r, float g, float b) {
	glClearColor(r, g, b, 1.0);
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	gluOrtho2D(-1, 1, -1, 1);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
}

void booksRow_one() {
//4 ==> Done

	glColor3f(1.0, 0.0, 0.0);
	glBegin(GL_QUADS); 
		glVertex2f(-.07, -.4);
		glVertex2f(-.07, -.4999);
		glVertex2f(-.245, -.4999);
		glVertex2f(-.245, -.4);
	glEnd();

	glColor3f(1.0 ,1.0, 1.0);
	glBegin(GL_QUADS);
		glVertex2f(-.05, -.3);
		glVertex2f(-.05, -.4);
		glVertex2f(-.3, -.4);
		glVertex2f(-.3, -.3);
	glEnd();

	glColor3f(0.4, 0.2, 0.78);
	glBegin(GL_QUADS);
		glVertex2f(-.1, -.26);
		glVertex2f(-.1, -.3);
		glVertex2f(-.3, -.3);
		glVertex2f(-.3, -.26);
	glEnd();

	glColor3f(0.0, 0.0, 1.0);
	glBegin(GL_QUADS);
		glVertex2f(-.08, -.2);
		glVertex2f(-.08, -.26);
		glVertex2f(-.23, -.26);
		glVertex2f(-.23, -.2);
	glEnd();
}

void booksRow_two() {
//0 + 1 = 1 ==> Done
	glColor3f(1.0, 0.0, 1.0);
	glBegin(GL_QUADS);
		glVertex2f(-.04, -.22);
		glVertex2f(-.04, -.4999);
		glVertex2f(0, -.4999);
		glVertex2f(0, -.22);
	glEnd();

}

void booksRow_three() {
//5 ==> Done
	glColor3f(0.0, 1.0, 1.0);
	glBegin(GL_QUADS);
		glVertex2f(.2, -.4);
		glVertex2f(.2, -.4999);
		glVertex2f(.04, -.4999);
		glVertex2f(.04, -.4);
	glEnd();

	glColor3f(1.0, 0.0, 1.0);
	glBegin(GL_QUADS);
		glVertex2f(.19, -.3);
		glVertex2f(.19, -.4);
		glVertex2f(.03, -.4);
		glVertex2f(.03, -.3);
	glEnd();

	glColor3f(0.0, 0.0, 0.0);
	glBegin(GL_QUADS);
		glVertex2f(.2, -.2);
		glVertex2f(.2, -.3);
		glVertex2f(.04, -.3);
		glVertex2f(.04, -.2);
	glEnd();

	glColor3f(0.4, 1.0, 0.0);
	glBegin(GL_QUADS);
		glVertex2f(.17, -.16);
		glVertex2f(.17, -.2);
		glVertex2f(.1, -.2);
		glVertex2f(.1, -.16);
	glEnd();

	glColor3f(1.0, 1.0, 1.0);
	glBegin(GL_QUADS);
		glVertex2f(.18, -.1);
		glVertex2f(.18, -.16);
		glVertex2f(.079, -.16);
		glVertex2f(.079, -.1);
	glEnd();
}

void booksRow_four() {
// 4 ==> Done
	glColor3f(1.0, 0.0, 1.0);
	glBegin(GL_QUADS);
		glVertex2f(.475, -.4);
		glVertex2f(.475, -.4999);
		glVertex2f(.3, -.4999);
		glVertex2f(.3, -.4);
	glEnd();

	glColor3f(1.0, 1.0, 1.0);
	glBegin(GL_QUADS);
		glVertex2f(.473, -.3);
		glVertex2f(.473, -.4);
		glVertex2f(.31, -.4);
		glVertex2f(.31, -.3);
	glEnd();

	glColor3f(0.0, 1.0, 1.0);
	glBegin(GL_QUADS);
		glVertex2f(.5, -.26);
		glVertex2f(.5, -.3);
		glVertex2f(.26, -.3);
		glVertex2f(.26, -.26);
	glEnd();

	glColor3f(0.4, 0.2, 0.0);
	glBegin(GL_QUADS);
		glVertex2f(.475, -.2);
		glVertex2f(.475, -.26);
		glVertex2f(.33, -.26);
		glVertex2f(.33, -.2);
	glEnd();
}

void booksRow_five() {
// 7 ==> Done
	glColor3f(0.5, 0.0, 1.0);
	glBegin(GL_QUADS);
		glVertex2f(-.1, -.17);
		glVertex2f(-.1, -.2);
		glVertex2f(.075, -.2);
		glVertex2f(.075, -.17);
	glEnd();

	glColor3f(0.0, 1.0, 1.0);
	glBegin(GL_QUADS);
		glVertex2f(-.11, -.12);
		glVertex2f(-.11, -.17);
		glVertex2f(0.08, -.17);
		glVertex2f(0.08, -.12);
	glEnd();

	glColor3f(0.0, 0.0, 1.0);
	glBegin(GL_QUADS);
		glVertex2f(-.15, -.07);
		glVertex2f(-.15, -.12);
		glVertex2f(.05, -.12);
		glVertex2f(.05, -.07);
	glEnd();

	glColor3f(0.4, 0.2, 0.0);
	glBegin(GL_QUADS);
		glVertex2f(-.09, 0);
		glVertex2f(-.09, -.07);
		glVertex2f(.02, -.07);
		glVertex2f(.02, 0);
	glEnd();

	glColor3f(0.4, 0.2, 1.0);
	glBegin(GL_QUADS);
		glVertex2f(-.15, .04);
		glVertex2f(-.15, 0);
		glVertex2f(.05, 0);
		glVertex2f(.05, .04);
	glEnd();

	glColor3f(0.4, 1.0, 1.0);
	glBegin(GL_QUADS);
		glVertex2f(-.15, .06);
		glVertex2f(-.15, .04);
		glVertex2f(.05, .04);
		glVertex2f(.05, .06);
	glEnd();

	glColor3f(0.4, 0.7, 0.1);
	glBegin(GL_QUADS);
		glVertex2f(-.17, .1);
		glVertex2f(-.17, .06);
		glVertex2f(.05, .06);
		glVertex2f(.05, .1);
	glEnd();
}

void bookNames_row1() {
	glColor3f(0.0, 0.0, 0.0);
	glRasterPos2f(-.245, -.4999);
	char book1[4] = "C++";
	for (int i = 0; i < 3; i++) {
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, book1[i]);
	}

	glColor3f(0.0, 0.0, 0.0);
	glRasterPos2f(-.3, -.3);
	char book2[3] = "C#";
	for (int i = 0; i < 2; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_10, book2[i]);
	}

	glColor3f(0.0, 0.0, 0.0);
	glRasterPos2f(-.3, -.4);
	char book3[6] = "Basic";
	for (int i = 0; i < 5; i++) {
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, book3[i]);
	}

	glColor3f(0.0, 0.0, 0.0);
	glRasterPos2f(-.23, -.26);
	char book4[5] = "Java";
	for (int i = 0; i < 4; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, book4[i]);
	}
}

void bookNames_row2() {
	glColor3f(0.0, 0.0, 0.0);
	glRasterPos2f(-.04, -.4999);
	char book1[2] = "A";
	for (int i = 0; i < 1; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, book1[i]);
	}

	glRasterPos2f(-.04, -.43);
	char book2[2] = "S";
	for (int i = 0; i < 1; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, book2[i]);
	}

	glRasterPos2f(-.04, -.36);
	char book3[2] = "F";
	for (int i = 0; i < 1; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, book3[i]);
	}
}

void bookNames_row3() {
	glColor3f(0.0, 0.0, 0.0);
	glRasterPos2f(.04, -.4999);
	char book1[7] = "Visual";
	for (int i = 0; i < 6; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, book1[i]);
	}

	glColor3f(0.0, 0.0, 0.0);
	glRasterPos2f(.03, -.4);
	char book2[9] = "Graphics";
	for (int i = 0; i < 8; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, book2[i]);
	}

	glColor3f(1.0, 1.0, 1.0);
	glRasterPos2f(.04, -.3);
	char book3[7] = "NodeJS";
	for (int i = 0; i < 6; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, book3[i]);
	}

	glColor3f(0.0, 0.0, 0.0);
	glRasterPos2f(.1, -.2);
	char book4[3] = "JS";
	for (int i = 0; i < 2; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_10, book4[i]);
	}

	glColor3f(0.0, 0.0, 0.0);
	glRasterPos2f(.079, -.16);
	char book5[2] = "C";
	for (int i = 0; i < 1; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, book5[i]);
	}
}

void bookNames_row4() {
	glColor3f(0.0, 0.0, 0.0);
	glRasterPos2f(.3, -.4999);
	char book1[6] = "Linux";
	for (int i = 0; i < 5; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, book1[i]);
	}

	glColor3f(0.0, 0.0, 0.0);
	glRasterPos2f(.31, -.4);
	char book2[6] = "MacOS";
	for (int i = 0; i < 5; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, book2[i]);
	}

	glColor3f(0.0, 0.0, 0.0);
	glRasterPos2f(.26, -.3);
	char book3[8] = "Windows";
	for (int i = 0; i < 7; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_12, book3[i]);
	}

	glColor3f(0.0, 0.0, 0.0);
	glRasterPos2f(.33, -.26);
	char book4[8] = "Fortran";
	for (int i = 0; i < 7; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_18, book4[i]);
	}

}

void bookNames_row5() {
	glColor3f(0.0, 0.0, 0.0);
	glRasterPos2f(-.1, -.2);
	char book1[9] = "Hardware";
	for (int i = 0; i < 8; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_12, book1[i]);
	}

	glColor3f(0.0, 0.0, 0.0);
	glRasterPos2f(-.11, -.17);
	char book2[9] = "Software";
	for (int i = 0; i < 8; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_12, book2[i]);
	}

	glColor3f(0.0, 0.0, 0.0);
	glRasterPos2f(-.15, -.12);
	char book3[8] = "Systems";
	for (int i = 0; i < 7; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_12, book3[i]);
	}

	glColor3f(0.0, 0.0, 0.0);
	glRasterPos2f(-.09, -.07);
	char book4[9] = "National";
	for (int i = 0; i < 8; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_12, book4[i]);
	}

	glColor3f(0.0, 0.0, 0.0);
	glRasterPos2f(-.15, 0);
	char book5[] = "Offroad";
	for (int i = 0; i < 7; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_12, book5[i]);
	}

	glColor3f(0.0, 0.0, 0.0);
	glRasterPos2f(-.15, .04);
	char book6[5] = "Cars";
	for (int i = 0; i < 4; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_10, book6[i]);
	}

	glColor3f(0.0, 0.0, 0.0);
	glRasterPos2f(-.17, .06);
	char book7[6] = "Bikes";
	for (int i = 0; i < 5; i++) {
		glutBitmapCharacter(GLUT_BITMAP_HELVETICA_12, book7[i]);
	}

}

void table() {
	glColor3f(0.1, 0.1, 0.1);
	glBegin(GL_QUADS);
		glVertex2f(-.5, -.5);	//top left
		glVertex2f(-.5, -.75);	//bottom left
		glVertex2f(.5, -.75);	//bottom right
		glVertex2f(.5, -.5);	//top right
	glEnd();

	glColor3f(0.0, 0.8, 0.3);
	glBegin(GL_QUADS);
		glVertex2f(-.475, -.55);	//top left
		glVertex2f(-.475, -.7);		//bottom left
		glVertex2f(.475, -.7);		//bottom right
		glVertex2f(.475, -.55);		//top right
	glEnd();

	glColor3f(0.0, 0.0, 0.0);
	glBegin(GL_QUADS);
		glVertex2f(-.3, -.7);		//top left
		glVertex2f(-.3, -1);		//bottom left
		glVertex2f(-.2, -1);		//bottom right
		glVertex2f(-.2, -.7);		//top right
	glEnd();

	glBegin(GL_QUADS);
		glVertex2f(.3, -.7);		//top left
		glVertex2f(.3, -1);			//bottom left
		glVertex2f(.2, -1);			//bottom right
		glVertex2f(.2, -.7);		//top right
	glEnd();

}

void display() {
	glClear(GL_COLOR_BUFFER_BIT);
	
	char name[15] = "TYLER GAJEWSKI";
	for (int i = 0; i < 14; i++) {
		glutBitmapCharacter(GLUT_BITMAP_TIMES_ROMAN_24, name[i]);
	}

	table();
	booksRow_one();
	booksRow_two();
	booksRow_three();
	booksRow_four();
	booksRow_five();
	bookNames_row1();
	bookNames_row2();
	bookNames_row3();
	bookNames_row4();
	bookNames_row5();

	glFlush();
}

void reshape(GLint newWidth, GLint newHeight) {
	glutReshapeWindow(1000, 500);
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
	glutInit(&argc, argv);
	int width = 1000;
	int height = 500;
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);
	glutInitWindowSize(width, height);
	glutInitWindowPosition((glutGet(GLUT_SCREEN_WIDTH) - width) / 2, (glutGet(GLUT_SCREEN_HEIGHT) - height) / 2);
	glutCreateWindow("Table with books");

	init(0.2, 0.2, 0.2);

	glutDisplayFunc(display);
	glutReshapeFunc(reshape);

	errorCheck();

	glutMainLoop();
}