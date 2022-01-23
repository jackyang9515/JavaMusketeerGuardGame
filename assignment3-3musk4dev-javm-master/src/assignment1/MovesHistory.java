package assignment1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import assignment1.Piece.Type;

public class MovesHistory implements Iterable<Move>{

	private List<MoveTurn> moves;
	private int currentMoveIndex = 0;
	
    /**
     * Creates an iterable list of moves with the default current move index as 0.
     */
	public MovesHistory() {
		moves = new ArrayList<MoveTurn>();
	}
	
	/**
	 * Adds a copy of the move that is performed this turn to the list of performed moves.
	 * All subsequent redone moves will are removed and the new next move is recorded.
	 * The current move index increases by one for the added move.
	 * @param move The move to be added to the list of moves performed.
	 */
	public void addMove(Move move, Type piece) {
		moves = moves.subList(0, currentMoveIndex);
		moves.add(new MoveTurn(currentMoveIndex, piece, move));
		currentMoveIndex++;
	}
	
	/**
	 * Retrieves a move that wants to be undone. Subtracts one to the move turn index.
	 * @return a copy of the move to be undone.
	 */
	public Move undoMove() {
		Move move = this.iterator().undo();
		currentMoveIndex--;
		return move;
	}
	
	/**
	 * Retrieves a move that wants to be redone. Adds one to the move turn index.
	 * @return a copy of the move to be redone.
	 */
	public Move redoMove() {
		Move move = this.iterator().next();
		currentMoveIndex++;
		return move;
	}
	
	/**
	 * @return the size of the list of moves performed.
	 */
	public int size() {
		return moves.size();
	}
	
	/**
	 * @return the amount of moves performed from the start of the game to its current position.
	 */
	public int getCurrentMoveIndex() {
		return this.currentMoveIndex;
	}
	
	public List<MoveTurn> getMoves() {
		return this.moves;
	}
	
	/**
	 * @return an iterator that gets can iterate through MovesHistory.
	 */
	@Override
	public MovesIterator<Move> iterator() {
		return new MovesHistoryIterator(moves, currentMoveIndex);
	}
}
