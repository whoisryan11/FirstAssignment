 

/**
 * Created by Yang on 1/23/20.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        if (array.length >= 2)
            return array[1];
        else
            return null;
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        if (array.length >= 2)
            return array[array.length - 2];
        else
            return null;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) 
                return true;
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        int index = 0;
        String [] result = new String[array.length];
        for (int i = array.length - 1; i > -1; i--) {
            result[index++] = array[i];
        }
        return result;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] != array[j])
                return false;
            i++;
            j--;
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        boolean[] result = new boolean[26];
        int index = 0;
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length(); j++) {
                if ('A' <= array[i].charAt(j) && array[i].charAt(j) <= 'Z') 
                    index = array[i].charAt(j) - 'A'; 
                else if ('a' <= array[i].charAt(j) && array[i].charAt(j) <= 'z')
                    index = array[i].charAt(j) - 'a';
                else
                    continue;
                result[index] = true;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (result[i] == false) 
                return false;
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value)
                result++;
        }
        return result;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valueToRemove) {
                String[] copyArray = new String[array.length - 1];
                System.arraycopy(array, 0, copyArray, 0, i);
                System.arraycopy(array, i + 1, copyArray, i, array.length - i - 1);
                array = copyArray;
            }
        }
        return array;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        String[] result = new String[1];
        result[0] = array[0];
        String temp = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] == temp)
                continue;
            String[] tempArr = new String[result.length + 1];
            System.arraycopy(result, 0, tempArr, 0, result.length);
            tempArr[result.length] = array[i];
            result = tempArr;
            temp = array[i];
        }
        return result;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        String previous = null;
	int totalCount = 0;
	int consCount = 0;
    	String[] newArray = new String[array.length];
    	
    	for(int i = 0; i < array.length; i++){
    		if (array[i].equals(previous)){
    			consCount++;
    			totalCount++;
    			newArray[i-totalCount] += array[i];
    		}else {
    			consCount=0;
    			newArray[i-totalCount] = array[i];
    		}
    		previous = array[i];
	}
	
    	String[] result = new String[newArray.length-totalCount];
    	for(int i = 0; i < result.length; i++) {
    		result[i] = newArray[i];
    	}
    	
	return result;
    }


}
