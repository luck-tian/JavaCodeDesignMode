package 多个工厂方法模式;

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
		senderFactory.produceMail().send();
		senderFactory.produceSms().send();
	}

}
