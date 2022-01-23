package assignment1;

import java.util.List;

public class MovesHistoryIterator implements MovesIterator<Move>{

	private List<MoveTurn> moves;
	private int moveIndex;
	
	/**
	 * Creates an iterator for MovesHistory. The move turn is defaulted at 0.
	 * @param moves A list of previously performed moves throughout the game.
	 */
	public MovesHistoryIterator(List<MoveTurn> moves) {
		this.moves = moves;
		this.moveIndex = 0;
	}
	
	/**
	 * Creates an iterator for MovesHistory with a specified current move turn.
	 * @param moves A list of previously performed moves throughout the game.
	 * @param moveIndex The current move turn.
	 */
	public MovesHistoryIterator(List<MoveTurn> moves, int moveIndex) {
		this.moves = moves;
		this.moveIndex = moveIndex;
	}
	
	/**
	 * @return Returns true if and only if there are still moves left in comparison to the current move turn.
	 */
	@Override
	public boolean hasNext() {
		return moveIndex < this.moves.size();
	}

	/**
	 * If the current move turn is 0, returns the only move performed.
	 * Otherwise, if the current move turn is larger than or equal to 1,
	 * the next move will previously performed will be returned.
	 * @return Returns the next move that was previously done on the next turn, null if there is no next turn.
	 */
	@Override
	public Move next() {
		if (moveIndex == 0) {
			return this.moves.get(0).getMove();
		}
		else if (hasNext()) {
			Move move = this.moves.get(moveIndex).getMove();
			moveIndex++;
			return move;
		}
		return null;
	}
	
	/**
	 * @return Returns the previous move that should be undone, null if no moves exist prior to current turn.
	 */
	@Override
	public Move undo() {
		if (moveIndex >= 1) {
			Move move = this.moves.get(moveIndex - 1).getMove();
			moveIndex--;
			return move;
		} 
		return null;
	}
	

}
