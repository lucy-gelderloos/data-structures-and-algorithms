# Selection Sort

Step-by-step diagrams of an insertion sorting algorithm.

## Pseudocode

```
  InsertionSort(int[] arr)

    FOR i = 1 to arr.length

      int j <-- i - 1
      int temp <-- arr[i]

      WHILE j >= 0 AND temp < arr[j]
        arr[j + 1] <-- arr[j]
        j <-- j - 1

      arr[j + 1] <-- temp
```

## Example Array

`[8, 4, 23, 42, 16, 15]`

## Step-Through

Begin the for loop:

![For loop iteration 1](../../../resources/cc-26-1.png)

Temp is less than arr[j] (4 is less than 8), so start the while loop:

![While loop iteration 1.A](../../../resources/cc-26-1-A.png)

j is less than 0, so return to the for loop:

![For loop iteration 2](../../../resources/cc-26-2.png)

![For loop iteration 3](../../../resources/cc-26-3.png)

![For loop iteration 4](../../../resources/cc-26-4.png)

Temp is less than arr[j] (16 is less than 42), so start the while loop:

![While loop iteration 4.A](../../../resources/cc-26-4-A.png)

![While loop iteration 4.B](../../../resources/cc-26-4-B.png)

Temp is greater than arr[j] (16 is greater than 8), so return to the for loop:

![For loop iteration 5](../../../resources/cc-26-5.png)

Temp is less than arr[j] (15 is less than 42), so start the while loop:

![While loop iteration 5.A](../../../resources/cc-26-5-A.png)

![While loop iteration 5.B](../../../resources/cc-26-5-B.png)

![While loop iteration 5.C](../../../resources/cc-26-5-C.png)

Temp is greater than arr[j] (15 is greater than 8), so return to the for loop:

![For loop iteration 6](../../../resources/cc-26-6.png)

i is greater than arr.length; return sorted array.
