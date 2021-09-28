
package dataStructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class QueueeTest {
    
    private Queuee<Client> queuee;
    
    public void setupScenary1() {
        queuee =new Queuee<Client>();
    }
    
    public void setupScenary2() {
        queuee =new Queuee<Client>();
        Client cl1 = new Client("52295812","INSERTION"); 
        Client cl2= new Client("36984517","SELECTION"); 
        queuee.enqueue(cl1);
        queuee.enqueue(cl2);
    }
    
    @Test
    public void testEnqueue1() {
        setupScenary1();
        String id = "25967841";
        String sort = "INSERTION";
        Client cl1= new Client(id, sort);
        queuee.enqueue(cl1);
        assertEquals(queuee.getSize(),1);
        assertEquals(queuee.front().getId(),cl1.getId());
        assertEquals(queuee.back().getId(),cl1.getId());
    }
    
    @Test
    public void testEnqueue2() {
        setupScenary2();
        String id = "4596382";
        String sort = "SELECTION";
        Client cl3= new Client(id, sort);
        queuee.enqueue(cl3);
        assertEquals(queuee.getSize(),3);
        assertEquals(queuee.back().getId(),cl3.getId());
    }
    
    @Test
    public void testDequeue1() {
        setupScenary1();
        Client cl= queuee.dequeue();
        assertEquals(cl,null);
        assertTrue(queuee.isEmpty());
    }
    
    @Test
    public void testDequeue2() {
        setupScenary2();
        Client cl= queuee.dequeue();
        assertEquals(cl.getId(),"52295812");
        assertEquals(queuee.getSize(),1);
        assertEquals(queuee.front().getId(),"36984517");
        assertEquals(queuee.back().getId(),"36984517");
    }
    
    @Test
    public void testFront1() {
        setupScenary1();
        Client cl= queuee.front();
        assertEquals(cl,null);
        assertTrue(queuee.isEmpty());
    }
    
    @Test
    public void testFront2() {
        setupScenary2();
        Client cl= queuee.front();
        assertEquals(cl.getId(),"52295812");
        assertEquals(queuee.getSize(),2);
        assertEquals(queuee.front().getId(),"52295812");
    }
    
    @Test
    public void testBack1() {
        setupScenary1();
        Client cl= queuee.back();
        assertEquals(cl,null);
        assertTrue(queuee.isEmpty());
    }
    
    @Test
    public void testBack2() {
        setupScenary2();
        Client cl= queuee.back();
        assertEquals(cl.getId(),"36984517");
        assertEquals(queuee.getSize(),2);
        assertEquals(queuee.back().getId(),"36984517");
    }
    
    @Test
    public void testisEmpty1() {
        setupScenary1();
        boolean empty= queuee.isEmpty();
        assertTrue(empty);
    }
    
    @Test
    public void testisEmpty2() {
        setupScenary2();
        boolean empty= queuee.isEmpty();
        assertFalse(empty);
        assertEquals(queuee.getSize(),2);
    }
}
