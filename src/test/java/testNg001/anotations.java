package testNg001;
import org.java001.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;
public class anotations {

    @Test (groups = {"unit","sanity"},enabled = false )
    public static void testAdd() {
        int result = Calculator.add(2, 3);
        Assert.assertEquals(result, 5);
    }
 @Test (groups="unit")
 @ BeforeSuite
    public static void sub(){
        int result= Calculator.sub(3,3);
        Assert.assertEquals(result,0);
 }
 @Test (groups="unit")
 @BeforeClass
    public static void div(){
        int result = Calculator.div(4,2);
        Assert.assertEquals(result,2);
     System.out.println("THIS IS BEFORE UNIT");
 }
 @Test(groups="sanity")
 @BeforeMethod
    public static void mult(){
        int result= Calculator.mult(5,5);
        Assert.assertEquals(result,25);
        System.out.println("THIS IS BEFORE METHODS");
 }
 @Test (groups="sanity")
 @AfterTest
    public static void mod(){
        int result= Calculator.mod(10,2);
        Assert.assertEquals(result,0);
        System.out.println("THIS IS AFTER TEST");
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
        @AfterClass
           public void testAdd(int a, int b, int expectedSum){
            int result = Calculator.add(a, b);
            Assert.assertEquals(result, expectedSum);
            System.out.println("THIS IS AFTER CLASS");

        }
        }

