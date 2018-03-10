import java.lang.*;
import java.util.*;

class insertionSort1
{
	public static void main(String args[])
	{
		int arr[]={1,0,5,3,4,2,0,1};
        int j=0;

		for(int i=1;i<arr.length;i++)
		{
			int key=arr[i];
			j=i-1;

			while(j>=0 && key<arr[j])
			{
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
		}

		for(int x:arr)
		System.out.printf(" %d ",x);
		System.out.println();
	}

}