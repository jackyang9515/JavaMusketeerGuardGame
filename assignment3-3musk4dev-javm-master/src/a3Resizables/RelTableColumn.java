package a3Resizables;

import a3App.View;
import javafx.scene.control.TableColumn;

public class RelTableColumn<I, O> extends TableColumn<I, O> implements Resizable{

	private RelViewCoords relCoords = new RelViewCoords();

	public RelTableColumn(String header){
		super(header);
	}

	@Override
	public void relResize(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		this.setPrefWidth(this.relCoords.getAbsW(w * this.relCoords.getW()));
	}

	/** An empty function.
	 *
	 */
	@Override
	public void setRelX(double x) {
		// TODO Auto-generated method stub
		// No Code, same for RelY and RelH
	}

	/** An empty function
	 *
	 */
	@Override
	public void setRelY(double y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRelW(double w) {
		// TODO Auto-generated method stub
		this.relCoords.setW(w);
	}

	/** An empty function.
	 *
	 */
	@Override
	public void setRelH(double h) {
		// TODO Auto-generated method stub
	}

	/** Using this method for RelTableColumn is discouraged.
	 * This has the same effect as setRelW, since the other 3 (X, Y, H) are empty functions.
	 *
	 */
	@Override
	public void setRelXYWH(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		this.relCoords.setW(w);
	}

	@Override
	public double getRelX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getRelY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getRelW() {
		// TODO Auto-generated method stub
		return this.relCoords.getW();
	}

	@Override
	public double getRelH() {
		// TODO Auto-generated method stub
		return 1;
	}

}
