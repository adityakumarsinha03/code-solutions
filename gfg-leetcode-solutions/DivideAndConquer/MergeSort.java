// https://practice.geeksforgeeks.org/problems/merge-sort/1

import java.util.*;

class Merge_Sort
{
	static void printArray(int arr[]){
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int n = sc.nextInt();
			Merge_Sort ms = new Merge_Sort();
			
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
            
			Solution g = new Solution();
			g.mergeSort(arr,0,arr.length-1);
			ms.printArray(arr);
			T--;
		}
	}
}

class Solution
{
    void merge(int arr[], int l, int m, int r)
    {
        int n1 = m-l+1;
        int n2 = r-m;
        
        int left[] = new int[n1];
        int right[] = new int[n2];
        
        for(int i = 0; i<n1; i++)
            left[i] = arr[l+i];
        
        for(int i = 0; i<n2; i++)
            right[i] = arr[m+1+i];
        
        int i = 0, j = 0, k = l;
        while(i<n1 && j<n2){
            if(left[i] > right[j]){
                arr[k] = right[j];
                j++; k++;
            } else{
                arr[k] = left[i];
                i++; k++;
            }
        }
        while(i<n1){
            arr[k] = left[i];
            i++; k++;
        }
        while(j<n2){
            arr[k] = right[j];
            j++; k++;
        }
    }
    void mergeSort(int arr[], int l, int r)
    {
        if(l < r){
            int mid = l + (r-l)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }
}
