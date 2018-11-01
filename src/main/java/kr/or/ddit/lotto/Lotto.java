package kr.or.ddit.lotto;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Lotto {
	private int ballNum;		//공의 개수
	private int raffleBall;  	//추첨 공의 개수
	
	
	public int getBallNum() {
		return ballNum;
	}
	public void setBallNum(int ballNum) {
		this.ballNum = ballNum;
	}
	public int getRaffleBall() {
		return raffleBall;
	}
	public void setRaffleBall(int raffleBall) {
		this.raffleBall = raffleBall;
	}
	
	public int[] excute() {
		Set<Integer> randomNum = new HashSet<Integer>();
		int[] raffleNum = new int[raffleBall];
		do {
			int random = (int)(Math.random()*(ballNum)+1);
			randomNum.add(random);
		}while(randomNum.size() < raffleBall+1);
		
		Iterator<Integer> it = randomNum.iterator();
		
		for(int ball=0; ball < raffleBall; ball++) {
			raffleNum[ball] = it.next();
		}

		/*int count = 0; 
		while(it.hasNext()) {
			raffleNum[count] = it.next();
			count++;
		}*/
		
		return raffleNum;
		
	}
	

}
