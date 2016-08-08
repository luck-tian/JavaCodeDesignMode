package 单例模式;

public class 单例模式3 {

	private static 单例模式3 mInstance;

	// 私有化构造方法
	private 单例模式3() {

	}

	public static 单例模式3 getInstance() {
		if (mInstance == null) {
			synchronized (mInstance) {
				if (mInstance == null) {
					mInstance = new 单例模式3();
				}
			}
		}
		return mInstance;
	}
}
