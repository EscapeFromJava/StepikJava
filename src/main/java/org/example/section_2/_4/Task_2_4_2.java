package org.example.section_2._4;

public class Task_2_4_2 {
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        int pos1 = 0, pos2 = 0;
        while (pos1 < a1.length && pos2 < a2.length) {
            if (a1[pos1] < a2[pos2]) {
                result[pos1 + pos2] = a1[pos1];
                pos1++;
            } else {
                result[pos1 + pos2] = a2[pos2];
                pos2++;
            }
        }
        if (pos1 == a1.length) {
            while(pos2 < a2.length){
                result[pos1 + pos2] = a2[pos2];
                pos2++;
            }
        } else {
            while(pos1 < a1.length){
                result[pos1 + pos2] = a1[pos1];
                pos1++;
            }
        }
        return result;
    }
}
