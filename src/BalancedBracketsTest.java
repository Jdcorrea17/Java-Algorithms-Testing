import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.AssertJUnit.assertFalse;

public class BalancedBracketsTest {
    String closedParentheses = ")(";
    String mismatchedBrackets = "({)}]";
    String matchedBrackets = "{([])}";
    BalancedBrackets brackets = new BalancedBrackets();

    @Test
    public void testBalancedBrackets_closedParentheses(){
        assertFalse(brackets.closedParnetheses(")("));
    }

    @Test
    public void testBalancedBrackets_mismatchedBrackets(){
        assertFalse(brackets.closedParnetheses("({)}]"));
    }

    @RunWith(Parameterized.class)
    public class ParameterizedTest{
        public String input;
        private boolean expectedOutput;
        BalancedBrackets brackets = new BalancedBrackets();

        public ParameterizedTest(String input, boolean expectedOutput){
            this.input = input;
            this.expectedOutput = expectedOutput;
        }

        @Parameters
        public static Collection<Object[]> testConditions(){
            String closedParentheses = ")(";
            String mismatchedBrackets = "({)}]";
            String matchedBrackets = "{([])}";

            Object[][] expectedOutputs = {
                    {closedParentheses, false},
                    {mismatchedBrackets, false},
                    {matchedBrackets, true}
            };
            return Arrays.asList(expectedOutputs);
        }
        @Test
        public void testBalancedBrackets(){
            assertEquals(expectedOutput, brackets.balancedBrackets(input));
        }
    }
}

