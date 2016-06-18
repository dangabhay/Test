import java.util.Optional;
import java.util.stream.Stream;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

public final class BaseXCalculator {

	public static void main(@NonNull String[] args) {
		Preconditions.checkArgument(args.length > 0 && !args[0].equals(""), "Argument not provided");
		long max = Long.parseUnsignedLong(args[0]);
		long base = (args.length > 1) ? 
				Long.parseLong(Optional.ofNullable(Strings.emptyToNull(args[1])).orElse("2")) : 2;
		
		Stream.iterate(0l, n -> n+1).limit(max+1).map(n -> BaseXCalculator.getBaseXRepresentation(n,base))
			.map(BaseXCalculator::StringToDisplay).forEach(System.out::println);

	}
	
	private static BaseXRepresentation getBaseXRepresentation(final long num, final long base)
	{
		long numCopy = num;
		StringBuilder sb = new StringBuilder();
		while (numCopy>0)
		{
			sb.append(numCopy % base);
			numCopy /= base;
		}
		String baseRep = sb.reverse().toString();
		baseRep = (!baseRep.equals("")) ? baseRep : "0";
		return new BaseXRepresentation(num, base, baseRep);
	}
	
	
	private static String StringToDisplay(final @NonNull BaseXRepresentation obj)
	{
		return obj.getNum() + " => " + obj.getBaseRep() + " in base " + obj.getBase();
	}
	
	@AllArgsConstructor
	@ToString
	@Getter
	private static class BaseXRepresentation {
		private long num;
		private long base;
		private String baseRep;
	}

}
