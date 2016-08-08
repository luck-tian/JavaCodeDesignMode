package 单例模式;

public class 单例模式4 {

	// 私有化构造方法
	private 单例模式4() {

	}

	public static 单例模式4 getInstance() {
		return 单例模式4Factory.mInstance;
	}

	static private class 单例模式4Factory {
		private static 单例模式4 mInstance = new 单例模式4();
	}

	public Object readResolve() {
		return getInstance();
	}
}
