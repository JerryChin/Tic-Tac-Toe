package jerrychin.service;

import java.util.Map;
import jerrychin.model.ChessBoard;
import jerrychin.model.Player;
import jerrychin.model.Square;
import jerrychin.util.Result;

public interface Referee {
	public Result judge(ChessBoard chessBoard, Player player);
	public Player updateWhoToPlay(Map<String, Player> playerMap);
	//make suggestion
	public Square whereToAdd(ChessBoard chessBoard, Player player);
	public boolean isThreatening(ChessBoard chessBoard, Player opponent);
	public void cleanMind();
}
