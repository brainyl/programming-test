/**
 * 
 */
import java.util.*;
import java.util.stream.Collectors;
public class ProgrammingTest {
	public int[] RotateArrayByNPositions(int[] arrayToRotate, int positions) {
		int arrayToRotateLength = arrayToRotate.length;
        int rotatedArray[] = new int[arrayToRotateLength];
        if(positions == 0)
        	return arrayToRotate;
        if(positions > arrayToRotateLength){
        	throw new IllegalArgumentException("The number of positions to rotate the array is invalid");
        }
        
        int clonedPositions = positions;

        for (int i = 0; i < arrayToRotate.length; i++) {
            int value = arrayToRotate.length - positions;
            if (positions != 0) {
            	rotatedArray[i] = arrayToRotate[value];
            	positions--;
            } else {
            	rotatedArray[i] = arrayToRotate[i - clonedPositions];
            }  
        }
        return rotatedArray;

    }
	// this function is based on the premise that the array has already being sorted
	public int[] RemoveDuplicateFromSortedArray(int[] inputArray) {
		int inputArrayLength = inputArray.length;
		int previoustItem = inputArray[0];
		int[] uniqueItems = new int[inputArrayLength];
		uniqueItems[0] = previoustItem;
        int countOfDistinct = 1;
		for (int i = 0; i < inputArrayLength; i++ ) {
		    if (previoustItem != inputArray[i]) {
		    	uniqueItems[countOfDistinct++] = inputArray[i];
		    }
		    previoustItem = inputArray[i];
		}
		final int[] compactedArray = new int[countOfDistinct];
		System.arraycopy(uniqueItems, 0, compactedArray, 0, countOfDistinct);  
	    return compactedArray;
    }
	public String FindCharsOrderN2N(String string1, String string2) {
		String result = "";
		for (int i = 0; i < string1.length(); i++) {
			char searchString = string1.charAt(i);
			for (int j = 0; j < string2.length(); j++) {
				if(searchString == string2.charAt(j)){
					result = result.concat(String.valueOf(searchString));
					break;
				}
			}	
		}
        return result;

    }
	public String FindCharsOrderN(String string1, String string2) {
		String result = "";
		Set<Character> uniqueValues = string2.chars().mapToObj(e->(char)e).collect(Collectors.toSet()); 
		for (int i = 0; i < string1.length(); i++) {
			char searchString = string1.charAt(i);
			if(uniqueValues.contains(searchString))
				result = result.concat(String.valueOf(searchString));
		}
        return result;
    }
	public int getGcd(int x, int y){
	    if (x<y) return getGcd(y,x);
	    if (x%y==0) return y;
	    else return getGcd(y, x%y);
	}
	public int GetLcm(int x, int y){
	    return ((x*y)/getGcd(x,y));
	} 
	public int GetLcmForArray(int[] inputArray){
		int arrayLength = inputArray.length;
		if(arrayLength == 1)
			return inputArray[0];
		int lcm = GetLcm(inputArray[0], inputArray[1]);;
		for (int i = 2; i < arrayLength; i++) {
			lcm = GetLcm(lcm, inputArray[i]);
		}
		return lcm;
	} 
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
