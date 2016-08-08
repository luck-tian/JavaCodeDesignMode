package 单例模式;

public class 单例模式5 {

	private static 单例模式5 mInstance;

	// 私有化构造方法
	private 单例模式5() {

	}

	public static 单例模式5 getInstance() {
		if (mInstance == null) {
			init5();
		}
		return mInstance;
	}

	private synchronized static void init5() {
		if (mInstance == null) {
			mInstance = new 单例模式5();
		}
	}

	public Object readResolve() {
		return getInstance();
	}
}
