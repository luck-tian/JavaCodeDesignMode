package 访问者模式;

public interface Subject {

	void accept(Visitor visitor);

	String getSubject();
}
