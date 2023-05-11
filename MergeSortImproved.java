
/**
 * Improved MergeSort methods.
 * 
 * @author Walker Todd
 * @version 3/10/2023
 * 
 *          My work complies with the JMU Honor Code and if any help was recieved it was from a TA
 *          and was listed where the help was recieved
 */
public class MergeSortImproved {

  /**
   * Merge sort the provided array using an improved merge operation.
   */
  public static <T extends Comparable<T>> void mergeSortHalfSpace(T[] items) {
    mergeSortHelper(items, 0, items.length - 1);
  }

  private static <T extends Comparable<T>> void mergeSortHelper(T[] items, int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;

      mergeSortHelper(items, start, mid);
      mergeSortHelper(items, mid + 1, end);
      mergeHelper(items, start, mid, end);
    }
  }

  private static <T extends Comparable<T>> void mergeHelper(T[] items, int start, int mid,
      int end) {
    int tmpIndex = 0;
    // == start?
    int rightIndex = mid + 1;
    // Pointing to the next empty slot
    int mergeIndex = start;

    // TA Help from Zack on bascilly this whole method
    // Walked through most of it and helped debug with me in order to find
    // cause of index out of bounds
    @SuppressWarnings("unchecked")
    T[] left = (T[]) new Comparable[mid - start + 1];

    // Got TA Help from Alyssa Sharp
    for (int i = 0; i < left.length; i++) {
      if (i >= items.length) {
        break;
      }
      left[i] = items[start + i];
    }

    int leftSection = left.length - 1;

    // Got TA Help from Alyssa Sharp
    while (tmpIndex <= leftSection && rightIndex <= end) {
      if (left[tmpIndex].compareTo(items[rightIndex]) <= 0) {
        items[mergeIndex] = left[tmpIndex];
        tmpIndex++;
      } else {
        items[mergeIndex] = items[rightIndex];
        rightIndex++;
      }
      mergeIndex++;
    }
    // TA help here as well to find the leftsection peice and understand that
    while (tmpIndex <= leftSection) {
      items[mergeIndex] = left[tmpIndex];
      tmpIndex++;
      mergeIndex++;
    }

    while (rightIndex <= end) {
      items[mergeIndex] = items[rightIndex];
      rightIndex++;
      mergeIndex++;
    }
  }

  /**
   * Merge sort the provided array by using an improved merge operation and switching to insertion
   * sort for small sub-arrays.
   */
  public static <T extends Comparable<T>> void mergeSortAdaptive(T[] items) {
    mergeSortAdaptiveHelper(items, 0, items.length - 1);
  }

  // My merge threshold is sometimes being the same for 80
  // 13, 27, 11 are all providing relatively the same average time for execution
  static final int MERGE_SORT_THRESHOLD = 13;

  private static <T extends Comparable<T>> void mergeSortAdaptiveHelper(T[] items, int start,
      int end) {
    if (end - start + 1 <= MERGE_SORT_THRESHOLD) {
      // end - start + 1
      BasicSorts.insertionSubsort(items, start, end);
    } else if (start < end) {
      // I got TA help here from Joselyn to find hte start mid point
      // Was originally using int mid = (start + end) / 2; but it was
      // Causing an overflow because of how the mid point is being found
      int mid = start + (end - start) / 2;
      mergeSortAdaptiveHelper(items, start, mid);
      mergeSortAdaptiveHelper(items, mid + 1, end);
      mergeHelper(items, start, mid, end);
    }
  }


  /**
   * Merge sort the provided sub-array using our improved merge sort. This is the fallback method
   * used by introspective sort.
   */
  public static <T extends Comparable<T>> void mergeSubsortAdaptive(T[] items, int start, int end) {
    // Basically just calling the other helper with the start and end index we want
    mergeSortAdaptiveHelper(items, start, end);
  }
}
