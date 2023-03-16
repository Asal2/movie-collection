/**
  
 * This class represents a movie (ie. a fiction feature film)
 * 
 *
 */
import java.util.Arrays;

public class Movie extends Film{
	// Possible genres of movie
	private static final String[] POSSIBLE_GENRES = {"Action & Adventure", "Animation", "Comedy", "Drama", "Fantasy", "Romantic Comedy", "Science-Fiction", "Thrillers"};
	
	private String genre;// the genre of the movie
	
	

	/**
	 * Constructs a Movie object
	 * @param title - the title of this movie
	 * @param releaseYear - the year this movie was released
	 * @param genre - the genre of this movie (Animation, Comedy, ...)
	 * @param rating - the rating of this movie (G, R, ...)
	 * @param length - the length of this movie in minutes
	 * @param numDownloads - the number of times this movie has been downloaded
	 * @param ranking - the average ranking (1..10) of this movie from the responses
	 * @param numResponses - the number of responses ranking this movie
	 */
	public Movie(String title, String releaseYear, String genre, String rating, int length, int numDownloads, double ranking,
			int numResponses) {
		super(title, releaseYear, rating, length, numDownloads, ranking, numResponses);
		setGenre(genre);
		// TODO Auto-generated constructor stub
	}

	/**
	 * sets the genre of this movie to the genre received
	 * @param genre - the genre for this movie (Animation, Comedy, ...)
	 */
	public void setGenre(String genre) {
		boolean test = true;
		for(int i = 0; i < POSSIBLE_GENRES.length; i++) {
			if(genre.equals(POSSIBLE_GENRES[i])) {
				this.genre = genre;
				test = false;
			}
		}
		if(test) {
			throw new IllegalArgumentException("Invalid genre: " + genre);
		}
	}
	
	@Override  // for getItemDetails
	public String getItemDetails() {
		String sms = "";
		sms += super.getFullTitle();
		sms += "\n" + genre;
		sms += "\n" + super.getItemDetails();
		return sms;
	}
	
}

