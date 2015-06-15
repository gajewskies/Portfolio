#include <conio.h>
#include <time.h>

class timer {
public:
	timer();
	void           start();
	void           stop();
	void           reset();
	bool           isRunning();
	unsigned long  getTime();
	bool           isOver(unsigned long seconds);
private:
	bool           resetted;
	bool           running;
	unsigned long  beg;
	unsigned long  end;
};


timer::timer() {
	resetted = true;
	running = false;
	beg = 0;
	end = 0;
}


void timer::start() {
	if (!running) {
		if (resetted)
			beg = (unsigned long)clock();
		else
			beg -= end - (unsigned long)clock();
		running = true;
		resetted = false;
	}
}


void timer::stop() {
	if (running) {
		end = (unsigned long)clock();
		running = false;
	}
}


void timer::reset() {
	bool wereRunning = running;
	if (wereRunning)
		stop();
	resetted = true;
	beg = 0;
	end = 0;
	if (wereRunning)
		start();
}


bool timer::isRunning() {
	return running;
}


unsigned long timer::getTime() {
	if (running)
		return ((unsigned long)clock() - beg) / CLOCKS_PER_SEC;
	else
		return (end - beg) / CLOCKS_PER_SEC;
}


bool timer::isOver(unsigned long seconds) {
	return seconds >= getTime();
}
/*
int main() {
	bool quit = false;
	char choice;
	timer t;
	while (!quit) {
		cout << " s   start/stop " << endl;
		cout << " r   reset" << endl;
		cout << " v   view time" << endl;
		cout << " q   quit" << endl;
		cout << endl;
		choice = _getch();
		switch (choice) {
		case 's':
			if (t.isRunning()) {
				t.stop();
				cout << "stopped" << endl;
			}
			else {
				t.start();
				cout << "started" << endl;
			}
			break;
		case 'r':
			t.reset();
			cout << "resetted" << endl;
			break;
		case 'v':
			cout << "time = " << t.getTime() << " ms" << endl;
			break;
		case 'q':
			quit = true;
			break;
		}
		cout << "------------------------------" << endl;
	}

}
*/