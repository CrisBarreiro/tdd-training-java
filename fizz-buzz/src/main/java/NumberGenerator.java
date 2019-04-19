import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    public List<String> generate() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            String text = String.valueOf(i);

            if (isFizzBuzz(i)) {
                text = "FizzBuzz";
            } else if (isFizz(i)){
                text = "Fizz";
            } else if (isBuzz(i)) {
                text = "Buzz";
            }

            list.add(text);
        }
        return list;
    }

    private boolean isFizzBuzz(int i) {
        return isFizz(i) && isBuzz(i);
    }

    private boolean isBuzz(int i) {
        return String.valueOf(i).contains("5") || i % 5 == 0;
    }

    private boolean isFizz(int i) {
        return String.valueOf(i).contains("3") || i % 3 == 0;
    }

}
