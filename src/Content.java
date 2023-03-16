
/**

 * 
 * Content.java implements a collection of VideoItems for on-line posting.
 * It provides methods to search for a video item given a phrase in its title and to
 * find the top-ranked item.
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Content {

	private String name; // the name of the content
	private ArrayList<VideoItem> items; // the items

	/**
	 * Creates a content object with the given name and list of items
	 * 
	 * @param name-the  name of this content collection
	 * @param items-the list of video items in this content collection
	 */
	public Content(String name, ArrayList<VideoItem> items) {
		this.name = name;
		this.items = items;
	}

	/**
	 * Returns a short string description of all video items in this content object
	 * 
	 * @return a short string description of all video items in the Content object
	 */
	public String toString() {
		String result = "";
		for (int i = 0; i < items.size(); i++) {
			result += items.get(i).toString() + "\n";
		}
		return result;
	}

	/**
	 * Returns a list of all of the video items
	 * 
	 * @return an list of all of the video items
	 */
	public ArrayList<VideoItem> getItems() {
		return items;
	}

	/**
	 * Returns the name of the collection of video items
	 * 
	 * @return the name of the collection of video items
	 */
	public String getName() {
		return name;
	}

	/**
	 * searches for a video item with a title that contains the identified search
	 * phrase
	 * 
	 * @param searchPhrase - the phrase which is being searched for
	 * @return the first video item with the searchPhrase in its title
	 */
	public VideoItem findVideoItem(String searchPhrase) {
		for (int i = 0; i < items.size(); i++) {
			
			if (items.get(i).getTitle().toLowerCase().contains(searchPhrase.toLowerCase())) { 
				return items.get(i);
			}
		}
		
			return null;
	}

	/**
	 * finds the video item with the highest rank
	 * 
	 * @return the VideoItem with the highest rank or the first encountered if more
	 *         than one item has the same highest rank
	 */
	// TODO topRanked
	public VideoItem topRanked() {
		VideoItem title = null;
		double ranking = Double.MIN_VALUE;

		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getRanking() > ranking) {
				ranking = items.get(i).getRanking();
				title = items.get(i);
			}
		}

		return title;

	}

	/**
	 * finds the video item with the most downloads
	 * 
	 * @return the VideoItem with the most downloads or the first encountered if
	 *         more than one item has the same greatest downloads
	 */
	// TODO mostDownloads
	public VideoItem mostDownloads() {
		VideoItem downloadItem = null;
		int download = -Integer.MIN_VALUE;

		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getNumDownloads() > download) {
				download = items.get(i).getNumDownloads();
				downloadItem = items.get(i);
			}
		}
		return downloadItem;
	}

}  
