package 观察者模式;

public class Observer1 implements Observer {

	@Override
	public void updata() {
		System.out.println("observer1 has received!");
	}

}
