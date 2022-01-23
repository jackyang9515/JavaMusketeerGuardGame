package assignment1;

import assignment1.Piece.Type;

public class CellBuilder {
	Cell cell;
	boolean isMusketeer;
	boolean isGuard;
	boolean isEmpty;
	String symbol;
	Coordinate coordinate;
	
	
	public CellBuilder(String symbol, Coordinate coordinate) {
		this.cell = new Cell(coordinate);
		this.symbol = symbol.strip();
		this.coordinate = coordinate;
		isMusketeer = false;
		isGuard = false;
		isEmpty = false;
		if (this.symbol == "X") {
			isMusketeer = true;
			this.cell.setPiece(new Musketeer());
		}
		else if (this.symbol == "O") {
			isGuard = true;
			this.cell.setPiece(new Guard());
		}
		else if (this.symbol == null) {
			isEmpty = true;
			this.cell.setPiece(null);
		}
	}
	
	//Creates a copy of the CellBuilder
	public CellBuilder(CellBuilder cb) {
		this.cell = cb.cell;
		this.symbol = cb.symbol;
		this.coordinate = cb.coordinate;
		this.isMusketeer = cb.isMusketeer;
		this.isGuard = cb.isGuard;
		this.isEmpty = cb.isEmpty;
	}
	
	public void setGuard () {
		isMusketeer = false;
		isEmpty = false;
		isGuard = true;
		cell.setPiece(new Guard());
		symbol = "O";
	}
	
	public void setMusketeer () {
		isMusketeer = true;
		isEmpty = false;
		isGuard = false;
		cell.setPiece(new Musketeer());
		symbol = "X";
	}
	
	public void setEmpty () {
		isMusketeer = false;
		isEmpty = true;
		isGuard = false;
		cell.setPiece(null);
		symbol = "";
	}
	
	public void setOpposite() {
		if (cell.getPiece() == null) {
			return;
		}
		else if (cell.getPiece().getType() == Type.MUSKETEER) {
			cell.setPiece(new Guard());
			isMusketeer = false;
			isGuard = true;
			symbol = "O";
		}
		else {
			cell.setPiece(new Musketeer());
			isMusketeer = true;
			isGuard = false;
			symbol = "X";
		}
	}
	
	public Cell getCell() {
		return cell;
	}
	
	public Piece getPiece() {
		return cell.getPiece();
	}
	
	public String toString() {
		return cell.toString();
	}
	
	public void setWinColor() {
		return;
	}
	
	public void setLoseColor() {
		return;
	}
	
	public void setOptionsColor() {
		return;
	}
	
	public void setAgentFromColor() {
		return;
	}
	
	public void setAgentToColor() {
		return;
	}
	
	public void setDefaultColor() {
		return;
	}
	
	//Not sure how setSize can be implemented.
}
