package jerrychin.util;

public enum Announcement {
	FAILURE("很不走运，你输啦！", "failure"), SUCCESS("玩家  %s 赢得本回合胜利！", "success"), DRAW("本回合平局！", "draw"), CONTINUING("continuing", "continuing");
	
	String message;
	String audio;
	
	/**
	 * @return the audio
	 */
	public String getAudio() {
		return audio;
	}

	Announcement(String message, String audio) {
		this.message = message;
		this.audio = audio;
	}
	
	@Override
	public String toString() {
		return message;
	}
}