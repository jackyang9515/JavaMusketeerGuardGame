package a3Scenes;

import a3App.View;
import a3Panels.AppPanel;
import a3Resizables.RelGroup;
import a3Resizables.RelImgView;
import a3Resizables.RelRect;
import a3Resizables.Resizable;
import assignment1.Board;
import assignment1.Cell;
import assignment1.Coordinate;
import assignment1.Musketeer;
import assignment1.Piece;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import assignment1.Guard;

public class BoardScene extends AppScene{
	private Board board;
	private RelImgView[][] cellsGUI;
	private EventType<MouseEvent> event;
	private AppPanel panel;

	@Override
	protected void buildScene() {
		// TODO Auto-generated method stub
		
		this.updatePreview(new Board());
	}

	/** 
	 * A "refresher" for the board. Removes all old RelImgView instances
	 * and replace them with new ones, as well as applying EventHandlers to the new RelImgView instances.
	 * @param newBoard: The updated board.
	 */
	public void updatePreview(Board newBoard) {
		((RelGroup) this.getRoot()).getChildren().clear();
		RelRect background = new RelRect();
		((RelGroup) this.getRoot()).getChildren().add(background);
		this.board = newBoard;
		this.cellsGUI = new RelImgView[this.board.size][this.board.size];
		for (int row = 0; row < this.board.size; row++) {
			for (int col = 0; col < this.board.size; col++) {
				if (this.board.board[row][col].getPiece() != null) {
					if (this.board.board[row][col].getPiece() instanceof Musketeer) {
						this.cellsGUI[row][col] = new RelImgView(View.getCurrTheme().getMuskImg());
					} else if (this.board.board[row][col].getPiece() instanceof Guard) {
						this.cellsGUI[row][col] = new RelImgView(View.getCurrTheme().getGuardImg());
					} else {
					}
				} else {
					this.cellsGUI[row][col] = new RelImgView(View.getCurrTheme().getEmptyImg());
				}
				if (this.panel != null && this.event != null) {
					this.cellsGUI[row][col].addEventHandler(this.event, this.panel);
				}
				this.cellsGUI[row][col].setRelXYWH((col + 0.1)/this.board.size, (row + 0.1)/this.board.size, 0.8/this.board.size, 0.8/this.board.size);
				((RelGroup) this.getRoot()).getChildren().add(this.cellsGUI[row][col]);
			}

		}
		AppScene scene = (AppScene) View.getStage().getScene();
		if (scene != null) {
			((Resizable) scene.getRoot()).relResize(0, 0, 1, 1);
		}
	}

	public Board getBoard() {
		return this.board;
	}

	/** Converts a given RelImgView object to the Coordinates. If the object is not
	 * contained in the scene, then it returns null instead.
	 * @param imgView: A RelImgView object
	 * @return the corresponding coordinates in the board for the model
	 */
	public Coordinate getCoordinate(RelImgView imgView) {
		for (int row = 0; row < this.board.size; row++) {
			for (int col = 0; col < this.board.size; col++) {
				if (this.cellsGUI[row][col].equals(imgView)) {
					return new Coordinate(row, col);
				}
			}
		}
		return null;
	}

	public void attachPanel(EventType<MouseEvent> event, AppPanel panel) {
		this.event = event;
		this.panel = panel;
		this.updatePreview(this.board);
	}

	/**
	 * Disables all RelImgView instances
	 */
	public void disableAllCells() {
		for (int row = 0; row < this.board.size; row++) {
			for (int col = 0; col < this.board.size; col++) {
				this.cellsGUI[row][col].setDisable(true);
			}
		}
	}

	/**
	 * @param coordinate: Coordinate of a cell in the given board
	 * @return The corresponding RelImgView object
	 */
	public RelImgView getCellGUI(Coordinate coordinate) {
		return this.cellsGUI[coordinate.getRow()][coordinate.getCol()];
		
	}
	
	public void changeCell(Coordinate coordinate, Piece p) {
		board.getCell(coordinate).setPiece(p);
		
	}
}
