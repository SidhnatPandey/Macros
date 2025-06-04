public class Main {
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
	
	public static void bubbleSort(int[] arr, int n) {
	    boolean swapped = false;
	    for (int i = 0; i < n - 1; i++) {
	        swapped = false;
	        for (int j = 0; j < n-i-1; j++) {
	            if (arr[j] > arr[j + 1]) {
	                int temp = arr[j];
	                arr[j] = arr[j + 1];
	                arr[j + 1] = temp;
	                swapped = true;
	            }
	        }
	        if (swapped == false) {
	            break;
	        }
	    }
	    
	   // for (int i = 0; i < n - 1; i++) {
	   //     for (int j = 0; j < n - i -1; j++) {
	   //         if (arr[j] > arr[j + 1]) {
	   //             int temp = arr[j];
	   //             arr[j] = arr[j + 1];
	   //             arr[j+ 1] = temp;
	   //         }
	   //     }
	   // }
	    
	}
	
	public static void insertionSort(int[] arr) {
	    int n = arr.length;
	    for (int i = 1; i < n; ++i) {
	        int key = arr[i];
	        int j = i - 1;
	        while (j >= 0 && arr[j] > key) {
	            arr[j + 1] = arr[j];
	            j = j - 1;
	        }
	        arr[j + 1] = key;
	    }
	}
	
	public static void mergeSort(int[] arr, int left, int right) {
	    if (left < right) {
	        int mid = (left + right) / 2;
	        mergeSort(arr, left, mid);
	        mergeSort(arr, mid + 1, right);
	        merge(arr, left, mid, right);
	    }
	}
	
	public static void merge(int[] arr, int left, int mid, int right) {
	    int n1 = mid - left + 1;
	    int n2 = right - mid;
	    int leftArr[] = new int[n1];
	    int rightArr[] = new int[n2];
	    for (int i = 0; i < n1; i++) {
	        leftArr[i] = arr[left + i];
	    }
	    for (int j = 0; j < n2; j++) {
	        rightArr[j] = arr[mid + 1 + j];
	    }
	    
	    int i = 0, j = 0, k = left;
	    while (i < n1 && j < n2) {
	        if (leftArr[i] <= rightArr[j]) {
	            arr[k] = leftArr[i];
	            i++;
	        } else {
	            arr[k] = rightArr[j];
	            j++;
	        }
	        k++;
	    }
	    while (i < n1) {
	        arr[k] = leftArr[i];
	        k++;
	        i++;
	    }
	    while (j < n2) {
	        arr[k] = rightArr[j];
	        k++;
	        j++;
	    }
	}
}
