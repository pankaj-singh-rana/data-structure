import java.lang.*;
import java.util.*;

class bubbleSorting
{
	public static void main (String args[])
	{

	    int arr[]={0,0,1,2,0,3,4};
        int temp=0;

	    for(int i=0;i<arr.length;i++)
	    {
			int flag=0;

			for(int j=0;j<arr.length-1-i;j++)
			{
				if(arr[j]>arr[j+1])
				{
					temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
					flag=1;
				}
			}
			if(flag==0)
			{
				break;
			}
		}
		for(int x: arr)
		System.out.printf(" %d ",x);
	}
}