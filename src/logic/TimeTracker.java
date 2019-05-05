package logic;

import java.time.Duration;
import java.time.Instant;

public class TimeTracker {

	protected Instant start;
	protected Instant stop;
	private long elapsedMillis;
	private String formattedTime;

	public void startTimer() {
		start = Instant.now();
	}

	// Ms fra start til nå. Timer fortsatt aktiv....
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
//		long sec = ms / 1000;
//		formattedTime = (String.format("%02d:%02d:%02d:%02d", sec / 3600, (sec % 3600) / 60, (sec % 60)));
		formattedTime = (String.format("%02d:%02d:%02d:%02d", ms / 3600000, (ms % 3600000) / 60000, (ms % 60000) / 1000,
				(ms % 1000)));
	}

	public String getElapsedMs() {
		return "" + elapsedMillis;
	}

	public String getFormattedTimeTot() {
		return formattedTime;
	}

//	public void test() {
//		this.startTimer();
//		try {
//			Thread.sleep(61035);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		this.stopTimer();
//
//		System.out.println("Time in ms: " + elapsedMillis);
//		System.out.println("Formatted time: " + formattedTime);
//	}

}
