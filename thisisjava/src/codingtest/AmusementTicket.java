package codingtest;

import java.util.Arrays;
import java.util.Comparator;

public class AmusementTicket {

	public static void main(String[] args) {
		
		int tickets = 10;
	    int[][] requests = {{2,3}, {1,7}, {2,4}, {3,5}};
//	    int tickets = 8;
//	    vector<pair<int, int>> v = {{1,9}, {3,6}, {2,5}};
//	    int tickets = 20000;
//	    vector<pair<int, int>> v = {{3,1}, {2,5}, {2,10}, {3,8}, {1,2}};
	    
	    Arrays.sort(requests, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0])
				{
					return o1[0] - o2[0];
				}
				else
				{
					return o2[1] - o1[1];
				}
			}
	    });
	    
	    System.out.println(Arrays.deepToString(requests));
	    
	    
	}

}
