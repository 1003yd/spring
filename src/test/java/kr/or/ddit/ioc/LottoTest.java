package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.lotto.Lotto;

public class LottoTest {

	@Test
	public void test() {
		Lotto lotto = new Lotto();
		lotto.setBallNum(45);
		lotto.setRaffleBall(45);
		
		int[] raffleNum = lotto.excute();
		
		for(int number : raffleNum) {
			System.out.print(number+"\t");
		}
		
		assertEquals(7, raffleNum.length);
	}

}
