import java.util.*;
import java.util.function.*;

public class StringProcessor {
	public static void processStrings(List<String> strings,
			Predicate<String> filter,
			Function<String, String> transformer,
			Consumer<String> printer) {
		for (String s : strings) {
			if (filter.test(s)) {
				String transformed = transformer.apply(s);
				printer.accept(transformed);
			}
		}
	}

	public static void main(String[] args) {
		List<String> words = Arrays.asList("Java", "Programchlal", "Kod");

		Predicate<String> filter = s -> s.length() > 5;
		Function<String, String> transformer = s -> new StringBuilder(s).reverse().toString();
		Consumer<String> printer = s -> System.out.println("GARSHIL: " + s.toUpperCase());

		processStrings(words, filter, transformer, printer);
	}
}