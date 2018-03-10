import java.lang.*;
import java.util.*;

class HeapSort1
{
	public static void main(String args[])
	{
		int arr[]={0,1,2,9,8,2,0,1,0};

		heapSort(arr);

		for(int x:arr)
		System.out.printf(" %d ",x);
	}


	public static void heapSort(int arr[])
	{
		int n=arr.length-1;

		for(int i=n/2;i>=0;i--)
		heapify(arr,n,i);

		for(int i=n;i>=0;i--)
		{
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;

			heapify(arr,i,0);
		}
	}

	public static void heapify(int arr[],int n,int i)
	{
		int largest=i;
		int left=2*i+1;
		int right=2*i+2;

		if(left<n && arr[left]>arr[largest])
		largest=left;

		if(right<n && arr[right]>arr[largest])
		largest=right;

		if(largest!=i)
		{
			swap(arr,i,largest);
		    heapify(arr,n,largest);
		}
	}

	public static void swap(int arr[],int left,int right)
	{
		int temp=arr[left];
		arr[left]=arr[right];
		arr[right]=temp;
	}
}






