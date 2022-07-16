import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int len = rooms.size();
        if (len == 0)
            return true;
        Queue<List<Integer>> helper = new LinkedList<>();
        boolean[] visited = new boolean[len];
        visited[0] = true;
        helper.add(rooms.get(0));
        while (!helper.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>(helper.peek());
            int size = temp.size() - 1;
            helper.poll();
            while (size >= 0) {
                if (!visited[temp.get(size)]) {
                    helper.add(rooms.get(temp.get(size)));
                    visited[temp.get(size)] = true;
                }
                size--;
            }
        }
        for (int index = 0; index < len; index++)
            if (!visited[index])
                return false;
        return true;
    }

    /*
     * Anpther Approach using adjacency List
     */

}