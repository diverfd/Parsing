import com.myowntry.datahandler.WordCounter;
import com.myowntry.datahandler.WordCounterResultSorter;
import com.myowntry.datahandler.WordFilter;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by box on 12.06.2014.
 */
public class AllTests {

    @Test
    public void testWordCount() {
        WordCounter wordCounter = new WordCounter();
        // given
        final String text = "one, two, two, three, three, three.";

        // when
        final Map<String, Integer> actualResult = wordCounter.countWords(text);

        // then
        Map<String, Integer> expectedResult = new HashMap<String, Integer>();
        expectedResult.put("one", 1);
        expectedResult.put("two", 2);
        expectedResult.put("three", 3);
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

    @Test
    public void resultSorterTest(){
        WordCounterResultSorter resultSorter = new WordCounterResultSorter();
        //given
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("two", 2);
        hashMap.put("three", 3);
        hashMap.put("one", 1);
        //when
        List<Map.Entry<String, Integer>> actualResult = resultSorter.sortWords(hashMap);
        //then
        List<String> expectedResult = new ArrayList<String>();
        expectedResult.add("three=3");
        expectedResult.add("two=2");
        expectedResult.add("one=1");
        Assert.assertEquals(expectedResult.toString(), actualResult.toString());
    }

}
