package 普通工厂模式;

/**
 * 
 * 发送工厂
 */
public class SenderFactory {

	public Sender produce(String type) {
		if ("mail".equals(type)) {
			return new MailSender();
		} else if ("Sms".equals(type)) {
			return new SmsSender();
		} else {
			System.out.println("this type not found");
			return null;
		}
	}

}
