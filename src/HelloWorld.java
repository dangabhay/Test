import lombok.AllArgsConstructor;
import lombok.Getter;

public final class HelloWorld {

	public static void main(String[] args) throws InterruptedException {
		if (args.length > 0)
			System.out.println("Hello " + args[0]);
		else
			System.out.println("No argument supplied");
		
		MyClass obj = new MyClass(10, "Hello World");
		System.out.println(obj.getValue() + " " + obj.getText());
		
		Thread.sleep(20000);
	}
	
	@AllArgsConstructor
	@Getter
	private static class MyClass {
		private int value;
		private String text;
	}
}
