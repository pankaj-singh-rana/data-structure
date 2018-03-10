import java.lang.*;
import java.util.*;

class radixSort
{
	public static void main(String args[])
	{
		int arr[]={1232,54,3,789,64};
		sort(arr);

	    for(int x : arr)
	    System.out.printf(" %d ",x);

	}

	public static void sort(int arr[])
	{
		int output[]=new int[10];
		int length=arr.length;
		int max=0,exp=1;

		for(int i=0;i<length;i++)
		if(arr[i]>max)
		max=arr[i];

		while(max/exp>0)
		{
			int bucket[]=new int[10];

			for(int i=0;i<length;i++)
			bucket[(arr[i]/exp)%10]++;


			for(int i=1;i<10;i++)
			bucket[i]+=bucket[i-1];

			for(int i=length-1;i>=0;i--)
			output[--bucket[(arr[i]/exp)%10]]=arr[i];


		    for(int i=0;i<length;i++)
		    arr[i]=output[i];

		    exp *=10;

		}
	}
}