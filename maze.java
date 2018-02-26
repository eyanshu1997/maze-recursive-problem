package maze;
import java.util.*;
public class maze 
{
	static int depth;
	static int[][] maze=new int[10][10];
	static int node;
	static int endi,endj,n;
	static int[][] winmaze=new int[10][10];
	static int[][] checkstac=new int[10][10];
	static void display()
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
				System.out.print(maze[i][j]);
			System.out.println(" ");
		}
	}
	
	static int checkstack(int i,int j)
	{
		if(checkstac[i][j]==1)
				return 1;
				
		else
			return 0;	
	}

	static int  findpath(int i,int h)
	{
		
		if(i>n)
			return 0;
		if(h>n)
			return 0;
		if(i<0)
			return 0;
		if(h<0)
			return 0;
		if(checkstack(i,h)==1)
		{
			return 0;
		}
		if(maze[i][h]==1)
		{
			return 0;
		}
		checkstac[i][h]=1;
		if(i==endi && h==endj)
		{
			winmaze[i][h]=1;
			return 1;
		}
		if(findpath(i+1,h)==1)
		{
			winmaze[i][h]=1;
			return 1;
		}
		if(findpath(i,h+1)==1)
		{
			winmaze[i][h]=1;
			return 1;
		}
		if(findpath(i,h-1)==1)
		{
			winmaze[i][h]=1;
			return 1;
		}
		if(findpath(i-1,h)==1)
		{
			winmaze[i][h]=1;
			return 1;
		}
		return 0;
	}
	public static void main(String args[])
	{
		for(int i=0;i<10;i++)
			for(int j=0;j<10;j++)
				winmaze[i][j]=0;
		Scanner in= new Scanner(System.in);
		System.out.println("enter the no of nodes");
		n=in.nextInt();
		System.out.println("enter the maze matrix 1 with obstracle 0 for path");
		for(int i =0;i<n;i++)
		{
			for(int k=0;k<n;k++)
			{
				maze[i][k]=in.nextInt();
			}
		}
		System.out.println("enter the nend point x,y");
		endi=in.nextInt();
		endj=in.nextInt();
		System.out.println("the maze path is:");
		display();
		System.out.println("the end poiunts are"+endi+endj);
		if(findpath(0,0)==1)
		{
			System.out.println("the solution path is:");
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
					System.out.print(winmaze[i][j]);
				System.out.println(" ");
			}
		}
		else
		{
			System.out.println("solution not found");
		}
	}	

}
