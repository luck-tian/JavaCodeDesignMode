package 迭代子模式;

public class CollectionImp implements Collection {

	public String string[] = { "A", "B", "C", "D", "E" };

	@Override
	public Iterator iterator() {
		return new IteratorImp(this);
	}

	@Override
	public Object get(int i) {
		return string[i];
	}

	@Override
	public int size() {
		return string.length;
	}

}
