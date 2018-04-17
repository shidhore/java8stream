package java8stream;

import java.util.stream.Stream;

public class StreamBuilderExample {

	public static void main(String[] args) {
		// https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.Builder.html

		// using accept method to add elements
		System.out.println("---- Stream.Builder<String> - using accept method to add elements ----");
		Stream.Builder<String> builderUsingAccept = Stream.builder();
		builderUsingAccept.accept("String 1");
		builderUsingAccept.accept("String 2");
		Stream<String> streamBuiltWithBuilderUsingAccept = builderUsingAccept.build();
		streamBuiltWithBuilderUsingAccept.forEach(System.out::println);

		System.out.println("");

		// using add method to add elements
		System.out.println("---- Stream.Builder<String> - using add method to add elements ----");
		Stream.Builder<String> builderUsingAdd = Stream.builder();
		builderUsingAdd.add("String 3");
		builderUsingAdd.add("String 4");
		Stream<String> streamBuiltWithBuilderUsingAdd = builderUsingAdd.build();
		streamBuiltWithBuilderUsingAdd.forEach(System.out::println);

		System.out.println("");
	}

}
