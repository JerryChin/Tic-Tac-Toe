package jerrychin.util;

import jerrychin.model.Player;

public class Result {
	
	Player winner;
	Announcement announcement;
	
	/**
	 * @return the announcement
	 */
	public Announcement getAnnouncement() {
		return announcement;
	}

	/**
	 * @param announcement the announcement to set
	 */
	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	/**
	 * @return the winner
	 */
	public Player getWinner() {
		return winner;
	}
	
	/**
	 * @param winner the winner to set
	 */
	public void setWinner(Player winner) {
		this.winner = winner;
	}
	
	public Result(Announcement announcement) {
		this.announcement = announcement;
	}
	
	public Result(Announcement announcement, Player winner) {
		this.winner = winner;
		this.announcement = announcement;
	}
}