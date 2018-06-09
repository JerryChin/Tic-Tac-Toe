package jerrychin.service;

import jerrychin.controller.ChessGame;

public class PrepareForNextGameCommand implements Command {
	ChessGame chessGame;
	
	public PrepareForNextGameCommand(ChessGame chessGame) {
		this.chessGame = chessGame;
	}
	
	@Override
	public void run() {
		chessGame.prepareForNextGame();
	}

}