package testNg001;

import org.java001.Calculator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {

    @Test(groups="sanity")

    public static void mod(){
        int result= Calculator.mod(10,2);
        Assert.assertEquals(result,0);
    }
    //DATA PROVIDER EXAMPLE , used when have a lot of numbers in the [][]
    @DataProvider(name ="testData")
    public Object[][] provideTestData() {
        return new Object[][]{
                {1, 2, 5},
                {4, 6, 10},
                {0, 0, 0}
        }; // why is this semicolon here? and not after the last curly bracket with 0,0,0?
    }
    @Test(dataProvider ="testData", groups="sanity")
    @Parameters({"c","d"})
    public void testAdd(int a, int b, int expectedSum){
        int result = Calculator.add(a, b);
        Assert.assertEquals(result, expectedSum);

    }
}
