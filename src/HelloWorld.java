
public final class HelloWorld {

	public static void main(String[] args) throws InterruptedException {
		if (args.length > 0)
			System.out.println("Hello " + args[0]);
		else
			System.out.println("No argument supplied");
		Thread.sleep(20000);
	}
	
}
