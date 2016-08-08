package 抽象工厂模式;

/**
 * 
 * 发送工厂
 */
public class SmsSenderFactory implements Provider {

	@Override
	public Sender produce() {
		return new SmsSender();
	}

}
