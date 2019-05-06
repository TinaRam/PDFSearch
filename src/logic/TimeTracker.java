package logic;

import java.time.Duration;
import java.time.Instant;

public class TimeTracker {

	private Instant start;
	private Instant stop;
	private long elapsedMillis;
	private String formattedTime;

	public void startTimer() {
		start = Instant.now();
	}

	public long msFromStart() {
		return Duration.between(start, Instant.now()).toMillis();
	}

	public void stopTimer() {
		stop = Instant.now();
		this.elapsedMillis();
		this.formatElapsedTime(elapsedMillis);

		// Only for testing purposes
		System.out.println("Time in ms: " + elapsedMillis);
		System.out.println("Formatted time: " + formattedTime);
	}

	private void elapsedMillis() {
		elapsedMillis = Duration.between(start, stop).toMillis();
	}

	// Formaterer ms om til timer:min:sec lagres i egen varibel
	private void formatElapsedTime(long ms) {
		formattedTime = (String.format("%02d:%02d:%02d:%02d", ms / 3600000, (ms % 3600000) / 60000, (ms % 60000) / 1000,
				(ms % 1000)));
	}

	public String getElapsedMs() {
		return "" + elapsedMillis;
	}

	public String getFormattedTimeTot() {
		return formattedTime;
	}
}
