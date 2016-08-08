package 单例模式;

import java.util.Vector;

public class 单例模式6 {

	private static 单例模式6 mInstance;

	private Vector<Object> properties;

	public Vector getPorperties() {
		return properties;
	}

	public void updataProperties() {
		单例模式6 dan = new 单例模式6();
		properties = dan.getPorperties();
	}

	// 私有化构造方法
	private 单例模式6() {

	}

	public static 单例模式6 getInstance() {
		if (mInstance == null) {
			init5();
		}
		return mInstance;
	}

	private synchronized static void init5() {
		if (mInstance == null) {
			mInstance = new 单例模式6();
		}
	}

	public Object readResolve() {
		return getInstance();
	}
}
