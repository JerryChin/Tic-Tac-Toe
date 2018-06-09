package jerrychin.ui;
import javax.swing.SwingConstants;

public class SquareLabelFactory {
	public static SquareLabel getSquareLabel(int id) {
		SquareLabel label = new SquareLabel(id);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		return label;
	}
}