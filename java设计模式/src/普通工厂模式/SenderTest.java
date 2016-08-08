package 普通工厂模式;

/**
 * 
 * 测试
 */
public class SenderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SenderFactory senderFactory = new SenderFactory();
		Sender produce = senderFactory.produce("mail");
		produce.send();
	}

}
