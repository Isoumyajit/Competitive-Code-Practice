
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class spiralMatrix_IV {
    public int[][] spiralMatrix(int m, int n, ListNode head) {

        int[][] mat = new int[m][n];
        for (int index = 0; index < m; index++) {
            for (int j = 0; j < n; j++) {
                mat[index][j] = -1;
            }
        }
        ListNode temp = head;
        if (temp == null) {
            return mat;
        }
        if (temp.next == null) {
            mat[0][0] = temp.val;
            return mat;
        }

        int r = 0;
        int c = 0;

        while (temp != null && r < m && c < n) {

            for (int i = c; i < n; i++) {

                if (temp != null) {
                    mat[r][i] = temp.val;
                    temp = temp.next;
                } else {
                    return mat;
                }
            }
            r++;
            for (int i = r; i < m; i++) {
                if (temp != null) {
                    mat[i][n - 1] = temp.val;
                    temp = temp.next;
                } else
                    return mat;
            }
            n--;

            for (int i = n - 1; i >= c; i--) {
                if (temp != null) {
                    mat[m - 1][i] = temp.val;
                    temp = temp.next;
                } else
                    return mat;
            }
            m--;

            for (int i = m - 1; i >= r; i--) {
                if (temp != null) {
                    mat[i][c] = temp.val;
                    temp = temp.next;
                } else
                    return mat;
            }
            c++;
        }
        return mat;
    }
}