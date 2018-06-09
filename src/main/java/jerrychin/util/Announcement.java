package jerrychin.util;

public enum Announcement {
	FAILURE("�ܲ����ˣ���������", "failure"), SUCCESS("���  %s Ӯ�ñ��غ�ʤ����", "success"), DRAW("���غ�ƽ�֣�", "draw"), CONTINUING("continuing", "continuing");
	
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