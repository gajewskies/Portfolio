/*
This is program to move a robotic cart/laser around ideally a 200 meter track
The distance can be set and the pace can be set
Runners can use the pacer bot to track where they should be in their runs
It can be used for splits
This eliminates the use of human timers and the athlete will know if they are
going to fast or too slow

The track would need to be set up with a laser or track mounted robot with motors
that can move at most 28 miles per hour; which is the fastest any human has run before
ideally the laser would be moving around 15-18mph

The laser would need to be securly mounted to the track 

Another option would be to hang the laser from above but that would cost more money
and set up;

another option would be to simulate the laser moving around a track and when the simulation
gets to 100 meters left the laser would start to move and be at the inputted pace
thus eliminating the need for a large amount of track.

The simulation could be playing on a smart phone showing where the laser/cart is on the track
and then when the simulation meets up with the physical cart the cart begins to move

Thiswould however be difficult for a runner pacing out a large ditance such as a 400
as the runner would only know the pace of the last 100

on the other hand the the runner would see the laser a head of them and be able
to push in a good kick to the finish line

Ideally this laser would be controlled by a smart phone.
the operator would input the distance and the pace time and then hit start to simulate
the race and then at the last 100m move the laser

The laser would then need to reset itself back to the starting line

Ideallt the laser would project the laser mark on the track but in a 
lighted area that may be difficult

so for a lighted area a cart with a bright red circle that can be viible at speeds

research a program where you input the speed or maybe pace and distance and a track is displayed with the pacer
moving around the track eactly like on the bikes in the upstairs weight room


Author: Tyler Gajewski
Date: 4/10/2015
Verison 0.0.1
*/

#include <iostream>
#include <iomanip>
#include <windows.h>
#include <string>

using namespace std;

char* color(int color = 7, char* Message = ""){
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), color);
	return Message;
}

int convertMin() {
	/*
	figure out the calculation to convert minutes to seconds
	maybe is user inputs 110 for 1 minute nd sixty seconds split off the 10 and then multiply the 100 by 60
	then add the 10 to the new total?
	*/
	int minutes;
	double seconds;
	cout << "Minutes (without colon): ";
	cin >> minutes;
	seconds = minutes * 60;
	cout << minutes << " = " << seconds << "s" << endl;
	return 0;
}

int calculator(void) {
	double pace;
	int distance;
	double MS;
	double MPH;
	double conversion = 2.236936;
	double time;
	int milisecond = 1000;
	char choice;
	string seperator = "========================\n";


	while (true) {
		// Get the distance from the operator
		cout << "Convert minutes to seconds? (y/n): ";
		cin >> choice;
		if (choice == 'y')
			convertMin();
		cout << seperator;
		cout << "Distance: ";
		cin >> distance;
		// Get the pace time from the operator
		cout << "Pace time: ";
		cin >> pace;

		if (pace > 0 && distance > 0) {
			// calculate the speed to move the cart at in M/S
			MS = distance / pace;
			
			//display the MS
			if (MS > 10)
				cout << setprecision(4) << MS << "m/s" << endl;
			else
				cout << setprecision(3) << MS << "m/s" << endl;

			// calculate the speed to move the cart at in MPH
			MPH = MS * conversion;

			/*
			Now when the cart get the the calculated time to move distance - 100 move the phsical cart
			Have program wait the calulated time and in this case for right now
			cout << MOVE CART
			#include <windows.h>

			Sleep(number of milliseconds);
			conversion from seconds into millesecond is
			1 second = 1000 milisecond
			seconds * 1000
			*/

			
			//display the MPH
			if (MPH > 10)
				cout << setprecision(4) << MPH << "mph" << endl;
			else
				cout << setprecision(3) << MPH << "mph" << endl;

			// calculate the split time for the user
			cout << "Split " << distance / 2 << "m in " << pace / 2 << "s" << endl;

			/*
			+Figure out the calculation for the cart to simulate the race
			+up until the 100m mark then move the cart
			+for example:
			+the distance is 400 meters, the cart would simulate 300m then move 100m
			+so take the distance and the pace to convert the speed
			+speed = speed * conversion
			+subtract 100 from the distance and calculate the time for the cart moving at the
			+calculated speed to move distance - 100;
			+time = distance -100/speed
			+distance - 100;
			*/

			time = (distance - 100) / MS;
			cout << "Time to move " << distance - 100 << "m is " << time << "s" << endl;
			//simulate the first distance - 100 meters of the race
			cout << "WAIT TIME: " << time << "s" << endl;
			Sleep(time * milisecond);
			cout << "<---START THE CART--->" << endl;
			time = (distance - (distance - 100)) / MS;
			cout << "Moving cart 100m in " << time << "s" << endl;
			//move the car at the calculated mph or m/s
			Sleep(time * milisecond);
			cout << "<--PACING OVER-->" << endl;
		}
		else
			cout << color(4, "ERROR: Distance and pace must be greater then 0") << endl;
		color();
	}
	return 0;
}

int main(void) {
	calculator();
}
