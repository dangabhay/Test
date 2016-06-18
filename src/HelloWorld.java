import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.stream.Stream;

import com.google.common.base.Preconditions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

public final class HelloWorld {

	public static void main(@NonNull String[] args) throws InterruptedException, IOException {
		Preconditions.checkArgument(args.length>0, "No argument provided");
		Preconditions.checkArgument(!"".equals(args[0]), "Empty argument provided");
		System.out.println("Hello " + args[0]);
		
		MyClass obj = new MyClass(10, "Hello World");
		System.out.println(obj.getValue() + " " + obj.getText());
		
		obj = MyClass.builder().value(20).text("Hello").build();
		
		Stream<String> lineStream = 
		Files.lines(FileSystems.getDefault().getPath("/home/abhay/workspace/Test", "build.xml"));
		lineStream.filter(line -> line.contains("base.dir")).map(String::toUpperCase).
		findAny().ifPresent(System.out::println);

		
		Stream.generate(Math::random).limit(10).sorted().forEach(System.out::println);

		Thread.sleep(20000);
	}
	
	@AllArgsConstructor
	@Getter
	@EqualsAndHashCode
	@Builder
	private static class MyClass {
		private int value;
		private String text;
	}
}
