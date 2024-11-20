public class SolutionB {

    public static int countOccurrences(int[] arr, int target) {
        int count = 0;

        for (int num : arr) {
            if (num == target) {
                count++;
            }
            if (num > target) {
                break;
            }
        }

        return count;
    }

    public static void test(int[] array, int target, int expected) {
        int result = countOccurrences(array, target);
        System.out.println("Test Case: The number " + target + " appears " + result + " times. ====> Expectation " + (result == expected));
    }

    public static void main(String[] args) {
        test(new int[]{1, 2, 3, 3, 4, 5}, 3, 2);

        test(new int[]{1, 2, 3, 4, 5}, 4, 1);

        test(new int[]{1, 1, 1, 1, 1, 1}, 1, 6);

        test(new int[]{}, 3, 0);

        test(new int[]{3, 3, 3, 3, 3, 3}, 3, 6);

        test(new int[]{1, 2, 3, 3, 4, 5}, 3, 2);

        test(new int[]{1, 2, 3, 4, 5, 6, 6}, 6, 2);

        test(new int[]{1}, 1, 1);

        test(new int[]{1, 2, 3, 4, 5}, 6, 0);

        test(new int[]{1, 2, 2, 2, 3, 3, 3}, 2, 3);

        test(new int[]{1, 1}, 1, 2);
    }
}
