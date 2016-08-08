package 抽象工厂模式;

/**
 * 
 * 邮寄发送
 */
public class MailSender implements Sender {

	@Override
	public void send() {
		System.out.println("send email");
	}

}
