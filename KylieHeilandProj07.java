/**
 * This program creates an array with 10 elements. Each element is initialized to a random number that is between one and 100 (inclusive). The largest and smallest 
 * values in the array are found, then the average of all the elements in the array is determined with this information. A user then chooses a value and the program
 * determines if that said value is in the array. If there are multiple elements that match the value given by the user, the smallest element is returned. Finally,
 * the program sorts the array via. selection sort and the final (sorted) array is printed out.
 *
 * Kylie Heiland
 * 
 * Project07
 * 
 * 3/16/22
 */

import java.util.Scanner; 
public class KylieHeilandProj07
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        //Declare an int array of size 10.
        int[] array = new int[10];
        
        //Initializes the given array.
        initializeArray(array);
        
        //Print out the given array.
        System.out.println("The " + array.length + " random numbers are: ");
        printArray(array);
    
        //Prints out the largest and smallest values of the given array.
        System.out.println("The largest value is: " + largest(array) + ". The smallest value is: " + smallest(array) + ".");
        
        //Prints out the range of the array.
        System.out.println("The range of these numbers is: " + range(array) + ".");
        
        //Prints out the average of the array elements.
        System.out.println("The average of these numbers is: " + average(array) + ".");
        
        //Ask user to enter a search key.
        System.out.print("Enter an integer between 1 and 100: ");
        
        int num = input.nextInt();
        
        if(num < 1 || num > 100)
        { //If the user inputted a number that was not anything from 1-100, the program exits.
            System.out.println("You have to enter a number within the given range.");
            System.exit(0);
        }
        
        if(linearSearch(array, num) == -1)
        { //If the number inputted by the user does not have an element in the array, this body is executed.
            System.out.println(num + " is not in the array.");
        }
        else
        { //If the number inputted by the user does have an element in the array at least once, the first occurence is outputted.
            System.out.println(num + " is located in array[" + linearSearch(array, num) + "].");
        }
        
        //Sorts the given array.
        selectSort(array);
        
        //Print out the given array.
        System.out.println("After sorting, the array is now: ");
        printArray(array);
    }
    
    public static void initializeArray(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        { //Loops through all elements in an array.
            arr[i] = 1 + (int)(Math.random() * 100); //Assigns a random number between 1-100 (inclusive) to each element in the array.
        }
    }
    
    public static void printArray(int[] arr)
    {       
        int count = 0; //Determines when a new line will be printed out.
        
        for(int i = 0; i < arr.length; i++)
        { //Loops through all elements in the array.
            if(count == 4)
            { //Every 5 elements, the next element will then be printed on a new line.
                System.out.println(arr[i]);
                count = 0; //Resets the count back to zero so if the array gets longer, it will be able to print out a new line again five elements after, without
                            //having to be altered.
            }
            else
            { //If the count is not 4, then no new line will be printed out.
                int a = arr[i];
                System.out.printf("%-4d", arr[i]); //Prints out the element on the same line as the other four, with spacing so that all numbers will be aligned.
                count++; //Increases the count by one so the program will know whether to print the element on a new line or not in the next loop. 
            }
        }
    }
    
    public static int smallest(int[] arr)
    {
        int smallest = arr[0]; //Assigns smallest to the first element in the array.
        
        for(int i = 1; i < arr.length; i++)
        { //Loops through every element in the array except for the first element: arr[0].
            if(smallest > arr[i])
            { //If smallest is actually larger than the current element in the array, it then assigns to that element's value. 
                smallest = arr[i];
            }
        }
        return smallest; //The smallest value in the array is returned.
    }
    
    public static int largest(int[] arr)
    {
        int largest = arr[0]; //Assigns largest to the first element in the array.
        for(int i = 1; i < arr.length; i++)
        {//Loops through every element in the array except the first element: arr[0].
            if(largest < arr[i])
            { //Compares largest's value to the current element in the array. 
                largest = arr[i]; //If largest is actually smaller than the current array element, largest is assigned to that element.
            }
        }
        return largest; //The largest element in the array is then returned.
    }
    
    public static int range(int[] arr)
    {
        int biggest = largest(arr); //Assigns the largest value in the array to the variable biggest.
        int tiniest = smallest(arr); //Assigns the smallest value in the array to the variable tiniest.
        
        return (biggest - tiniest); //Returns the difference between the largest and smallest values in the array.
    }
    
    public static double average(int[] arr)
    {
        int sum = 0; //Initializes a new variable, sum, to zero. Used to add all element values together.
        double avg = 0; //Initializes a new variable, avg, to zero. Used to hold the average of the elements in the array.
        
        for(int i = 0; i < arr.length; i++)
        { //Loops through all elements in the array.
            sum += arr[i]; //Adds the value of the particular element to sum.
        }
        avg = (double)sum / arr.length; //Casts sum to double so the value of avg will not be truncated
        return avg; //Returns the average of the array elements.
    }
    
    public static int linearSearch(int[] arr, int key)
    {
        for(int i = 0; i < arr.length; i++)
        { //Loops through all elements in the array.
            if(key == arr[i])
            { //If the key has the same value as the particular element, then the index of that element is returned.
                return i;
            }
        }
        return -1; //If no match is found, negative one is returned.
    }
    
    public static void selectSort(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++) 
        { //Loops through every element in the array, except the last one.
        int currentMin = arr[i];
        int currentMinIndex = i;
  
        for (int j = i + 1; j < arr.length; j++) 
        { //Loops through every element after the current element in the array.
          if (currentMin > arr[j]) 
          { //If one of the elements has a lesser value than the current element, the currentMin variable is now set to this element and the currentMinIndex 
              //is set to the index j.
            currentMin = arr[j];
            currentMinIndex = j;
          }
        }
  
        if (currentMinIndex != i) 
        { //Executes if another element has a smaller value than arr[i].
          arr[currentMinIndex] = arr[i]; //The other element sets itself equal to the initial element with i.
          arr[i] = currentMin; //The element at index i is now set to the smallest value among the remaining elements. 
        }
      }
    }
}

/* OUTPUT:
 * 
 * The 10 random numbers are: 
14  34  25  82  35
74  89  9   95  97
The largest value is: 97. The smallest value is: 9.
The range of these numbers is: 88.
The average of these numbers is: 55.4.
Enter an integer between 1 and 100: 39
39 is not in the array.
After sorting, the array is now: 
9   14  25  34  35
74  82  89  95  97

The 10 random numbers are: 
77  18  6   50  13
29  69  90  21  71
The largest value is: 90. The smallest value is: 6.
The range of these numbers is: 84.
The average of these numbers is: 44.4.
Enter an integer between 1 and 100: -4
You have to enter a number within the given range.

The 10 random numbers are: 
100 98  33  57  78
88  14  8   83  79
The largest value is: 100. The smallest value is: 8.
The range of these numbers is: 92.
The average of these numbers is: 63.8.
Enter an integer between 1 and 100: 12
12 is not in the array.
After sorting, the array is now: 
8   14  33  57  78
79  83  88  98  100

The 10 random numbers are: 
94  27  71  12  91
40  62  82  27  91
The largest value is: 94. The smallest value is: 12.
The range of these numbers is: 82.
The average of these numbers is: 59.7.
Enter an integer between 1 and 100: 82
82 is located in array[7].
After sorting, the array is now: 
12  27  27  40  62
71  82  91  91  94
 */
