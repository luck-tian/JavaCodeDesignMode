package 建造者模式;

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
