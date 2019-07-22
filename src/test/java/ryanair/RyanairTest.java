package ryanair;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RyanairTest {

    @Test
    void sum(){
        int a = 10;
        int b = 12;
        Assert.assertEquals(a + b, 22);
    }

    @Test
    void subtract(){
        int a = 10;
        int b = 12;
        Assert.assertEquals(b - a, 2);
    }

    @Test
    void multipl(){
        int a = 10;
        int b = 12;
        Assert.assertEquals(a * b, 120);
    }
}


