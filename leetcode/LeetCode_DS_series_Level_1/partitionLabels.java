import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class partitionLabels {

}

class SolutionPratitionLabels {

    public static List<Integer> partitions(String str) {

        int len = str.length(); // Calculate the length of the given string
        List<Integer> answer = new ArrayList<>(); // make a list to store the answer

        // edge case - 1
        // If our string is having only one character then we don't need to follow rest
        // because
        // we can make only one partition here so directly storing the length and send
        // to calling method.

        if (len == 1) {
            answer.add(1);
            return answer;
        }

        // Actual Implimentation
        // Take two arrays of length 26 || --> Left & --> Right || we can name it
        // accordingly
        // Becaues we know there can be letters in between 0 - 26
        // Left is used to store the left most index of a character in the string
        // Right is used to store the right most index of a character in the string
        // Intially fill the array with -1

        int[] left = new int[26];
        int[] right = new int[26];
        int start_check = -1;
        int end_check = -1;

        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        // As we know that thw ascii value of small a-b ranges from 97-123 so we are
        // subtracting the value of every character
        // with 'a' to store them in the integer array as
        // a--> 0
        // b-> 1
        // c-> 2
        // d-> 3 this way upto z

        for (int i = 0; i < len; i++) {
            if (left[str.charAt(i) - 'a'] == -1) {
                left[str.charAt(i) - 'a'] = i;
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (right[str.charAt(i) - 'a'] == -1) {
                right[str.charAt(i) - 'a'] = i;
            }
        }

        int start = left[str.charAt(0) - 'a'];
        int end = right[str.charAt(0) - 'a'];

        if (end == len - 1) {
            answer.add(end - start + 1);
            return answer;
        }

        for (int i = 0; i < len; i++) {
            start_check = left[str.charAt(i) - 'a'];
            end_check = right[str.charAt(i) - 'a'];

            // Now here we are calulating the highest ending point of a character and lowest
            // starting point then using
            // those points we can easily calulate the length of the partition

            start = Math.min(start, start_check);
            end = Math.max(end, end_check);

            // edge case - ii
            // here we are checking that if we get our ending index as the last index of the
            // string
            // So no meaning of trevarsing until we reach the end just make a partion and
            // return answer because
            // our partion will incluede upto last index

            if (end == len - 1) {
                answer.add(end - start + 1);
                return answer;
            }
            if (end == i) {
                // when our end is equal to the current index then we can say we can make a
                // partition
                // As we reached our aximum ending index upto this current_index
                // So calulate the length and store the length in answer as result.

                // Now to start with new partition we have to change the starting and ending
                // point next after this partition.
                answer.add(end - start + 1);
                if (i + 1 < len) {
                    start = left[str.charAt(i + 1) - 'a'];
                    end = right[str.charAt(i + 1) - 'a'];
                }
            }
        }
        return answer;
        // returning answer
    }
}