#include <cstdlib>
#include <cmath>

/*
Bresenham Line-Drawing procedure for |m| < 1.0.
*/
void LineBres(int x0, int y0, int xEnd, int yEnd) {
	int dx = fabs(xEnd - x0);
	int dy = fabs(yEnd - y0);
	int twoDy = 2 * dy;
	int twoDyMinuesDx = 2 * (dy - dx);
	int x;
	int y;

	/*
	Determine which endpoint to use as the start position
	*/
	if (x0 > xEnd) {
		x = xEnd;
		y = yEnd;
		xEnd = x0;
	}
	else {
		x = x0;
		y = y0;
	}
	setPixel(x, y);

	while (x < xEnd) {
		x++;
		if (p < 0)
			p += twoDy;
		else {
			y++;
			p += twoDyMinuesDx;
		}
		setPixel(x, y);
	}

}