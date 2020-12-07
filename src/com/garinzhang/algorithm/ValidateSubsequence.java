package com.garinzhang.algorithm;

import java.util.*;

public class ValidateSubsequence {
    class SolutionI {
        public boolean validateSubsequence(List<Integer> array, List<Integer> sequence) {
            int arrayIndex = 0;
            int sequenceIndex = 0;
            while (arrayIndex < array.size() && sequenceIndex < sequence.size()) {
                if (sequence.get(sequenceIndex) == array.get(arrayIndex)) {
                    sequenceIndex ++;
                }
                arrayIndex ++;
            }
            return sequenceIndex == sequence.size();
        }
    }

    class SolutionII {
        public boolean validateSubsequence(List<Integer> array, List<Integer> sequence) {
            int sequenceIndex = 0;
            for (int item : array) {
                if (sequenceIndex >= sequence.size()) {
                    break;
                }
                if (sequence.get(sequenceIndex) == item) {
                    sequenceIndex ++;
                }
            }
            return sequenceIndex == sequence.size();
        }
    }
}