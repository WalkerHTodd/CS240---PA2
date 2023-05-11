import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

/*
 * Test Driver Class - Sort Profiler
 * 
 * @author Walker Todd
 * 
 * @version 3/10/2023
 * 
 * My work complies with the JMU Honor Code and if any help was recieved it was from a TA and was
 * listed where the help was recieved
 */
class SortProfilerTest<T extends Comparable<T>> {
  public static void main(String[] args) {
    // Random Arrays slightly slower
    // Pathological faster with introspective

    // Create a SortProfiler object.
    // See the JavaDoc for an explanation of the parameters.

    // sorts
    // Names
    // starting input
    // interval
    // max
    // trials
    // gen The sequence generator to use

    // Run the profiler and send the output to stdout.
    // Our Merge Sort
    // Quick Sort
    SortProfiler figure1test = new SortProfiler(
        List.of(MergeSortImproved::mergeSortHalfSpace, MergeSort::mergeSort, QuickSort::quickSort),
        List.of("mergeSortHalfSpace", "Orignal Merge Sort", "QuickSort", ""), 1000, 1000, 10000,
        10000, Generators::generateRandom);

    SortProfiler figure3test = new SortProfiler(
        List.of(MergeSortImproved::mergeSortAdaptive, MergeSortImproved::mergeSortHalfSpace,
            MergeSort::mergeSort, QuickSort::quickSort),
        List.of("MergeSortAdaptive", "mergeSortHalfSpace", "Orignal Merge Sort", "QuickSort", ""),
        1000, 1000, 10000, 10000, Generators::generateRandom);

    SortProfiler figure4test =
        new SortProfiler(List.of(IntrospectiveSort::introspectiveSort, QuickSort::quickSort),
            List.of("introspectiveSort", "quickSort"), 1000, 1000, 10000, 10000,
            Generators::generateRandom);

    SortProfiler figure5test =
        new SortProfiler(List.of(IntrospectiveSort::introspectiveSort, QuickSort::quickSort),
            List.of("introspectiveSort", "quickSort"), 1000, 1000, 10000, 1000,
            Generators::generateEvil);

    SortProfiler figure2test = new SortProfiler(List.of(MergeSortImproved::mergeSortAdaptive),
        List.of("introspectiveSort", "quickSort"), 10, 1, 50, 200000, Generators::generateRandom);


    figure3test.run(System.out);
  }

  @Test
  void mergeThreshHoldTest() {

    Integer[] array3 = new Integer[] {1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 11, 15, 12};
    Integer[] arrayCorrect1 = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15};

    MergeSortImproved.mergeSortAdaptive(array3);
    Assert.assertArrayEquals(arrayCorrect1, array3);

    Integer[] array1 = new Integer[] {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
    Integer[] arrayCorrect = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    MergeSortImproved.mergeSortAdaptive(array1);
    Assert.assertArrayEquals(arrayCorrect, array1);

    Integer[] array2 = new Integer[] {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};

    MergeSortImproved.mergeSortAdaptive(array2);
    Assert.assertArrayEquals(arrayCorrect, array2);

  }

  @Test
  void MergeImprovedTest() {
    Integer[] array3 = new Integer[] {1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 11, 15, 12};
    Integer[] arrayCorrect1 = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15};

    MergeSortImproved.mergeSortAdaptive(array3);
    Assert.assertArrayEquals(arrayCorrect1, array3);

    Integer[] array1 = new Integer[] {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
    Integer[] arrayCorrect = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    MergeSortImproved.mergeSortHalfSpace(array1);
    Assert.assertArrayEquals(arrayCorrect, array1);

    Integer[] array2 = new Integer[] {2, 3, 8, 7, 9, 1, 4, 6, 5, 10};

    MergeSortImproved.mergeSortHalfSpace(array2);
    Assert.assertArrayEquals(arrayCorrect, array2);
  }

  @Test
  void introspectiveSortTest() {


    Integer[] array1 = new Integer[] {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
    Integer[] arrayCorrect = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    IntrospectiveSort.introspectiveSort(array1);
    Assert.assertArrayEquals(arrayCorrect, array1);

    Integer[] array2 = new Integer[] {2, 3, 8, 7, 9, 1, 4, 6, 5, 10};

    IntrospectiveSort.introspectiveSort(array2);
    Assert.assertArrayEquals(arrayCorrect, array2);
  }

  @Test
  void insertionSubsortTest() {
    Integer[] array3 = new Integer[] {1, 3, 5, 7, 9, 2, 4, 6, 8, 10, 11, 15, 12};
    Integer[] arrayCorrect1 = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15};

    BasicSorts.insertionSubsort(array3, 0, array3.length - 1);
    Assert.assertArrayEquals(arrayCorrect1, array3);
    
    Integer[] array1 = new Integer[] {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
    Integer[] arrayCorrect = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    BasicSorts.insertionSubsort(array1, 0, array1.length - 1);
    Assert.assertArrayEquals(arrayCorrect, array1);

  }
}
