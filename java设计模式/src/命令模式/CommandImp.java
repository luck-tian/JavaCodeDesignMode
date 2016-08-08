package ÃüÁîÄ£Ê½;

public class CommandImp implements Command {

	private Receiver receiver;

	public CommandImp(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void exe() {
		receiver.action();
	}

}
