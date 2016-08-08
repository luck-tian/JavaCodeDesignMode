package 抽象工厂模式;

/**
 * 
 * 测试
 */
public class SenderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SmsSenderFactory factory = new SmsSenderFactory();
		factory.produce().send();
		MailSenderFactory mailSenderFactory = new MailSenderFactory();
		mailSenderFactory.produce().send();
	}

}
