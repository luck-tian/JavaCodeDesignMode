package 静态工厂方法模式;

/**
 * 
 * 测试
 */
public class SenderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SenderFactory.produceMail().send();
		SenderFactory.produceSms().send();
	}

}
