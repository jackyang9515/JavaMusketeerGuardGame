package assignment1;

public class MoveCommand implements Command{

	private Agent agent;
	private ThreeMusketeers model;
	
	/**
	 * Constructor to create a move command
	 * @param agent Agent that is moving this turn
	 * @param model Model of the game
	 */
	public MoveCommand(Agent agent, ThreeMusketeers model) {
		this.agent = agent;
		this.model = model;
	}
	
	/**
	 * Executes the command
	 */
	public void execute() {
		final Move move = this.agent.getMove();

		MovesHistory moves = model.getMoves();
		moves.addMove(new Move(move), model.getBoard().getTurn());
		model.getBoard().move(move);
	}
}
