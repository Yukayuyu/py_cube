package communication.javaMail;

public interface Mailable {
	/**
	 * use param title as mail-title, use param as mail text, send the mail.
	 * @param title
	 * @param text 
	 */
	void send(String title, String text); 
}
