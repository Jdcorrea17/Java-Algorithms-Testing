import org.testng.annotations.Test;

public class MissingNumberPerformanceTest {
    private int[] missingNone = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private int[] missingTwo = {1, 3, 4, 5, 6, 7, 8, 9, 10 };
    private int[] missingAll = {};
    private int max = 10;
    private MissingNumber number = new MissingNumber();

    @Test
    public void testMissingNumber_Performance(){
        for(int i = 0; i <1000000; i += 1){
            number.missingNumber(missingNone, max);
            number.missingNumber(missingTwo, max);
            number.missingNumber(missingAll, max);
        }
    }
}
