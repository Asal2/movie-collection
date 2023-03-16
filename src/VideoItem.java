/**

 * 
 * Represents a video content item for on-line downloading.
 * Includes attributes common to movies and TV-episodes
 */

public abstract class VideoItem {

	// maximum ranking value
	public final static int MAX_RANKING = 10;

	private String title;
	private int lengthMin;
	private String rating; // "R", "G", etc for films, "TV-14", "TV-MA" for episodes of TV series
	private int numDownloads;
	private double ranking;
	private int numResponses;

	/**
	 * Constructs a video item object. 
	 * @param title-
	 *            the title of this video item
	 * @param rating-
	 *            the rating (R, TV-13, etc) of this video item
	 * @param length-
	 *            the length of this video item in minutes
	 * @param numDownloads-
	 *            the number of times this video item has been downloaded
	 * @param ranking-
	 *            the average rank of the item 0-10 from the responses
	 * @param numResponses-
	 *            the number of responses ranking this video item
	 */
	public VideoItem(String title, String rating, int length, int numDownloads, double ranking, int numResponses) {

		this.title = title;
		setRating(rating);
		this.lengthMin = length;
		this.numDownloads = numDownloads;
		setRanking(ranking,numResponses);
	}

	/**
	 * Returns the title of this video item
	 * @return the title of this video item
	 */
	public String getTitle() {
		return title ;
	}

	/**
	 * Returns the rating (PG, etc.) for this video item
	 * @return the rating for this video item
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * Returns the "full" title of this video item, including the series if a TV series
	 *         episode, surrounded by quotes
	 * @return the "full" title of this video item
	 */
	public String getFullTitle() {
		String str = "\"" + title + "\"";
		return str;
	}
	
	/**
	 * Returns the details of this video item excluding the title
	 * @return the details of this video item excluding the title
	 */
	public String getItemDetails() {
		String text = "";
		text += getRankingString();
		text += "\n    rated: " + rating;
		text += "\n    length: " + lengthMin;
		text += "\n    downloads: " + numDownloads;
		return text;
	}

	/**
	 * Returns the ranking of this video 0-10 to the nearest tenth
	 * @return the ranking of this video item
	 */
	public double getRanking() {
		double rank = Math.round(ranking * 10) / 10.0;
		return rank;
	}

	/**
	 * Returns the length of this video in minutes
	 * @return the length of this video item in minutes
	 */
	public int getLengthMin() {
		return lengthMin;
	}

	/**
	 * Returns the number of times this video item has been downloaded
	 * @return the number of times downloaded
	 */
	public int getNumDownloads() {
		return numDownloads;
	}

	/**
	 * Increments the downloads counter of this video item
	 */
	public String download() {
		numDownloads++;
		return null;
	}

	/**
	 * Returns a string of * equivalent to the rank (to the nearest whole
	 *         number) followed by the rank out of MAX_RANKING. For example,
	 *         ***      (3/10)
	 * @return a string of * equivalent to the rank (to the nearest whole
	 *         number) followed by the rank out of MAX_RANKING
	 */
	public String getRankingString() {
		String message = "";
		String msg = "";
		
		int currentrank = (int) Math.round(getRanking());
		for(int a = 0; a < currentrank ; a++) {
			message += "*";
		}
		for (int i = currentrank ; i < MAX_RANKING; i++ ) {
			message += " ";
		}
		msg = String.format("%s(%d/%d) based on %d responses ", message, Math.round(getRanking()), MAX_RANKING, numResponses);
		
		return msg;
	}
	
	

	/**
	 * Sets the rating (PG, etc) for this video item
	 * 
	 * @param rating
	 *            - the rating to be stored for this video item
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	/**
	 * Sets the rank and number of responses creating that rank
	 * 
	 * @param rank
	 *            - the ranking of this video item, 0..10
	 * @param numResponses
	 *            - the number of times this video item has been ranked, must be positive
	 */
	public void setRanking(double rank, int numResponses){
		if(rank < 0 || rank > MAX_RANKING) {
			throw new IllegalArgumentException("Invalid ranking: " + rank);
		}
		if(numResponses <= 0) {
			throw new IllegalArgumentException("Invalid number of responses: " + numResponses);
		}
		ranking = rank;
		this.numResponses = numResponses;
		
	}

	
	/**
	 * Updates the ranking for this video item to include this new rank if the
	 * new rank data is valid
	 * 
	 * @param newRank
	 *            - another rank to be included in this video item's rank, 0..10
	 */
	public void processAnotherRanking(int newRank) {
		if(newRank < 0 || newRank > MAX_RANKING) {
			throw new IllegalArgumentException("Invalid ranking: " + newRank);
		}else {
			this.ranking = (this.ranking * this.numResponses + newRank) / (numResponses+1);
			numResponses++;
		}
	}
	

	@Override
	public String toString() {
		String str = "\"" + title + "\" ranking " + getRanking();
		return str;
	}

}
