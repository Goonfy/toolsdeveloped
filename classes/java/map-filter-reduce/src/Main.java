import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String message = "I'll send an SOS to the garbage world, " +
                "I hope that someone garbage gets my message in a garbage bottle.";

        String[] messageArray = message.split(" ");

        List<String> convertedMessage = Stream.of(messageArray).filter(m -> !m.equals("garbage")).collect(Collectors.toList());

        String result = Arrays.stream(message.split(" ")).filter(word -> !word.equals("garbage")).map(String::toUpperCase).collect(Collectors.joining(" "));

        System.out.println(result);
    }
}
