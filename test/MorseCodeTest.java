import org.junit.Test;
import static org.junit.Assert.*;

public class MorseCodeTest {
    private final MorseCode mc = new MorseCode();

    @Test
    public void testMorseToEnglish() {
        assertEquals("HELLO", mc.morseToEnglish("**** * *-** *-** ---"));
        assertEquals("HELL", mc.morseToEnglish("**** * *-** *-**"));
        assertEquals("WORLD", mc.morseToEnglish("*-- --- *-* *-** -**"));
    }

    @Test
    public void testEnglishToMorse() {
        assertEquals("**** * *-** *-** ---  -*- ** -* --*", mc.englishToMorse("HELLO KING"));
        assertEquals("**  *- --  - **** *  -*** * *** -", mc.englishToMorse("I AM THE BEST"));
        assertEquals("*-- --- *-* *-** -**", mc.englishToMorse("WORLD"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidEnglishCharacter() {
        mc.englishToMorse("HELLO WORLDä!");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMorseCode() {
        mc.morseToEnglish("*-- --- HEY *-** -**");
    }
}
