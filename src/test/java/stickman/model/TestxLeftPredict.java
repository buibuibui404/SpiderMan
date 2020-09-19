package stickman.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestxLeftPredict {
    @Test
    public void testGetInfo1(){
        Strategy ts = new xLeftPredict();
        Entity e = new NormalPlatform(200,200);
        Entity hero = new RedSlime(100,200);

        ts.update(hero);
        ts.getInfo(e);

        assertEquals(true,ts.getBound() + 1 >= 0);

    }

    @Test
    public void testGetInfo2(){
        Strategy ts = new xLeftPredict();
        Entity e = new NormalPlatform(1,200);
        Entity hero = new RedSlime(100,200);

        ts.update(hero);
        ts.getInfo(e);

        assertEquals(true, ts.getBound() - e.getXPos() - e.getWidth() < 1);

    }

    @Test
    public void testGetInfo3(){
        Strategy ts = new xLeftPredict();
        Entity e = new NormalPlatform(100,100);
        Entity hero = new RedSlime(100,200);

        ts.update(hero);
        ts.getInfo(e);

        assertEquals(true, ts.getBound() + 1 >= 0);

    }

    @Test
    public void testGetInfo4(){
        Strategy ts = new xLeftPredict();
        Entity e = new NormalPlatform(100,300);
        Entity hero = new RedSlime(100,200);

        ts.update(hero);
        ts.getInfo(e);

        assertEquals(true, ts.getBound() +1 >=0);

    }

    @Test
    public void testGetInfo5(){
        Strategy ts = new xLeftPredict();
        Entity e = new NormalPlatform(100,300);
        Entity hero = new RedSlime(100,200);

        ts.update(hero);
        ts.getInfo(e);
        ts.reset();

        assertEquals(true, ts.getBound() +1 >=0);

    }

}
