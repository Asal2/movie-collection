/**
 * 
 * This class represents a one episode of a TV series with 
 * the series, the episode number, and the season number of this episode.
 *
 */
import java.util.Arrays;

public class Episode extends VideoItem{
	
	private static final String[] POSSIBLE_RATINGS = {"TV-14", "TV-G", "TV-MA", "TV-PG", "TV-R"}; // rating of each episodes
	
	private TVSeries series; //the TVSeries to which this episode belongs
	private int episodeNumber; //the number of episode
	private int seasonNumber; //the number of season
	
	/**
	 * 
	 * @param series - the series of TV series in this episode object
	 * @param rating - the rating of the episode
	 * @param length - the length of the episode
	 * @param seasonNumber - number of season in each series
	 * @param episodeNumber - number of episode in each season of the series
	 * @param title - the title of the series
	 * @param numDownloads - number of Downloads of each series of the season of the episode
	 * @param ranking = the average rank of the series from 0-10 from the response
	 * @param numResponses- the number of responses ranking the series.
	 */
	public Episode(TVSeries series, String rating, int length, int seasonNumber, int episodeNumber, String title, int numDownloads, double ranking, int numResponses) {
		super(title, rating, length, numDownloads, ranking, numResponses);
		
		this.series = series;
		if(seasonNumber <= 0 || seasonNumber > series.getNumSeasons()) {
			throw new IllegalArgumentException("Invalid season number: " + seasonNumber);
		}
		if(episodeNumber <= 0 || episodeNumber > series.getNumEpisodesInSeason(seasonNumber)) {
			throw new IllegalArgumentException("Invalid episode number: " + episodeNumber);
		}
		this.seasonNumber = seasonNumber;
		this.episodeNumber = episodeNumber;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Returns the number of episodes
	 * @return the number of episodes in each series
	 */
	public int getEpisodeNum() {
		return episodeNumber;
	}
	
	/**
	 * Returns the series
	 * @return the series.
	 */
	public TVSeries getSeries() {
		return series;
	}
	
	/**
	 * Returns the number of season
	 * @return the number of season in each series
	 */
	public int getSeason() {
		return seasonNumber;
	}
	
	/**
	 * Returns the number of episodes left in a season.
	 * @return the number of episodes left in a season.
	 */
	public int episodesLeftThisSeason() {
		return series.getNumEpisodesInSeason(seasonNumber) - getEpisodeNum(); 
	} 
	
	/**
	 * Returns a short string description of all TV series in this content object
	 * 
	 * @return a short string description of all TV series in the Content object
	 */
	public String toString() { 
		return ("\"" + series.getTitle() + "\""+" Season " + this.getSeason() +", Episode: " + this.getEpisodeNum());
	}
	
	/**
	 * Sets the Rating (TV-14, etc)for the TV series
	 * 	
	 * @param rating
	 * 		        - the rating to be stored.  		
	 */
	public void setRating(String rating) {
		boolean test = true;
		for(int i = 0; i < POSSIBLE_RATINGS.length - 1; i ++) {
			if(rating.equals(POSSIBLE_RATINGS[i])) {
				super.setRating(rating);
				test = false;
			}
			
		}
		if(test) {
			throw new IllegalArgumentException("Invalid rating: "+ rating);
		}
	}
	
	@Override // for getFullTitle, with title of series with its season and episode number.
	public String getFullTitle() {
		return this.toString() +", "+ super.getFullTitle();
	}
	
	@Override // for getFullTitle and getItemDetails, with title of series with its season and episode number with.
	public String getItemDetails() {
		String sms = "";
		sms += "\"" + series.getTitle() + "\"";
		sms += "\n" +" Season " + this.getSeason() +", Episode " + this.getEpisodeNum();
		sms += "\n" + super.getFullTitle();
		sms += "\n" + super.getItemDetails();
		return sms;
	}
	
	@Override // for download
	public String download() {
		super.download();
		if(episodesLeftThisSeason() > 0) {
			return episodesLeftThisSeason()+ " episodes left in this season.";	
		}else {
			return "No episodes left in this season.";
		}
	}
}
