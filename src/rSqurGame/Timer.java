package rSqurGame;

import java.util.concurrent.TimeUnit;
import java.util.*;

public class Timer {

	double timeSeconds;
	double timePreRound;
	double timeSecondsStart;
	double startTime;
	double centerToCorner;
	static double startTimer;
	
	public double TimerSeconds() {
		if(RedSquare.count == 0) {
			startTimer = TimeUnit.MILLISECONDS.toMillis(System.currentTimeMillis());
			RedSquare.count++;
		}
		timeSecondsStart = TimeUnit.MILLISECONDS.toMillis(System.currentTimeMillis());
		timePreRound = (timeSecondsStart - startTimer) / 1000;
		timeSeconds = Math.round(timePreRound * 10.0)/10.0;
		return timeSeconds;
	}
}
