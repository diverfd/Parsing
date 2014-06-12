import com.myowntry.datahandler.Input;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by box on 12.06.2014.
 */
public class FirstTest {

@Test
    public void testInput(){
    Input input = new Input();
    input.dataIn();
    Assert.assertNotNull(input.dataIn());
}
}
