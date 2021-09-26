package dataStructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.Videogame;

public class StackTest {

	private Stack<Videogame> stack;

	public void setupScenary1() {
		stack =new Stack<Videogame>();
	}

	public void setupScenary2() {
		stack =new Stack<Videogame>();
		Videogame v = new Videogame(150,2500,'C',3); 
		stack.push(v);
	}

	public void setupScenary3() {
		stack =new Stack<Videogame>();
		Videogame v1 = new Videogame(800,2000,'A',2); 
		Videogame v2= new Videogame(801,3000,'B',2); 
		stack.push(v1);
		stack.push(v2);
	}
	
	@Test
	public void testPush1() {
		setupScenary1();
		char shelf = 'A';
		int code = 321;
		double price = 15000;
		int amount = 14;
		Videogame v1 = new Videogame(code, price, shelf, amount);
		stack.push(v1);
		assertEquals(stack.getSize(), 1);
		assertEquals(stack.top().getCode(), v1.getCode());
	}
	
	@Test
	public void testPush2() {
		setupScenary2();
		char shelf = 'B';
		int code = 620;
		double price = 4000;
		int amount = 2;
		Videogame v2 = new Videogame(code, price, shelf, amount);
		stack.push(v2);
		assertEquals(stack.getSize(), 2);
		assertEquals(stack.top().getCode(), v2.getCode());
	}
	
	@Test
	public void testPush3() {
		setupScenary3();
		char shelf = 'A';
		int code = 322;
		double price = 15000;
		int amount = 3;
		Videogame v3 = new Videogame(code, price, shelf, amount);
		stack.push(v3);
		assertEquals(stack.getSize(), 3);
		assertEquals(stack.top().getCode(), v3.getCode());
	}

	@Test
	public void testPop1() {
		setupScenary1();
		Videogame v = stack.pop();
		assertEquals(v, null);
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testPop2() {
		setupScenary2();
		Videogame v = stack.pop();
		assertEquals(v.getCode(), 150);
		assertTrue(stack.isEmpty());
		assertTrue(stack.top()==null);
	}
	
	@Test
	public void testPop3() {
		setupScenary3();
		Videogame v = stack.pop();
		assertEquals(v.getCode(), 801);
		assertEquals(stack.getSize(), 1);
		assertEquals(stack.top().getCode(), 800);
	}
	
	@Test
	public void testTop1() {
		setupScenary1();
		Videogame v = stack.top();
		assertEquals(v, null);
		assertTrue(stack.isEmpty());
	}
	
	@Test
	public void testTop2() {
		setupScenary2();
		Videogame v = stack.top();
		assertEquals(v.getCode(), 150);
		assertEquals(stack.getSize(), 1);
	}
	
	@Test
	public void testTop3() {
		setupScenary3();
		Videogame v = stack.top();
		assertEquals(v.getCode(), 801);
		assertEquals(stack.getSize(), 2);
	}
	
	@Test
	public void testIsEmpty1() {
		setupScenary1();
		boolean empty = stack.isEmpty();
		assertTrue(empty);
	}
	
	@Test
	public void testIsEmpty3() {
		setupScenary3();
		boolean empty = stack.isEmpty();
		assertFalse(empty);
		assertEquals(stack.getSize(), 2);
	}
}
