# Merge Sort

Step-by-step diagrams of a merge sorting algorithm. [See the code](../MergeSort.javaava) | [See the tests](../../../../../test/java/datastructures/sorting/sortingTest.java).

## Pseudocode

```
ALGORITHM Mergesort(arr)
    DECLARE n <-- arr.length

    if n > 1
      DECLARE mid <-- n/2
      DECLARE left <-- arr[0...mid]
      DECLARE right <-- arr[mid...n]
      // sort the left side
      Mergesort(left)
      // sort the right side
      Mergesort(right)
      // merge the sorted left and right sides together
      Merge(left, right, arr)

ALGORITHM Merge(left, right, arr)
    DECLARE i <-- 0
    DECLARE j <-- 0
    DECLARE k <-- 0

    while i < left.length && j < right.length
        if left[i] <= right[j]
            arr[k] <-- left[i]
            i <-- i + 1
        else
            arr[k] <-- right[j]
            j <-- j + 1

        k <-- k + 1

    if i = left.length
       set remaining entries in arr to remaining values in right
    else
       set remaining entries in arr to remaining values in left

```

## Example Array

`[8, 4, 23, 42, 16, 15]`

## Step-Through

Call mergeSort on the array:

![Code challenge 27, step 1](../../../resources/cc-27-01.png)

n is greater than 1, so:

![Code challenge 27, step 2](../../../resources/cc-27-02.png)

Call mergeSort on left:

![Code challenge 27, step 3](../../../resources/cc-27-03.png)

n is greater than 1, so:

![Code challenge 27, step 4](../../../resources/cc-27-04.png)

Call mergeSort on left:

![Code challenge 27, step 5](../../../resources/cc-27-05.png)

n is greater than 1, so:

![Code challenge 27, step 6](../../../resources/cc-27-06.png)

Call mergeSort on left:

![Code challenge 27, step 7](../../../resources/cc-27-07.png)

n is 1, so call mergeSort on right:

![Code challenge 27, step 8](../../../resources/cc-27-08.png)

n is also 1, so call merge on left, right, array:

![Code challenge 27, step 9](../../../resources/cc-27-09.png)

left[i] is greater than right[j] (8 is greater than 4), so array[k] becomes right[j]; increment j and k:

![Code challenge 27, step 10](../../../resources/cc-27-10.png)

j is not less than right.length and i does not equal left.length, so set remaining entries in array to entries in left:

![Code challenge 27, step 11](../../../resources/cc-27-11.png)

Return to the previous function in the call stack with sorted left:

![Code challenge 27, step 12](../../../resources/cc-27-12.png)

Call mergeSort on right:

![Code challenge 27, step 13](../../../resources/cc-27-13.png)

n is one, so call merge on left, right, array:

![Code challenge 27, step 14](../../../resources/cc-27-14.png)

left[i] is not greater than right[j] (4 is not greater than 23), so array[k] becomes left[i]; increment i and k:

![Code challenge 27, step 15](../../../resources/cc-27-15.png)

left[i] is not greater than right[j] (8 is not greater than 23), so array[k] becomes left[i]; increment i and k:

![Code challenge 27, step 16](../../../resources/cc-27-16.png)

i is not less than left.length; i equals left.length, so fill all remaining spots in array with all remaining values in right:

![Code challenge 27, step 17](../../../resources/cc-27-17.png)

Return to the previous function in the call stack with sorted left:

![Code challenge 27, step 18](../../../resources/cc-27-18.png)

Call mergeSort on right:

![Code challenge 27, step 19](../../../resources/cc-27-19.png)

n is greater than one, so:

![Code challenge 27, step 20](../../../resources/cc-27-20.png)

Call mergeSort on left:

![Code challenge 27, step 21](../../../resources/cc-27-21.png)

n is greater than one, so:

![Code challenge 27, step 22](../../../resources/cc-27-22.png)

Call mergeSort on left:

![Code challenge 27, step 23](../../../resources/cc-27-23.png)

n is one, so call mergeSort on right:

![Code challenge 27, step 24](../../../resources/cc-27-24.png)

n is also one, so call merge on right, left, array:

![Code challenge 27, step 25](../../../resources/cc-27-25.png)

left[i] is greater than right[j] (42 is greater than 16), so array[k] becomes right[j]; increment j and k:

![Code challenge 27, step 26](../../../resources/cc-27-26.png)

j is not less than right.length and i does not equal left.length, so set remaining entries in array to entries in left:

![Code challenge 27, step 27](../../../resources/cc-27-27.png)

Return to the previous function in  the call stack with sorted left:

![Code challenge 27, step 28](../../../resources/cc-27-28.png)

Call mergesort on right:

![Code challenge 27, step 29](../../../resources/cc-27-29.png)

n is one, so call merge on left, right, array:

![Code challenge 27, step 30](../../../resources/cc-27-30.png)

left[i] is greater than right[j] (16 is greater than 15), so array[k] becomes right[j]; increment j and k:

![Code challenge 27, step 31](../../../resources/cc-27-31.png)

j is not less than right.length; i is less than left.length, so fill all remaining spots in arr with all remaining values in left:

![Code challenge 27, step 32](../../../resources/cc-27-32.png)

Return to the previous function in the call stack with sorted right:

![Code challenge 27, step 33](../../../resources/cc-27-33.png)

Call merge on left, right, array:

![Code challenge 27, step 34](../../../resources/cc-27-34.png)

left[i] is not greater than right[j] (4 is not greater than 15), so array[k] becomes left[i]; increment i and k:

![Code challenge 27, step 35](../../../resources/cc-27-35.png)

left[i] is not greater than right[j] (8 is not greater than 15), so array[k] becomes left[i]; increment i and k:

![Code challenge 27, step 36](../../../resources/cc-27-36.png)

left[i] is greater than right[j] (23 is greater than 15), so array[k] becomes right[j]; increment j and k:

![Code challenge 27, step 37](../../../resources/cc-27-37.png)

left[i] is greater than right[j] (23 is greater than 16), so array[k] becomes right[j]; increment j and k:

![Code challenge 27, step 38](../../../resources/cc-27-38.png)

left[i] is not greater than right[j] (23 is not greater than 42), so array[k] becomes left[i]; increment i and k:

![Code challenge 27, step 39](../../../resources/cc-27-39.png)

i is not less than left.length; i equals left.length, so fill all remaining spots in arr with all remaining values in right:

![Code challenge 27, step 40](../../../resources/cc-27-40.png)

Return sorted array.

