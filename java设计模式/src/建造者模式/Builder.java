package 建造者模式;

import java.util.ArrayList;

/**
 * 工厂类模式提供的是创建单个类的模式， 而建造者模式则是将各种产品集中起来进行管理， 用来创建复合对象， 所谓复合对象就是指某个类具有不同的属性
 * 建造者模式将很多功能集成到一个类里
 * ，这个类可以创造出比较复杂的东西。所以与工程模式的区别就是：工厂模式关注的是创建单个产品，而建造者模式则关注创建符合对象，多个部分
 */
public class Builder {

	private ArrayList<Sender> mList = new ArrayList<Sender>();

	public void produceSmsSender() {
		mList.add(new SmsSender());
	}

	public void produceMailSender() {
		mList.add(new MailSender());
	}
}
