import java.lang.*;
import java.util.*;

class mergeSort
{
	private int arr[];
	private int temp[];
	private int arraySize;

	public static void main (String args[])
	{
		mergeSort ms=new mergeSort();
		int input[]={9,0,0,1,2,3,1,4,5,1};
		ms.sort(input);

		for(int x : input)
		System.out.printf(" %d ",x);
	}

	public void sort(int inputArr[])
	{
		this.arr=inputArr;
		this.arraySize=inputArr.length;
		this.temp=new int[arraySize];
		doMergeSort(0,arraySize-1);
	}

	public void doMergeSort(int lowerindex,int higherindex)
	{
		if(lowerindex<higherindex)
		{
			int middle=lowerindex+(higherindex-lowerindex)/2;
			doMergeSort(lowerindex,middle);
			doMergeSort(middle+1,higherindex);
			merge(lowerindex,middle,higherindex);
		}
	}

	public void merge(int low,int mid,int high)
	{
		for(int i=low;i<=high;i++)
		{
			temp[i]=arr[i];
		}
		int i=low;
		int j =mid+1;
		int k=low;

		while(i<=mid && j<=high)
		{

			if(temp[i]<=temp[j])
			{
				arr[k]=temp[i];
				i++;
			}
			else
			{
				arr[k]=temp[j];
				j++;
			}
			k++;
		}
		while(i<=mid)
		{
			arr[k]=temp[i];
			k++;
			i++;
		}
	}
}





