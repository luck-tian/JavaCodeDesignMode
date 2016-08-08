package 迭代子模式;

public interface Iterator {

	Object previous();

	Object next();

	boolean hasNext();

	Object first();
}
