package assignment1;

import assignment1.Piece.Type;

public class GenerateBoard {
	
	/*
	 * Generate an Empty Board
	 */
	Board board;
	public GenerateBoard() {
		this.board = new Board();
		this.board.emptyBoard();
	}
	
	/*
	 * Generate an existing Board
	 */
	public GenerateBoard(String boardfilepath) {
		this.board = new Board(boardfilepath);
	}
	
	/*
	 * Generate a given board
	 */
	public GenerateBoard(Board board) {
		this.board = new Board(board);
	}
	
	
	/*
	 * Check if this is a valid board
	 */
	public boolean isValidBoard() {
		int accumulator = 0;
		for (Cell cell: this.board.getAllCells()) {
			if (cell.getPiece() != null) {
				if (cell.getPiece().getType() == Type.MUSKETEER) {
					accumulator++;
				}
			}
			
		}
		if (accumulator != 3) {
			return false;
		}
		if (this.board.isGameOver()) {
			return false;
		}
		return true;
	}
	/*
	 * Check if user can add more musketeer to the board
	 */
	public boolean isMaxMusketeer() {
		int accumulator = 0;
		for (Cell cell: this.board.getAllCells()) {
			if (cell.getPiece().getType() == Type.MUSKETEER) {
				accumulator++;
			}
		}
		if (accumulator == 3) {
			return true;
		}
		return false;
	}
	
	/*
	 * Calls saveBoard and save the board as a textfile
	 */
	public void saveBoard() {
		this.board.saveBoard();
	}

	public void saveBoard(String name) {
		this.board.saveCustomBoard(name); 
	}
	
	public Board getBoard() {
		return this.board;
	}
}
