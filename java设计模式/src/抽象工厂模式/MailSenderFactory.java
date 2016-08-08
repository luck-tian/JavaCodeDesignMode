package 抽象工厂模式;

public class MailSenderFactory implements Provider {

	@Override
	public Sender produce() {
		return new MailSender();
	}

}
