package assignment1;

import assignment1.Piece.Type;

public class MoveTurn {

	private int turn;
	private Type piece;
	private Move move;
	private String fromCellCoord;
	private String toCellCoord;
	
	/**
	 * Constructor for a turn in the game 
	 * @param turn Turn number of the current board
	 * @param piece Piece that moved during this turn
	 * @param move Move that was navigated by the piece this turn
	 */
	public MoveTurn(int turn, Type piece, Move move) {
		this.turn = turn;
		this.piece = piece;
		this.move = move;
		this.fromCellCoord = this.move.fromCell.getCoordinate().toString(); 
		// System.out.println(this.fromCellCoord);
		this.toCellCoord = this.move.toCell.getCoordinate().toString();
	}
	
	public int getTurn() { return this.turn; }
	public Type getPiece() { return this.piece; }
	public Move getMove() { return this.move; }
	public String getFromCellCoord() { return this.fromCellCoord; }
	public String getToCellCoord() { return this.toCellCoord; }
}
