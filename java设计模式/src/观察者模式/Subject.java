package 观察者模式;

public interface Subject {

	void add(Observer observer);

	void del(Observer observer);
	
	void notifyObserver();
	
	void operation();

	
	
}
