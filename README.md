# Test

### Question

Write a method that takes two parameters. The first parameter is an array of integers that has already been sorted from smallest to largest. The second parameter is an integer. The method should return the number of times the second parameter appears in the first parameter.

**Example:**
If the first parameter is `[1, 2, 3, 3, 4, 5]` and the second parameter is `3`, the method should return `2`.
---

#### SolutionA: Algorithm Explanation
The SolutionA class counts the occurrences of a target value in a sorted array. It first uses the `binarySearchFirst` method to find the index of the first occurrence of the target using binary search, which ensures a time complexity of O(log n). If the target is found, it then counts the subsequent occurrences of the target by iterating through the array starting from the first found index.

This approach efficiently handles sorted arrays by combining binary search with a linear scan for counting. The overall time complexity is O(log n + k), where `k` is the number of occurrences of the target. This makes the solution scalable for large arrays, especially when the target value appears multiple times.
---

#### SolutionA: Java Method Implementation

```java
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
}

```

#### SolutionB: Algorithm Explanation
The SolutionB class counts the occurrences of a target value in a sorted array by iterating through the array. It maintains a count variable, which is incremented whenever the target value is found. If a value greater than the target is encountered, the loop terminates early, taking advantage of the sorted nature of the array to avoid unnecessary checks.

This method works well for sorted arrays because once a value greater than the target is encountered, further values cannot be the target, allowing the function to exit early and optimize performance. The time complexity is O(n) in the worst case, where `n` is the size of the array, but it can be faster if the target is found early or if the loop breaks prematurely. However, for very large arrays with many occurrences of the target, this method might be slower compared to binary search-based approaches.
---

#### SolutionB: Java Method Implementation
```java
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
}

```
### tree

```bash
.
├── README.md
├── SolutionA.class
├── SolutionA.java
├── SolutionB.class
└── SolutionB.java

```

### Java Version Information

```bash
java -version
openjdk version "17.0.12" 2024-07-16
OpenJDK Runtime Environment (build 17.0.12+7-Ubuntu-1ubuntu220.04)
OpenJDK 64-Bit Server VM (build 17.0.12+7-Ubuntu-1ubuntu220.04, mixed mode, sharing)
```

### How to Execute the Java Files

To execute the Java files `SolutionA.java` and `SolutionB.java`, follow these steps:

1. **Open the terminal** (Linux/macOS) or Command Prompt (Windows).
2. **Navigate to the directory** where the `.java` files are located. You can do this using the `cd` command. For example:

   ```bash
   cd path/to/your/files
```
### Compile and Run Java Files

To compile the Java files, use the `javac` command. This will create `.class` files in the same directory:

```bash
javac SolutionA.java
javac SolutionB.java

java SolutionA.java
java SolutionB.java
```
