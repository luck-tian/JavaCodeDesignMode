package 观察者模式;

public class MySubject extends AbstractSubject {
	@Override
	public void operation() {
		System.out.println("updata self!");
		notifyObserver();
	}
}
