package jerrychin.util;

import jerrychin.model.Player;

public class Null extends Player {
	@Override
	public String toString() {
		return "PlaceHolder: " + hashCode();
	}
}
