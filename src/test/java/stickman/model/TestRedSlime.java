package stickman.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestRedSlime {
    @Test
    public void testM(){
        Enemy r = new RedSlime(100, 100);
        assertEquals(false, r.isDead());
        assertEquals(false, r.isComingDown);
        assertEquals(false, r.isJumping);
        r.damaged(1);
        assertEquals(true, r.isDead());
    }
}
