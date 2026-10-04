package com.shinra.xeno.utility.sorts;

/*
 * MergeSort
 *
 * Sorts array items using merge sort
 */

public class MergeSort
{
    //Merge sort
    public static<T extends Comparable<? super T>> T[] mergesort(T[ ] sortArray)
    {
        //Declare temporary array used for merge
        T[] tempArray = (T[])new Comparable<?>[sortArray.length];
        T[] sortedArray = mergesort(sortArray, tempArray, 0, sortArray.length - 1 );
        return sortedArray;
    }

    //Merge function used by mergesort
    private static<T extends Comparable<? super T>>
    T[] merge(T[] sortArray, T[] tempArray, int first, int mid, int last)
    {

        int first1 = first;    //beginning of first subarray
        int last1  = mid;      //end of first subarray
        int first2 = mid + 1;  //beginning of second subarray
        int last2  = last;     //end of second subarray
        int index = first1;    //next available location in tempArray

        //Check index limits
        while ((first1 <= last1) && (first2 <= last2))
        {
            //If item in first list is before item in second list
            if (sortArray[first1].compareTo(sortArray[first2])<0)
            {
                //Set temp array item with first list item since it is before item in second list, increment beginning array index
                tempArray[index] = sortArray[first1];
                first1++;
            }
            //Do the same but for second list
            else
            {
                tempArray[index] = sortArray[first2];
                first2++;
            }
            index++;
        }

        //Check first list index limit
        while (first1 <= last1)
        {
            tempArray[index] = sortArray[first1];
            first1++;
            index++;
        }
        //Check second list index limits
        while (first2 <= last2)
        {
            tempArray[index] = sortArray[first2];
            first2++;
            index++;
        }

        //Get new sorted array from temp array
        for (index = first; index <= last; ++index)
        {
            sortArray[index] = tempArray[index];
        }

        return sortArray;
    }

    //Helper function used by mergesort
    private static <T extends Comparable<? super T>> T[] mergesort(T[] sortArray, T[] tempArray, int first, int last)
    {   T[] sortedArray = null;
        if (first < last)
        {
            int mid = (first + last)/2;   //index of midpoint
            mergesort(sortArray, tempArray, first, mid);
            mergesort(sortArray, tempArray, mid+1, last);

            sortedArray = merge(sortArray, tempArray, first, mid, last);
        }
        return sortedArray;
    }
}

