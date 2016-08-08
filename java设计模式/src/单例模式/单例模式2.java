package 单例模式;

public class 单例模式2 {

	private static 单例模式2 mInstance;

	// 私有化构造方法
	private 单例模式2() {

	}

	public synchronized static 单例模式2 getInstance() {
		if (mInstance == null) {
			mInstance = new 单例模式2();
		}
		return mInstance;
	}

}
