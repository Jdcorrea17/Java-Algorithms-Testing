import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class MissingNumberTest {
    private int[] missingNone = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private int[] missingTwo = {1, 3, 4, 5, 6, 7, 8, 9, 10 };
    private int[] missingAll = {};
    private MissingNumber number = new MissingNumber();

    @Test
    public void testMissingNumber_MissingNone(){
        assertEquals(0, number.missingNumber(missingNone, 10));
    }

    @Test
    public void testMissingNumber_MissingTwo(){
        assertEquals(2, number.missingNumber(missingTwo, 10));
    }

    @Test
    public void testMissingNumber_MissingAll(){
        assertEquals(0, number.missingNumber(missingAll, 0));
    }

}
