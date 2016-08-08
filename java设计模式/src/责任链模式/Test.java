package 责任链模式;

public class Test {

	public static void main(String[] args) {
		HandlerImp h1 = new HandlerImp("h1");
		HandlerImp h2 = new HandlerImp("h2");
		HandlerImp h3 = new HandlerImp("h3");

		h1.setHandler(h2);
		h2.setHandler(h3);

		h1.operator();
	}
}
