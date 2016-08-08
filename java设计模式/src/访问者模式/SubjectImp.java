package 访问者模式;

public class SubjectImp implements Subject {

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String getSubject() {
		return "i love you";
	}

}
