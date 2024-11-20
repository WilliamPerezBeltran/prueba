public class SolutionA {

    public static int countOccurrences(int[] sortedArray, int target) {
        int firstIndex = binarySearchFirst(sortedArray, target);
        if (firstIndex == -1) {
            return 0;
        }

        int count = 1;
        int index = firstIndex + 1;

        while (index < sortedArray.length && sortedArray[index] == target) {
            count++;
            index++;
        }

        return count;
    }

    private static int binarySearchFirst(int[] sortedArray, int target) {
        int left = 0;
        int right = sortedArray.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedArray[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (sortedArray[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
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


