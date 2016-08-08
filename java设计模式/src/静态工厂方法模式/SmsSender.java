package 静态工厂方法模式;

/**
 * 短信发送
 * 
 * 
 */
public class SmsSender implements Sender {

	@Override
	public void send() {
		System.out.println("send sms");
	}

}
