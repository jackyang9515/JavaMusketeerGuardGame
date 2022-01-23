package assignment1;

public class AgentOperator {

	private Command cmd;
	
	/**
	 * Sets the current command for AgentOperator.
	 * @param cmd Command to be set.
	 */
	public void setCommand(Command cmd) {
		this.cmd = cmd;
	}
	
	/**
	 * Operates the currently set command.
	 */
	public void operate() {
		this.cmd.execute();
	}
}
