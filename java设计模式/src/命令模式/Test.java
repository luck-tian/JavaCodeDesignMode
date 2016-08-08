package ÃüÁîÄ£Ê½;

public class Test {

	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Command cmd = new CommandImp(receiver);
		Invoker invoker = new Invoker(cmd);
		invoker.action();
	}
}
