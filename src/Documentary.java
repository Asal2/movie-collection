/**
 * 
 * This class represents a documentary (ie a non-fiction film)
 * 
 */

public class Documentary extends Film {
	// Possible genre of the documentary
	private static final String[] POSSIBLE_SUBJECTS = { "Adventure", "Crime", "History", "Music", "Reality-TV",
			"Sport" };

	private String subject; // genre of the documentary.

	/**
	 * constructs an documentary with a title, subject, rating, length of the film
	 * in minutes, number of downloads, ranking from responders, and the number of
	 * responders
	 * 
	 * @param title        - the title of the documentary
	 * @param subject      - the subject of the documentary (ie. Crime,
	 *                     History,....)
	 * @param rating       - the documentary's rating (ie. R, PG,...)
	 * @param length       - the length of the documentary in minutes
	 * @param numDownloads - the number of downloads of this documentary
	 * @param ranking      - the average ranking (1..10) of this documentary from
	 *                     the responses
	 * @param numResponses - the number of responses ranking this documentary
	 */
	public Documentary(String title, String releaseYear, String subject, String rating, int length, int numDownloads,
			double ranking, int numResponses) {
		super(title, releaseYear, rating, length, numDownloads, ranking, numResponses);
		// TODO Auto-generated constructor stub
		setSubject(subject);
	}

	/**
	 * sets the subject of this documentary to the received subject
	 * 
	 * @param subject - the subject of this documentary
	 */
	public void setSubject(String subject) {
		boolean test = true;
		for (int i = 0; i < POSSIBLE_SUBJECTS.length; i++) {
			if (subject.equals(POSSIBLE_SUBJECTS[i])) {
				this.subject = subject;
				test = false;
			}
		}
		if (test) {
			throw new IllegalArgumentException("Invalid subject: " + subject);
		}
	}

	@Override	//  for getItemDetails
	public String getItemDetails() {
		String sms = "";
		sms += super.getFullTitle();
		sms += "\n" + subject;
		sms += "\n" + super.getItemDetails();
		return sms;
	}
}
