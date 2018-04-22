package java8stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamExample {

	public static void main(String[] args) {
		int startNumber = 1;
		int endNumber = 10;
		// range ->
		System.out.println("---- range ----");
		System.out.println(
				"**must print 1 to 9** - equivalent to -> for (int i = startInclusive; i < endExclusive ; i++) { ... }");
		// https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#range-int-int-
		IntStream.range(startNumber, endNumber).forEach(System.out::println);

		System.out.println("");

		// rangeClosed ->
		// https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#rangeClosed-int-int-
		System.out.println("---- rangeClosed ----");
		System.out.println(
				"**must print 1 to 10** - equivalent to -> for (int i = startInclusive; i <= endInclusive ; i++) { ... }");
		IntStream.rangeClosed(startNumber, endNumber).forEach(System.out::println);

		System.out.println("");

		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		System.out.println("#### Check if prime ####");
		intList.forEach(IntStreamExample::isPrime);

		System.out.println("");

		IntStream intStream = null;

		// asDoubleStream ->
		// https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#asDoubleStream--
		intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println("---- asDoubleStream ----");
		System.out.println("**must print 1.0 to 10.0**");
		intStream.asDoubleStream().forEach(System.out::println);

		System.out.println("");

		// asLongStream ->
		// https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#asLongStream--
		intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println("---- asLongStream ----");
		System.out.println("**must print 1 to 10**");
		intStream.asLongStream().forEach(System.out::println);

		System.out.println("");

		// average ->
		// https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#average--
		intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		OptionalDouble optionalDouble = intStream.average();
		System.out.println("---- average ----");
		System.out.println("**average of 1 to 10 -> must print 5.5**");
		System.out.println(optionalDouble.isPresent() ? optionalDouble.getAsDouble() : 0.0);

		System.out.println("");

		// boxed ->
		// https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html#boxed--
		intStream = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Stream<Integer> boxed = intStream.boxed();
		System.out.println("---- boxed ----");
		long count = boxed.filter(v -> v instanceof Integer).count();
		System.out.println("**count must be 10**");
		System.out.println(count);

		System.out.println("");
	}

	private static void isPrime(final int number) {
		System.out.println((number > 1 && IntStream.range(2, number).noneMatch(input -> number % input == 0))
				? number + " is a prime number"
				: number + " is not a prime number");
	}

}
