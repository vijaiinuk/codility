package com.vijay;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vijay on 2/9/2017.
 */
public class ArrayPairFinderTest {


    @Test
    public void testInitial()  {

        ArrayPairFinder arrayPairFinder = new ArrayPairFinder();

        assertEquals(0, arrayPairFinder.findPairs(new int[]{1,2,3}));

        assertEquals(1, arrayPairFinder.findPairs(new int[]{1,1}));

        assertEquals(3, arrayPairFinder.findPairs(new int[]{1,2,3,3,2,1}));

        assertEquals(3, arrayPairFinder.findPairs(new int[]{1,2,3,3,2,1,0}));

    }


}
