package 静态工厂方法模式;

/**
 * 
 * 发送工厂
 */
public class SenderFactory {

	public static Sender produceMail() {
		return new MailSender();
	}

	public static Sender produceSms() {
		return new SmsSender();
	}

}
