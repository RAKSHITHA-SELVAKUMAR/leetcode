// Last updated: 7/17/2026, 3:15:01 PM
import java.util.*;

class Solution {
    public long maxRatings(int[][] units) {
        int m = units.length;

        long baseSum = 0;

        int[] minVal = new int[m];
        long[] gain = new long[m];

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < m; i++) {
            int[] row = units[i];
            int len = row.length;

            int smallest = Integer.MAX_VALUE;
            int second = Integer.MAX_VALUE;

            for (int x : row) {
                if (x < smallest) {
                    second = smallest;
                    smallest = x;
                } else if (x < second) {
                    second = x;
                }
            }

            baseSum += smallest;
            minVal[i] = smallest;
            set.add(smallest);

            long bestAfterRemoval;

            if (len == 1) {
                bestAfterRemoval = 0;
            } else {
                int cntMin = 0;
                for (int x : row) {
                    if (x == smallest) cntMin++;
                }

                if (cntMin >= 2) {
                    bestAfterRemoval = smallest;
                } else {
                    bestAfterRemoval = second;
                }
            }

            gain[i] = Math.max(0L, bestAfterRemoval - smallest);
        }

        int k = set.size();
        int[] vals = new int[k];
        int p = 0;

        for (int v : set) {
            vals[p++] = v;
        }

        HashMap<Integer, Integer> idxMap = new HashMap<>();

        for (int i = 0; i < k; i++) {
            idxMap.put(vals[i], i);
        }

        long[] G = new long[k];

        for (int i = 0; i < m; i++) {
            G[idxMap.get(minVal[i])] += gain[i];
        }

        long suffix = 0;
        for (int i = k - 1; i >= 0; i--) {
            suffix += G[i];
            G[i] = suffix;
        }

        long[] prefixBest = new long[k];
        long cur = Long.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            cur = Math.max(cur, G[i] + vals[i]);
            prefixBest[i] = cur;
        }

        long[] suffixBestG = new long[k + 1];
        long best = 0;

        for (int i = k - 1; i >= 0; i--) {
            best = Math.max(best, G[i]);
            suffixBestG[i] = best;
        }

        long answer = baseSum;

        for (int i = 0; i < m; i++) {
            int pos = idxMap.get(minVal[i]);

            long option1 = prefixBest[pos] - gain[i] - minVal[i];
            long option2 = suffixBestG[pos + 1];

            long extra = Math.max(0L, Math.max(option1, option2));

            answer = Math.max(answer, baseSum + extra);
        }

        return answer;
    }
}