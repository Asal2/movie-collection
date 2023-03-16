/**

 * This class represents a TV series with a title and the number of episodes per
 * season
 */
public class TVSeries {
	private String title; // title of series
	private int[] numEpisodesInSeason; // number of episodes in each season
	
	/**
	 * Constructs a TV series object.
	 * @param title-
	 * 				the title of the series
	 * @param numEpisodesInSeason-
	 * 							  the number of episodes in each season
	 */
	public TVSeries(String title, int[] numEpisodesInSeason) {
		this.title = title;
		this.numEpisodesInSeason = numEpisodesInSeason;
	}
	
	/**
	 * Returns the title of the TV series
	 * @return the title of the TV series
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Returns the number of seasons in TV series
	 * @return the number of seasons in TV series
	 */
	public int getNumSeasons() {
		return numEpisodesInSeason.length;
	}
	
	/**
	 * Retrieves the number of episodes in a season.
	 * 
	 * @param seasonNumb - season number checks the number of season it has in a series.
	 * @return the number of episodes in a season.
	 */
	public int getNumEpisodesInSeason(int seasonNumb) {
		if (seasonNumb <= 0 || seasonNumb > this.getNumSeasons()) {
			throw new IllegalArgumentException("Season number invalid: " + seasonNumb);
		}
		return numEpisodesInSeason[seasonNumb - 1];
	}
	
	/**
	 * Returns a string description of all TV series in this TV series object
	 * 
	 * @return a  string description of all TV series in the TV series object
	 */
	public String toString() {
		String message = "";
		String msg = "";
		String finalMsg = "";
		message = "\"" + title + "\"" + " TV Series";
		for (int i = 0; i < this.getNumSeasons(); i++) {
			msg += "\n    Season " + (i+1) + " has " + numEpisodesInSeason[i] + " episodes.";
		}
		finalMsg = message + msg;
		return finalMsg;
	}
}

