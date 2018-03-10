import java.lang.*;
import java.util.*;

class CountingSort
{

	public static void main(String args[])
	{
		int arr[]={0,9,4,5,3,6,8,5,4,8,9,4,6,9,0};
		int arrSize=arr.length;
		int arrO[]=new int[arrSize];
		int range=0,max=0;

		for(int i=0;i<arr.length;i++)
		{
			if(i==0)
			{
			max=arr[i];
			continue;
		    }
			if(arr[i]>max)
			max=arr[i];
		}

		sort(arr,arr.length,arrO,max+1);
		for(int x : arrO)
		System.out.printf(" %d ",x);
	}

	public static void sort(int arr[],int length,int arrO[],int max)
	{

		int arrC[]=new int[max];

        for(int i=0;i<max;i++)
		{
			arrC[i]=0;
		}

		for(int i=0;i<length;i++)
		{
			arrC[arr[i]]=arrC[arr[i]]+1;
		}


		for(int i=1;i<max;i++)
		{
			arrC[i]=arrC[i]+arrC[i-1];
		}
		for(int i=length-1;i>=0;i--)
		{
			arrO[arrC[arr[i]]-1]=arr[i];
			arrC[arr[i]]=arrC[arr[i]]-1;
		}
	}
}





