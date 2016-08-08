package в╟йндёй╫;

public class Decorator implements Sourceable {

	private Sourceable sourceable;

	public Decorator(Sourceable sourceable) {
		this.sourceable = sourceable;
	}

	@Override
	public void method() {
		System.out.println("this step one");
		sourceable.method();
		System.out.println("this step two");
	}

}
