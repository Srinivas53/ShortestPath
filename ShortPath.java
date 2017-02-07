package com.lcount;

public class MainClass {
	
	public static void main(String args[]) {
		
		//TODO: This has to be taken as input from user
		int val[][] = new int[][]{{3,4,1,2,8,6},
			                      {6,1,8,2,7,4},
			                      {5,9,3,9,9,5},
			                      {8,4,1,3,2,6},
			                      {3,7,2,8,6,4}};
		//TODO:: This has to be taken as input from user
		int maxLowestCost = 50;	                      
		calcLowestCost(0,0, val, maxLowestCost); 
	}
	
	
	private static int calcLowestCost(int r, int c, int[][] val, int maxLowestCost){
		//Max row count
		int mr = val.length;
		//Max column count
		int mc = val[0].length;
		
		//r & c are row and column values
		if(c >= mc-1) {
			return val[r][c];
		}
		
		
		int curVal = val[r][c]; 
		
		//Calculating Diagonally Up values from index (r,c)
		int rup = ((r-1) < 0)? (mr-1): r-1;
		int cup = (c+1);
		int up = calcLowestCost(rup, cup, val, maxLowestCost);
		
		//Calculating Horizontal values from index (r,c)
		int rmid = r;
		int cmid = (c+1);
		int mid = calcLowestCost(rmid, cmid, val, maxLowestCost);
		
		//Calculating Diagonally down values from index (r,c)
		int rlow = ((r+1) >= (mr))? 0: r+1;
		int clow = (c+1);
		int low = calcLowestCost(rlow, clow, val, maxLowestCost);
		
		int min = min(up, mid, low);
		
		if(r == 0 && c == 0) {
			
			int path1 = up  + curVal;
			int path2 = mid + curVal;
			int path3 = low + curVal;
			
			System.out.println("Maximum Acceptable value: " + maxLowestCost);
			int path = min(path1, path2, path3);
			System.out.println("p1: " + path1 + ", p2: " + path2 + ", p3: " + path3);
			System.out.println("Min. Path cost: " + path + ", acceptable: " + ((path3 <= maxLowestCost)?"Yes":"No"));
		}
		return curVal + min;
	}
	
	private static int min(int a, int b, int c) {
		if(a <= b && a <=c ) return a;
		if(b <= a && b <=c ) return b;
		if(c <= a && c <=b ) return c;
		
		return 0;
	}
}