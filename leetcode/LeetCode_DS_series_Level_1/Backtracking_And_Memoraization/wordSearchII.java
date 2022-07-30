package Backtracking_And_Memoraization;

import java.util.ArrayList;
import java.util.List;

class Node {

    Node[] nextnodes = null;
    String st;

    Node() {
        nextnodes = new Node[26];
    }

    void insert(Node current, String str) {
        for (int index = 0; index < str.length(); index++) {
            if (current.nextnodes[str.charAt(index) - 'a'] == null) {
                current.nextnodes[str.charAt(index) - 'a'] = new Node();
            }
            current = current.nextnodes[str.charAt(index) - 'a'];
        }
        this.st = str;
    }
}

class Solution {
    static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public List<String> findWords(char[][] board, String[] words) {

        List<String> answer = new ArrayList<>();
        if (words.length == 0)
            return answer;
        Node root = new Node();

        for (String word : words) {
            root.insert(root, word);
        }
        for (int index = 0; index < board.length; index++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, answer, index, j);
            }
        }
        return answer;
    }

    private static boolean dfs(char[][] board, Node root, List<String> answer, int r, int c) {

        if (r < 0 || c < 0 || r == board.length || c == board[0].length || root.nextnodes[board[r][c] - 'a'] == null)
            return false;
        if (board[r][c] == '#')
            return false;

        if (root.st != null) {
            answer.add(root.st);
            return true;
        }
        boolean res = false;
        char x = board[r][c];
        board[r][c] = '#';
        for (int[] paths : dirs) {
            res = dfs(board, root, answer, r + paths[0], c + paths[1]);
            if (res)
                break;
        }
        board[r][c] = x;
        if (res)
            return true;
        return false;
    }
}
