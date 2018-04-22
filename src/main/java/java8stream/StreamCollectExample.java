package java8stream;

import java.util.stream.Stream;

public class StreamCollectExample {

	public static void main(String[] args) {
		// Stream.collect() using Supplier, Accumulator, and Combiner

		// collect ->
		// https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#collect-java.util.function.Supplier-java.util.function.BiConsumer-java.util.function.BiConsumer-
		Stream<String> stringStream = Stream.of("A", "B", "C");
		StringBuilder builder = stringStream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
		System.out.println(builder.toString());
	}

}
