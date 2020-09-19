package stickman.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLevel {
    @Test
    public void buildLevel(){
        Platform p = new NormalPlatform(30, 150);
        Hero h = new Hero("tiny",30,1);
        Enemy enemy = new BlueSlime(60, 330 );

        LevelBuilder lb = new LevelBuilderImpl();
        lb.setHero(h);
        lb.addBackground(new Cloud(1,1,1));
        lb.addPlatform(p);
        lb.addEnemy(enemy);
        lb.addFinishLine(100);

        Level lv = lb.build();

        assertEquals(true, lv.getHeroX() -h.posX == 0);
        assertEquals(true, lv.getHeight() -h.height == 0);
        assertEquals(true, lv.getWidth() -h.width == 0);
        assertEquals(true, lv.getFloorHeight() -330 == 0);

        lv.tick();
        assertEquals(true, h.life == 1);
        assertEquals(false, enemy.isDead());
        assertEquals(false, enemy.isComingDown);
    }

    @Test
    public void simpleLevel(){
        Platform p = new NormalPlatform(30, 150);
        Hero h = new Hero("tiny",150,1);
        Enemy enemy = new RedSlime(150, 300 );

        LevelBuilder lb = new LevelBuilderImpl();
        lb.setHero(h);
        lb.addBackground(new Cloud(1,1,1));
        lb.addPlatform(p);
        lb.addEnemy(enemy);
        lb.addBackground(new FinishLine(1000,20,0));
        lb.addFinishLine(1000);

        Level lv = lb.build();

        assertEquals(true, h.life == 1);
        assertEquals(false, enemy.isDead());
        assertEquals(false, enemy.isJumping);
        assertEquals(false, enemy.ismovingLeft);
        assertEquals(false, enemy.ismovingRight);
        assertEquals(true, enemy.upB == 0);

        lv.tick();
        assertEquals(false, h.isInRang(enemy));
        h.attack(enemy);
        h.setHp(5);

        assertEquals(5, h.getHp());
        assertEquals(true, enemy.isDead());

        h.revive();
        assertEquals(0, h.life);

        assertEquals(false, h.isDamaged());
    }

    @Test
    public void notVerySimpleLevelTest(){
        Platform p = new NormalPlatform(3000, 1500);
        Hero h = new Hero("tiny",150,100);
        Enemy enemy1 = new RedSlime(150, 300 );
        Enemy enemy2 = new GreenSlime(150, 0 );
        Enemy enemy3 = new GreenSlime(250, 300 );
        Enemy enemy4 = new GreenSlime(0, 300 );
        Enemy enemy5 = new GreenSlime(150, 100+h.height-1 );
        Enemy enemy6 = new GreenSlime(0, 250 );
        Enemy enemy7 = new GreenSlime(350, 300 );
        Enemy enemy8 = new GreenSlime(0, 300 );
        h.posY = 100;
        LevelBuilder lb = new LevelBuilderImpl();
        lb.setHero(h);
        lb.addBackground(new Cloud(1,1,1));
        lb.addPlatform(p);
        lb.addEnemy(enemy1);
        lb.addEnemy(enemy2);
        lb.addEnemy(enemy3);
        lb.addEnemy(enemy4);
        lb.addEnemy(enemy5);
        lb.addEnemy(enemy6);
        lb.addEnemy(enemy7);
        lb.addEnemy(enemy8);
        lb.addBackground(new FinishLine(1000,20,0));
        lb.addFinishLine(1000);

        Level lv = lb.build();

        assertEquals(false, h.isInRang(enemy1));
        assertEquals(false, h.isInRang(enemy2));
        assertEquals(false, h.isInRang(enemy3));
        assertEquals(false, h.isInRang(enemy4));
        assertEquals(true, h.isInRang(enemy5));
        assertEquals(false, h.isInRang(enemy6));
        assertEquals(false, h.isInRang(enemy7));
        assertEquals(false, h.isInRang(enemy8));

        h.see(enemy5);
        assertEquals(true, enemy5.isDead());

    }

    @Test
    public void emptyLevel(){
        Hero h = new Hero("tiny",30,1);

        LevelBuilder lb = new LevelBuilderImpl();
        lb.setHero(h);
        lb.addBackground(new Cloud(1,1,1));
        lb.addFinishLine(1000);

        Level lv = lb.build();

        h.changYLocation();
        h.changYLocation();
        h.changYLocation();
        h.changYLocation();
        h.changYLocation();
        h.changYLocation();
        h.changYLocation();

        h.changXLocation();
        h.changYLocation();
        assertEquals(true, h.getYPos() - 296 < 1);
        assertEquals(true, h.posX + 21 >= 0);

    }

    @Test
    public void emptyLevel2(){
        Hero h = new Hero("tiny",30,1);
        Platform p = new NormalPlatform(30, h.posY -5);

        LevelBuilder lb = new LevelBuilderImpl();
        lb.setHero(h);
        lb.addBackground(new Cloud(1,1,1));
        lb.addPlatform(p);
        lb.addFinishLine(1000);

        Level lv = lb.build();
        lv.tick();
        lv.tick();
        lv.tick();
        lv.tick();
        h.changYLocation();
        h.changYLocation();
        h.changYLocation();
        h.changYLocation();
        h.changXLocation();
        h.setXDirection(false);
        h.changXLocation();
        assertEquals(true, h.posX == 30);
        h.changXLocation();
        assertEquals(false, h.posX == 30);

    }


}
