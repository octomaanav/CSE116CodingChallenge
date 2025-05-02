package tests;

import challenges.problem3.Problem3;
import datastructures.LinkedListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestProblem3 {
    @Test
    public void testNoCycle() {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        n1.setNext(n2);
        n2.setNext(n3);

        assertFalse(Problem3.detectCycle(n1));
        assertNull(Problem3.findStartofCycle(n1));
    }

    @Test
    public void testSingleNodeNoCycle() {
        LinkedListNode n1 = new LinkedListNode(10);

        assertFalse(Problem3.detectCycle(n1));
        assertNull(Problem3.findStartofCycle(n1));
    }

    @Test
    public void testCycleAtStart() {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(4);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n1); // cycle starts at n1

        assertTrue(Problem3.detectCycle(n1));
        assertEquals(n1, Problem3.findStartofCycle(n1));
    }

    @Test
    public void testCycleInMiddle() {
        LinkedListNode a = new LinkedListNode(10);
        LinkedListNode b = new LinkedListNode(20);
        LinkedListNode c = new LinkedListNode(30);
        LinkedListNode d = new LinkedListNode(40);
        LinkedListNode e = new LinkedListNode(50);

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(c); // cycle starts at c

        assertTrue(Problem3.detectCycle(a));
        assertEquals(c, Problem3.findStartofCycle(a));
    }

    @Test
    public void testTwoNodeCycle() {
        LinkedListNode a = new LinkedListNode(1);
        LinkedListNode b = new LinkedListNode(2);
        a.setNext(b);
        b.setNext(a); // cycle back to a

        assertTrue(Problem3.detectCycle(a));
        assertEquals(a, Problem3.findStartofCycle(a));
    }

    @Test
    public void testThreeNodeCycle() {
        LinkedListNode x = new LinkedListNode(5);
        LinkedListNode y = new LinkedListNode(6);
        LinkedListNode z = new LinkedListNode(7);

        x.setNext(y);
        y.setNext(z);
        z.setNext(y); // cycle at y

        assertTrue(Problem3.detectCycle(x));
        assertEquals(y, Problem3.findStartofCycle(x));
    }
    @Test
    public void testSelfLoop() {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(4);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n4); // cycle starts at n2

        assertTrue(Problem3.detectCycle(n1));
        assertEquals(n4, Problem3.findStartofCycle(n1));
    }

    @Test
    public void testCycleAtEnd() {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(4);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n1);

        assertTrue(Problem3.detectCycle(n1));
        assertEquals(n1, Problem3.findStartofCycle(n1));
    }
}
