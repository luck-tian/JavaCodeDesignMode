package 单例模式;

public class 单例模式1 {

	private static 单例模式1 mInstance;

	// 私有化构造方法
	private 单例模式1() {

	}

	public static 单例模式1 getInstance() {
		if (mInstance == null) {
			mInstance = new 单例模式1();
		}
		return mInstance;
	}

}
