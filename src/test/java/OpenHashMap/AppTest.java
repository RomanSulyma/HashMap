package OpenHashMap;

import OpenHashMap.map.AbstractHashMap;
import OpenHashMap.map.HashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    private final AbstractHashMap hashMap = new HashMap(10);

    /**
     * Test map positive result
     */
    @Test
    public void testMapPositive()
    {
        final int firstKey = 10;
        final int secondKey = 30;
        final int thirdKey = 50;

        final int firstValue = 20;
        final int secondValue = 40;
        final int thirdValue = 60;

        hashMap.put(firstKey, firstValue);
        hashMap.put(secondKey, secondValue);
        hashMap.put(thirdKey, thirdValue);

        Assert.assertEquals(firstValue, hashMap.get(firstKey));
        Assert.assertEquals(secondValue, hashMap.get(secondKey));
        Assert.assertEquals(thirdValue, hashMap.get(thirdKey));
    }

    /**
     * Test map for negative result
     */
    @Test
    public void testMapNegative()
    {
        final int key = 10;

        final int firstValue = 20;
        final int secondValue = 30;
        final int thirdValue = 40;

        hashMap.put(key, firstValue);
        hashMap.put(key, secondValue);
        hashMap.put(key, thirdValue);

        Assert.assertNotEquals(firstValue, hashMap.get(key));
        Assert.assertNotEquals(secondValue, hashMap.get(key));
        Assert.assertEquals(thirdValue, hashMap.get(key));
    }
}
