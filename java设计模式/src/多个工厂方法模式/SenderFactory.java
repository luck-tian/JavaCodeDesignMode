package 多个工厂方法模式;

/**
 * 
 * 发送工厂
 */
public class SenderFactory {

	public Sender produceMail() {
		return new MailSender();
	}

	public Sender produceSms() {
		return new SmsSender();
	}

}
