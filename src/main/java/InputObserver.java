import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputObserver {

    private final List<Receiver> receivers = new ArrayList<>();
    private final PrintStream out = System.out;
    private final Scanner in = new Scanner(System.in);

    public InputObserver() {
        addReceiver(line -> out.println("default receiver: " + line));
    }

    public static void main(String[] args) {
        new InputObserver()
                .addReceiver(line -> System.out.println("additional receiver #1: " + line.toUpperCase()))
                .addReceiver(line -> System.out.println("additional receiver #2: ..."))
                .inputLoop();
    }

    public InputObserver addReceiver(Receiver receiver) {
        receivers.add(receiver);
        return this;
    }

    public void inputLoop() {
        out.println("starting input-loop");
        out.print("write here: ");
        while (in.hasNext()) {
            String line = in.nextLine();
            receivers.forEach(receiver -> receiver.receive(line));
        }
        out.println("ended input-loop");
    }

    //https://www.baeldung.com/java-8-lambda-expressions-tips
    public interface Receiver {
        void receive(String line);
    }
}
