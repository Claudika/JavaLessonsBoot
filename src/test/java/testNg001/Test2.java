package testNg001;

import org.java001.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 {

    @Test(groups="unit")
    public static void sub(){
        int result= Calculator.sub(3,3);
        Assert.assertEquals(result,0);
    }
    @Test (groups="unit")
    public static void div(){
        int result = Calculator.div(4,2);
        Assert.assertEquals(result,2);
    }
    @Test(groups="sanity")
    public static void mult() {
        int result = Calculator.mult(5, 5);
        Assert.assertEquals(result, 25);
    }
}
