import com.myowntry.datahandler.Input;
import com.myowntry.datahandler.WordCounter;
import com.myowntry.datahandler.WordFilter;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by box on 12.06.2014.
 */
public class AllTests {

    @Test
    public void testWordCount() {
        WordCounter wordCounter = new WordCounter();
        // given
        final String text = "ох ах ух ох ах";

        // when
        final Map<String, Integer> actualResult = wordCounter.countWords(text);

        // then
        Map<String, Integer> expectedResult = new HashMap<String, Integer>();
        expectedResult.put("oх", 2);
        expectedResult.put("ах", 2);
        expectedResult.put("ух", 1);
        Assert.assertTrue(resultMapsAreEqual(expectedResult, actualResult));
    }

    private boolean resultMapsAreEqual(Map<String, Integer> expectedResult, Map<String, Integer> actualResult) {
        if (expectedResult.size() != actualResult.size()) {
            return false;
        }
        for (Map.Entry<String, Integer> entry : expectedResult.entrySet()) {
            String word = entry.getKey();
            int expectedCount = expectedResult.get(word);
            int actualCount = actualResult.get(word);
            if (expectedCount != actualCount) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void wordFilterTest(){
        WordFilter wordFilter = new WordFilter();
        final String word = "(Play;Station)";
        final String expectedWord = "PlayStation";
        Assert.assertEquals(expectedWord, wordFilter.filterWord(word));

    }

}
