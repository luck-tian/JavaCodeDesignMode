package в╟йндёй╫;

public class DecoratorTest {

	public static void main(String[] args) {
		Sourceable sourceable = new Decorator(new Source());
		sourceable.method();
	}
}
