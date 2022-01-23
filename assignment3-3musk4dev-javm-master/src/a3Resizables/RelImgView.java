package a3Resizables;

import a3App.View;
import a3Utils.Utils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * A resizable image view. Fixed ratio is not implemented to allow more flexibility (and easier to meme)
 *
 */
public class RelImgView extends ImageView implements Resizable{
	private RelViewCoords relCoords = new RelViewCoords();
	private boolean isMusketeer;
	private boolean isGuard;
	private boolean isEmpty;

	public RelImgView(Image img) {
		super(img);
		this.isMusketeer = img.equals(View.getCurrTheme().getMuskImg());
		this.isGuard = img.equals(View.getCurrTheme().getGuardImg());
		this.isEmpty = img.equals(View.getCurrTheme().getEmptyImg());
	}

	@Override
	public void relResize(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		this.setX(this.relCoords.getAbsX(x + w * this.relCoords.getX()));
		this.setY(this.relCoords.getAbsY(y + h * this.relCoords.getY()));
		this.setFitWidth(this.relCoords.getAbsW(w * this.relCoords.getW()));
		this.setFitHeight(this.relCoords.getAbsH(h * this.relCoords.getH()));
		if (isMusketeer && !this.getImage().equals(View.getCurrTheme().getMuskImg())) {
			this.setImage(View.getCurrTheme().getMuskImg());
		} else if (isGuard && !this.getImage().equals(View.getCurrTheme().getGuardImg())) {
			this.setImage(View.getCurrTheme().getGuardImg());
		} else if (isEmpty && !this.getImage().equals(View.getCurrTheme().getEmptyImg())) {
			this.setImage(View.getCurrTheme().getEmptyImg());
		}
		if (this.isDisabled()) {
			this.setOpacity(0.5);
		} else {
			this.setOpacity(1.0);
		}
	}

	@Override
	public void setRelX(double x) {
		// TODO Auto-generated method stub
		this.relCoords.setX(x);
	}

	@Override
	public void setRelY(double y) {
		// TODO Auto-generated method stub
		this.relCoords.setY(y);
	}

	@Override
	public void setRelW(double w) {
		// TODO Auto-generated method stub
		this.relCoords.setW(w);
	}

	@Override
	public void setRelH(double h) {
		// TODO Auto-generated method stub
		this.relCoords.setH(h);
	}

	@Override
	public double getRelX() {
		// TODO Auto-generated method stub
		return this.relCoords.getX();
	}

	@Override
	public double getRelY() {
		// TODO Auto-generated method stub
		return this.relCoords.getY();
	}

	@Override
	public double getRelW() {
		// TODO Auto-generated method stub
		return this.relCoords.getW();
	}

	@Override
	public double getRelH() {
		// TODO Auto-generated method stub
		return this.relCoords.getH();
	}

	@Override
	public void setRelXYWH(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		this.setRelX(x);
		this.setRelY(y);
		this.setRelW(w);
		this.setRelH(h);
	}

}
