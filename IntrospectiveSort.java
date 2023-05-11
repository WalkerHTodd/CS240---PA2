
/**
 * IntrospectiveSort class.
 * 
 * @author Walker Todd
 * @version 3/10/2023
 * 
 *          My work complies with the JMU Honor Code and if any help was recieved it was from a TA
 *          and was listed where the help was recieved
 */

public class IntrospectiveSort {

  /**
   * Sort the provided items using introspective sort.
   */
  public static <T extends Comparable<T>> void introspectiveSort(T[] items) {
    int maxDepth = (int) (2 * Math.floor(Math.log(items.length) / Math.log(2)));
    introSortHelper(items, 0, items.length - 1, maxDepth);
  }


  private static <T extends Comparable<T>> void introSortHelper(T[] items, int start, int end,
      int maxDepth) {
    // Ended up varying away from the sudo code and more towards an approach like mergesort
    if (maxDepth == 0) {
      MergeSortImproved.mergeSubsortAdaptive(items, start, end);
      //This was causing index out of bounds so I had to add an if statmnet to check the start end
      // like in the other merge methods
      // TA help here
    } else if (start < end) {
      // The Pivot point is inclusive
      int pivot = QuickSort.partition(items, start, end);

      // Left half of the list
      introSortHelper(items, start, pivot, maxDepth - 1);
      // Right half of the list
      introSortHelper(items, pivot + 1, end, maxDepth - 1);
    }
  }
}
