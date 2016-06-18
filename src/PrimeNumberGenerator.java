import java.util.stream.LongStream;

import com.google.common.base.Preconditions;

import lombok.NonNull;

/*
 * This class is used to generate prime numbers
 */
public final class PrimeNumberGenerator {

	public static void main(@NonNull String[] args) {
		Preconditions.checkArgument(args.length == 2, "2 arguments needed");
		long seed = Long.parseUnsignedLong(args[0]);
		long howMany = Long.parseUnsignedLong(args[1]);
		Preconditions.checkArgument(seed >=0 && howMany>0 , "Invalid arguments provided");
		
		LongStream.iterate(seed, n -> n+1).filter(PrimeNumberGenerator::checkPrime).limit(howMany).
				forEach(System.out::println);

	}
	
	private static boolean checkPrime(long num) {
		if (num == 0 || num == 1) return false;
		for (long i=2; i*i <=num; i++)
			if (num%i == 0) return false;
		return true;
	}
}
