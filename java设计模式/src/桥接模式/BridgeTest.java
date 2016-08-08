package 桥接模式;

public class BridgeTest {

	public static void main(String[] args) {
		// 第一个桥接模式
		Bridge bridge = new MyBridge();
		Sourceable sourceable = new SourceSub1();
		bridge.setSourceable(sourceable);
		bridge.method();

		// 第二个桥接模式
		Sourceable sourceable2 = new SourceSub2();
		bridge.setSourceable(sourceable2);
		bridge.method();
	}

}
