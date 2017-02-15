package com.vijay;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vijay on 2/9/2017.
 */
public class ArrayPairFinderTest {

    ArrayPairFinder arrayPairFinder;

    @Before
    public void setup()  {
        arrayPairFinder = new ArrayPairFinder();
    }

    @Test
    public void testInitial_with_invalid_inputs()  {
        assertEquals(0, arrayPairFinder.findPairs(null));
    }

    @Test
    public void testPair_with_valid_inputs()  {

        assertEquals(0, arrayPairFinder.findPairs(new int[]{1,2,3}));

        assertEquals(1, arrayPairFinder.findPairs(new int[]{1,1}));

        assertEquals(3, arrayPairFinder.findPairs(new int[]{1,2,3,3,2,1}));

        assertEquals(3, arrayPairFinder.findPairs(new int[]{1,2,3,3,2,1,0}));

    }

}
