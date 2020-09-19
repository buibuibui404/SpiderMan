package stickman.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGameEngine {
    @Test
    public void firstTest(){
        GameEngine g = new GameEngineImpl("LeveLinfo.json");
        assertEquals(true, g.jump());
        assertEquals(true, g.moveLeft());
        assertEquals(true, g.moveRight());
        assertEquals(true, g.stopMoving());
        g.tick();
    }
}
