package Binary_Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class minimumTimetoInfectATree {
    public int amountOfTime(TreeNode root, int start) {

        Map<Integer, Set<Integer>> adj = new HashMap<>();
        Queue<Integer> helper = new LinkedList<>();
        makeGraph(root, adj);
        System.out.println(adj);
        int time = 0;
        int maxNode = Integer.MIN_VALUE;
        for (Integer keys : adj.keySet()) {
            maxNode = Math.max(keys, maxNode);
        }
        helper.offer(start);

        boolean[] infected = new boolean[maxNode + 1];
        infected[start] = true;
        while (!helper.isEmpty()) {

            boolean flag = false;
            int size = helper.size();
            while (size > 0) {
                int node = helper.poll();
                infected[node] = true;
                for (int nodes : adj.get(node)) {

                    if (!infected[nodes]) {
                        flag = true;
                        helper.offer(nodes);
                    }
                }
                size--;
            }
            if (flag)
                time++;
        }

        return time;

    }

    private static void makeGraph(TreeNode root, Map<Integer, Set<Integer>> adj) {

        if (root == null)
            return;
        makeGraph(root.left, adj);
        makeGraph(root.right, adj);
        adj.put(root.val, new HashSet<>());
        if (root.left != null) {
            adj.get(root.val).add(root.left.val);
            adj.get(root.left.val).add(root.val);
        }
        if (root.right != null) {
            adj.get(root.val).add(root.right.val);
            adj.get(root.right.val).add(root.val);
        }

    }
}