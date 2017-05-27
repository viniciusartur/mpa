package test.mpa;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import mpa.MsgProcessor;
import mpa.model.Adjustment;
import mpa.model.Sale;

public class AppTest {
	
	private MsgProcessor mp = new MsgProcessor();

	@Test
	public void appleAt10p() {
		assertEquals(new Sale("apple", 10), mp.processMsg("apple at 10p"));
	}
	
	@Test
	public void appleAt20p() {
		assertEquals(new Sale("apple", 20), mp.processMsg("apple at 20p"));
	}
	
	@Test
	public void orangeAt30p() {
		assertEquals(new Sale("orange", 30), mp.processMsg("orange at 30p"));
	}
	
	@Test
	public void test20SalesOfApplesAt10p() {
		assertEquals(new Sale("apple", 10, 20), mp.processMsg("20 sales of apples at 10p each"));
	}
	
	@Test
	public void test50SalesOfOrangesAt20p() {
		assertEquals(new Sale("orange", 20, 50), mp.processMsg("50 sales of oranges at 20p each"));
	}
	
	@Test
	public void add20pApples() {
		assertEquals(new Adjustment("apple", 20, "add"), mp.processMsg("add 20p apples"));
	}
	
	@Test
	public void subtract10pOranges() {
		assertEquals(new Adjustment("orange", 10, "subtract"), mp.processMsg("subtract 10p oranges"));
	}
	
	@Test
	public void multiply2pBananas() {
		assertEquals(new Adjustment("banana", 2, "multiply"), mp.processMsg("multiply 2p bananas"));
	}
}
