package com.vijay;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vijay on 2/9/2017.
 */
public class ArrayPairFinder {
    public int findPairs(int[] inputArray) {
        int pairCount = 0;
        if(inputArray == null || inputArray.length < 2)
            return pairCount;

        Arrays.sort(inputArray);
        int start = 0;
        Map<Integer, Integer> pairMap = new HashMap<>();

        for (int i = 1; i < inputArray.length; i++) {
            if(inputArray[start] == inputArray[i])  {
                int count = 0;
                if(pairMap.containsKey(inputArray[start])) {
                    count = pairMap.get(inputArray[start]);
                }
                pairMap.put(inputArray[start], count+1);
            }
            start = i;
        }

        System.out.println(pairMap);
        for(int i : pairMap.values())  {
            pairCount += (i+1) * i/2;
        }
        return pairCount;
    }
}
