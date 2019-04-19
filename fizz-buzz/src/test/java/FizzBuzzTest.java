import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

public class FizzBuzzTest {

    private List<String> list;
    private String fizz = "Fizz";
    private String buzz = "Buzz";
    private String fizzBuzz = "FizzBuzz";

    private String get(int index) {
        if (index > 0 && index <= 100) {
            return list.get(index-1);
        } else {
            return null;
        }
    }

    @Before
    public void setUp() {
        NumberGenerator generator = new NumberGenerator();
        list = generator.generate();
    }

    @Test
    public void generate_isSize100() {
        assertTrue(list.size() == 100);
    }

    @Test
    public void generate_get0_equals1() {
        assertEquals("1", get(1));
    }

    @Test
    public void generate_multiple3_equalsFizz() {
        assertEquals(fizz, get(3));
        assertEquals(fizz, get(6));
    }


    @Test
    public void generate_multiple5_equalsBuzz() {
        assertEquals(buzz, get(5));
        assertEquals(buzz, get(10));
    }

    @Test
    public void generate_multiple15_equalsFizzBuzz() {
        assertEquals(fizzBuzz, get(15));
        assertEquals(fizzBuzz, get(30));
        assertEquals(fizzBuzz, get(51));
    }

    @Test
    public void generate_nonmutliple3or5_equalsNumber() {
        assertEquals("1", get(1));
        assertEquals("28", get(28));
    }

    @Test
    public void generate_contains3_equalsFizz() {
        assertEquals(fizz, get(3));
        assertEquals(fizz, get(13));
    }

    @Test
    public void generate_contains5_equalsBuzz() {
        assertEquals(buzz, get(5));
        assertEquals(buzz, get(52));
    }

    @Test
    public void generate_contains3and5_equalsFizzBuzz() {
        assertEquals(fizzBuzz, get(35));
        assertEquals(fizzBuzz, get(53));
    }

}
