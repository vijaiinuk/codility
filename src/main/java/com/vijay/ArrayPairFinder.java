package com.vijay;

import java.util.Arrays;

/**
 * Created by Vijay on 2/9/2017.
 */
public class ArrayPairFinder {
    public int findPairs(int[] inputArray) {
        int pairCount = 0;
        if(inputArray != null && inputArray.length < 2)
            return pairCount;

        for (int i = 0; i < inputArray.length-1; i++) {
            for(int j = i+1; j<inputArray.length; j++)  {
                if(inputArray[i] == inputArray[j])
                    pairCount++;
            }
        }
        return pairCount;
    }
}
