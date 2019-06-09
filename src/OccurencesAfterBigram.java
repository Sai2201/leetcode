import java.util.ArrayList;
import java.util.List;

/**
 * Given words first and second, consider occurrences in some text of the form "first second third",
 * where second comes immediately after first, and third comes immediately after second.
 *
 * For each such occurrence, add "third" to the answer, and return the answer.
 */

public class OccurencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> result = new ArrayList<>();
        String[] words = text.split("\\s+");
        boolean firstOccur = false;
        boolean addThird = false;
        for ( String word : words ) {
            // To add the third word to the list
            if ( addThird ) {
                result.add(word);
                addThird = false;
            }
            //flag if first word occurs
            if ( word.equals(first)) {
                firstOccur = true;
                continue;
            } else if ( word.equals(second) && firstOccur ) {
                addThird = true;
            }
            //reset first word flag
            firstOccur = false;
        }
        String[] res = result.toArray(new String[0]);
        return res;
    }
}
