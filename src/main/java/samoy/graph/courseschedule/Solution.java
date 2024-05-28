package samoy.graph.courseschedule;

import java.util.*;

/**
 * @link <a href="https://leetcode.cn/problems/course-schedule/?envType=study-plan-v2&envId=top-100-liked">课程表</a>
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 创建邻接列表，存储课程之间的依赖关系
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        // 填充邻接列表，根据先修课程关系
        for (int[] cp : prerequisites) {
            adjacency.get(cp[1]).add(cp[0]); // 课程 cp[1] 依赖于课程 cp[0]
        }

        // 标记数组，用于记录每个课程是否被访问过（-1表示已访问，1表示第二次访问，表示有环）
        int[] flags = new int[numCourses];

        // 对每个课程进行深度优先搜索，如果发现环则返回false
        for (int i = 0; i < numCourses; i++) {
            if (dfs(adjacency, flags, i)) return false; // 如果某次DFS返回true，说明有环，无法完成所有课程
        }

        // 如果所有课程都经过了DFS并且没有发现环，则可以完成所有课程
        return true;
    }

    // 深度优先搜索方法，检查课程i是否可以通过，返回true表示有环，false表示没有环
    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        // 如果当前课程已被访问过（第二次访问，表示有环）
        if (flags[i] == 1) return true;
        // 如果当前课程未访问过（第一次访问）
        if (flags[i] == -1) return false;

        // 标记当前课程为已访问
        flags[i] = 1;

        // 对当前课程的所有依赖课程进行递归检查
        for (Integer j : adjacency.get(i)) {
            if (dfs(adjacency, flags, j)) return true; // 如果发现环，返回true
        }

        // 如果没有发现环，将当前课程标记为已完全访问
        flags[i] = -1;
        return false;
    }
}
