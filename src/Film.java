/**
 * 
 * This class represents a film.
 * 
 *
 */

public abstract class Film extends VideoItem {

	private static final String[] POSSIBLE_RATINGS = { "G", "NC-17", "PG", "PG-13", "R" }; //  rating of each film
	private static final String FIRST_RELEASE_YEAR = "1906"; // first film released

	private String releaseYear; //the year the movie was released

	/**
	 * Constructs a film object
	 * 
	 * @param title-       the title of this film
	 * @param releaseYear  - the year this film was released
	 * @param rating       - this film's rating (ie. G, R,...)
	 * @param length       - the length of this film in minutes
	 * @param numDownloads - the number of times this film has been downloaded
	 * @param ranking      - the average ranking (1..10) of this film from the
	 *                     responses
	 * @param numResponses - the number of responses ranking this film
	 */
	public Film(String title, String releaseYear, String rating, int length, int numDownloads, double ranking,
			int numResponses) {
		super(title, rating, length, numDownloads, ranking, numResponses);
		setRating(rating);
		setReleaseYear(releaseYear);

		// TODO Auto-generated constructor stub
	}

	@Override   // for setRating
	public void setRating(String rating) {
		boolean test = true;
		for (int i = 0; i < POSSIBLE_RATINGS.length; i++) {
			if (rating.equals(POSSIBLE_RATINGS[i])) {
				super.setRating(rating);
				test = false;
			}

		}
		if (test) {
			throw new IllegalArgumentException("Invalid rating: " + rating);
		}
	}

	/**
	 * sets the year this film was released to the year received ("1906" and later)
	 * 
	 * @param releaseYear - the year this film was released
	 */
	public void setReleaseYear(String releaseYear) {
		if (releaseYear.matches("[0-9]+") && Integer.parseInt(releaseYear) >= Integer.parseInt(FIRST_RELEASE_YEAR)) {
			this.releaseYear = releaseYear;
		} else {
			throw new IllegalArgumentException("Invalid release year: " + releaseYear);
		}
	}

	@Override // for getItemDetails
	public String getItemDetails() {
		String sms = "";
		sms += releaseYear;
		sms += "\n" + super.getItemDetails();
		return sms;
	}

	@Override // for toString
	public String toString() {
		return super.getFullTitle();
	}
}
