import java.lang.*;
import java.util.*;

class MyQuickSort
{

	private int arr[];
	private int length;

	public static void main(String args[])
	{
		MyQuickSort qs=new MyQuickSort();
		int array[]={2,3,4,8,3,4,7,2};
		qs.sort(array);
		for(int x:array)
		System.out.printf(" %d ",x);

	}

	public void sort(int inputArr[])
	{
		if(inputArr==null || inputArr.length==0)
		{
		return;
	    }
	    this.arr=inputArr;
	    length=inputArr.length;
	    quickSort(0,length-1);
	}
	private void quickSort(int LowerIndex,int HigherIndex)
	{
		int i=LowerIndex;
		int j=HigherIndex;
		int pivot=arr[HigherIndex];

        while(i<=j)
        {
			while(arr[i]<pivot)
			{
				i++;
			}
			while(arr[j]>pivot)
			{
				j--;
			}
			if(i<=j)
			{
				swap(i,j);
				i++;
				j--;
			}
		}
		if(LowerIndex<j)
		{
			quickSort(LowerIndex,j);
		}
		if(i<HigherIndex)
		{
			quickSort(i,HigherIndex);
		}
	}

	private void swap(int left,int right)
	{
		int temp;
		temp=arr[left];
		arr[left]=arr[right];
		arr[right]=temp;
	}
}