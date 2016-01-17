package stack;

import org.junit.Assert;
import org.junit.Test;
import org.omg.CORBA.Object;

import static org.junit.Assert.*;

/**
 * Created by andrew on 11/27/2015.
 */
public class StackTest {


    @Test
    public void testIsEmpty() throws Exception {
        Stack stk = new Stack();
        assertTrue(stk.isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        Stack stk = new Stack();
        for(int i = 0; i < 100; i++) {
            stk.push(new java.lang.Object());
            assertEquals(stk.size(), i);
        }
    }

    @Test
    public void testPush() throws Exception {
        Stack<String> stk = new Stack<>();
        for(int i = 0; i < 100; i++) {
            stk.push("" + i);
            assertEquals(stk.pop(), "" + i);
        }
        assertTrue(stk.isEmpty());
    }

    @Test
    public void testPop() throws Exception {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < 100; i++) {
            stk.push(i);
            stk.pop();
        }
        assertTrue(stk.isEmpty());
    }

    @Test
    public void testPeek() throws Exception {
        Stack<String> stk = new Stack<>();
        stk.push("42");
        assertEquals("42", stk.peek());
        assertEquals("42", stk.peek());
        assertEquals("42", stk.peek());
    }

    @Test
    public void testClear() throws Exception {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < 100; i++) {
            stk.push(i);
        }
        stk.clear();
        assertTrue(stk.isEmpty());
    }

    @Test
    public void testToString() throws Exception {
        assertTrue(true);
    }
}
