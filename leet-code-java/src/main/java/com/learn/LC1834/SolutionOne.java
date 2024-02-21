package com.learn.LC1834;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionOne {
    public int[] getOrder(int[][] tasks) {
        int time = 1;
        int tasksLength = tasks.length;
        int finishedTime = 1;
        int k = 0;
        int[] res = new int[tasksLength];
        int[][] tasksData = new int[tasksLength][3];
        for (int i = 0; i < tasksLength; i++) {
            tasksData[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> tasks[o1][1] - tasks[o2][1]);
        Arrays.sort(tasksData, (o1, o2) -> o1[0] - o2[0]);
        int enqueueIndex = 0;
        while (k < tasksLength) {
            for (; enqueueIndex < tasksLength && tasksData[enqueueIndex][0] == time; enqueueIndex++) {
                priorityQueue.add(enqueueIndex);
            }
            if (time >= finishedTime) {
                if (!priorityQueue.isEmpty()) {
                    int taskId = priorityQueue.poll();
                    finishedTime = time + tasksData[taskId][1];
                    res[k++] = tasksData[taskId][2];
                }
            }
            time++;
        }
        return res;
    }

//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new SolutionOne().getOrder(new int[][]{
//                {1, 2}, {2, 4}, {3, 2}, {4, 1},
//        })));
//    }
}