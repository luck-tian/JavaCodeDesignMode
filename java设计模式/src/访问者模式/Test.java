package 访问者模式;

public class Test {

	public static void main(String[] args) {
		Visitor visitor = new VisitorImp();
		Subject sub = new SubjectImp();
		sub.accept(visitor);
	}
}
