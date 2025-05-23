package codingtest;

import java.util.Arrays;

public class MembershipVIP {

	public static void main(String[] args) {
		
		int[] periods = {8, 23, 24};
		int[][] payments = 
				{{100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000}, 
				 {100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000}, 
				 {350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}};
		int[] estimates = {100000, 100000, 100000};
		
//		int[] periods = {24, 59, 59, 60};
//		int[][] payments = 
//				{{50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000},
//				 {50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000},
//				 {350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000},
//				 {50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000}};
//		int[] estimates = {350000, 50000, 40000, 50000};
		
		int[] answer = solution(periods, payments, estimates);
		System.out.println(Arrays.toString(answer));
	}
	
	public static int calcVipCut(int period) {
		int vipCut=0;
		if (period<24) {
			vipCut=-1;
		}
		else if (period<60) {
			vipCut = 900000;
		}
		else if (period>=60) {
			vipCut = 600000;
		}
		
		return vipCut;
	}
	
	public static int[] solution(int[] periods, int[][] payments, int[] estimates) {
		int[] answer = {0,0};
		
		// 2년 이상 5년 미만 : 90만원 이상
		// 5년 이상 : 60만원 이상
		// 기간이 2년 미만은 x
		
		int cnt = periods.length;
		
		for (int i=0; i<cnt; ++i) {
			int currMonthPeriod = periods[i];
			int nextMonthPeriod = currMonthPeriod + 1;
			int vipCut = calcVipCut(currMonthPeriod);	// -1은 2년 미만으로 vip가 될 수 없음
			
			int sum=0;
			for (int k=0; k<12; ++k) {
				sum+=payments[i][k];
			}
			
			boolean currVIP = false;
			if (vipCut!=-1 && sum>=vipCut)
				currVIP = true;
			
			boolean nextVIP = false;
			sum-=payments[i][0]-estimates[i];
			vipCut = calcVipCut(nextMonthPeriod);
			if (vipCut!=-1 && sum>=vipCut)
			{
				nextVIP = true;
				if (!currVIP) {
					++answer[0];
				}
			}
			else if (currVIP) {
				++answer[1];
			}
		}
		
		return answer;
	}

}

/*
vip가 될 고객
아니게 될 고객
알림



*/