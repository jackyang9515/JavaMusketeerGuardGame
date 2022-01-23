package assignment1;

import java.util.Iterator;

public interface MovesIterator<E> extends Iterator<Move>{
	public abstract Move undo();
}
