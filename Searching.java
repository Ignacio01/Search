package PracticeTest;

/**
 * Created by ignacioojanguren on 18/12/2016.
 *
 * These functions work either for integers or strings or Objects.
 *
 */
public class Searching {

    /**
     * This function searches for an element in an array and goes one element at a time.
     * The function stops searching when the element is been found.
     *
     * Analysis:
     *      The worst case scenario of operations is n accesses to the array.
     *
     * @param searchArray
     *  Array of integers we are going to find the element
     * @param findElement
     *  Integer that we want to find in the searchArray.
     * @precondition
     *  The array doesn't have to be null.
     * @return
     *  i is the position where the element is located
     *  -1 if the element is not found in the array
     * @throws IllegalArgumentException
     *  If the array is not declared, an IllegalArgumentException is thrown.
     */
    public static int serialSearch(int[] searchArray, int findElement){
        if(searchArray == null){
            throw new IllegalArgumentException("The array hasn't been declared.");
        }
        for (int i = 0; i < searchArray.length; i++){
            if(searchArray[i] == findElement){
                return i; //returns the position where the element is located in the array.
            }
        }
        return -1; //The element hasn't been found in the array.
    }

    /**
     * This method is applicable when the array we want to search the elements is sorted.
     * How it works is by looking in the middle element of the array, if the value is not the element in
     * the middle, then the middle value is compared with the element we want to find.
     * If the element is bigger than the middle element, then the new array will go from the middle to the last element
     * and it will search for the middle element of the new array, and so on until the element is found.
     *
     * Analysis:
     *      The worst case scenario for this array is the depth of the recursive calls and it can be log n
     *
     * @param searchArray
     *  Array that we are going to look for the element
     * @param firstElement
     *  First position on the array we want to find
     * @param sizeArray
     *  Size of the array we want to find
     * @param findElement
     *  Element we want to find in the array.
     * @precondition
     *  The array doesn't have to be null.
     * @return
     *  returns an integer bigger than 0 with the position of the element in the array
     *  returns -1 if the element hasn't been found in the array.
     */
    public static int binarySearch(int[] searchArray, int firstElement, int sizeArray, int findElement){
        if (sizeArray <= 0){
            return -1; //The element hasn't been found in the array
        }else{
            int middleElement = (firstElement + sizeArray) / 2;
            if(findElement == searchArray[middleElement]){
                return middleElement;
            }else if( findElement > searchArray[middleElement]){
                return binarySearch(searchArray, middleElement, (sizeArray-1)/2, findElement);
            }else{
                return binarySearch(searchArray, firstElement, sizeArray/2 , findElement);
            }
        }
    }

}
