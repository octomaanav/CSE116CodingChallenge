package tests;

import challenges.Problem3;
import datastructures.LinkedListNode;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestProblem3 {

    @Test
    public void testProblem2NoCycle() {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        n1.setNext(n2);
        n2.setNext(n3);

        assertFalse(Problem3.detectCycle(n1));
    }

    @Test
    public void testProblem2SingleNodeNoCycle() {
        LinkedListNode n1 = new LinkedListNode(10);
        assertFalse(Problem3.detectCycle(n1));
    }

    @Test
    public void testProblem2CycleAtStart() {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(4);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n1); // cycle

        assertTrue(Problem3.detectCycle(n1));
    }

    @Test
    public void testProblem2CycleInMiddle() {
        LinkedListNode a = new LinkedListNode(10);
        LinkedListNode b = new LinkedListNode(20);
        LinkedListNode c = new LinkedListNode(30);
        LinkedListNode d = new LinkedListNode(40);
        LinkedListNode e = new LinkedListNode(50);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(c); // cycle

        assertTrue(Problem3.detectCycle(a));
    }

    @Test
    public void testProblem2TwoNodeCycle() {
        LinkedListNode a = new LinkedListNode(1);
        LinkedListNode b = new LinkedListNode(2);
        a.setNext(b);
        b.setNext(a); // cycle

        assertTrue(Problem3.detectCycle(a));
    }

    @Test
    public void testProblem2ThreeNodeCycle() {
        LinkedListNode x = new LinkedListNode(5);
        LinkedListNode y = new LinkedListNode(6);
        LinkedListNode z = new LinkedListNode(7);
        x.setNext(y);
        y.setNext(z);
        z.setNext(y); // cycle

        assertTrue(Problem3.detectCycle(x));
    }

    @Test
    public void testProblem2SelfLoop() {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(4);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n4); // self-loop

        assertTrue(Problem3.detectCycle(n1));
    }

    @Test
    public void testProblem2CycleAtEnd() {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(4);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n1); // cycle to start

        assertTrue(Problem3.detectCycle(n1));
    }


    @Test
    public void testBonusNoCycle() {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        n1.setNext(n2);
        n2.setNext(n3);

        assertNull(Problem3.findStartofCycle(n1));
    }

    @Test
    public void testBonusSingleNodeNoCycle() {
        LinkedListNode n1 = new LinkedListNode(10);
        assertNull(Problem3.findStartofCycle(n1));
    }

    @Test
    public void testBonusCycleAtStart() {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(4);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n1);

        assertEquals(n1, Problem3.findStartofCycle(n1));
    }

    @Test
    public void testBonusCycleInMiddle() {
        LinkedListNode a = new LinkedListNode(10);
        LinkedListNode b = new LinkedListNode(20);
        LinkedListNode c = new LinkedListNode(30);
        LinkedListNode d = new LinkedListNode(40);
        LinkedListNode e = new LinkedListNode(50);
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(e);
        e.setNext(c);

        assertEquals(c, Problem3.findStartofCycle(a));
    }

    @Test
    public void testBonusTwoNodeCycle() {
        LinkedListNode a = new LinkedListNode(1);
        LinkedListNode b = new LinkedListNode(2);
        a.setNext(b);
        b.setNext(a);

        assertEquals(a, Problem3.findStartofCycle(a));
    }

    @Test
    public void testBonusThreeNodeCycle() {
        LinkedListNode x = new LinkedListNode(5);
        LinkedListNode y = new LinkedListNode(6);
        LinkedListNode z = new LinkedListNode(7);
        x.setNext(y);
        y.setNext(z);
        z.setNext(y);

        assertEquals(y, Problem3.findStartofCycle(x));
    }

    @Test
    public void testBonusSelfLoop() {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(4);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n4);

        assertEquals(n4, Problem3.findStartofCycle(n1));
    }

    @Test
    public void testBonusCycleAtEnd() {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(4);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n1);

        assertEquals(n1, Problem3.findStartofCycle(n1));
    }
}
