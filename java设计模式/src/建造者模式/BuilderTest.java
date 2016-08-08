package 建造者模式;

public class BuilderTest {

	public static void main(String[] args) {
		Builder builder = new Builder();
		builder.produceMailSender();
		builder.produceSmsSender();
	}
}
