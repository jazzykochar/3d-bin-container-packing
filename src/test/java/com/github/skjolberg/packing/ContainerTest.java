package com.github.skjolberg.packing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ContainerTest {

    @Test
    public void testEquals() {
        assertEquals(new Container(1, 1, 1), new Container(new Dimension(1, 1, 1)));
    }

    @Test
    public void testGetUsedSpaceWhenEmpty() {
        assertEquals(new Dimension(0, 0, 0), new Container(0, 0, 0).getUsedSpace());
    }

    @Test
    public void testGetUsedSpaceWhenOneBox() {
        final Container container = new Container(10, 10, 10);
        container.addLevel();
        container.add(new Placement(new Space(), new Box(2, 3, 4)));
        assertEquals(new Dimension(2, 3, 4), container.getUsedSpace());
    }

    @Test
    public void testGetUsedSpaceWhenTwoBoxesSameLevel() {
        final Container container = new Container(10, 10, 10);
        container.addLevel();
        container.add(new Placement(new Space(10, 10, 10, 0, 0, 0), new Box(2, 3, 7)));
        container.add(new Placement(new Space(10, 10, 10, 2, 3, 0), new Box(1, 2, 7)));
        assertEquals(new Dimension(3, 5, 7), container.getUsedSpace());
    }

    @Test
    public void testGetUsedSpaceWhenTwoBoxesTwoLevels() {
        final Container container = new Container(10, 10, 10);
        container.addLevel();
        container.add(new Placement(new Space(10, 10, 4, 0, 0, 0), new Box(2, 3, 4)));
        container.addLevel();
        container.add(new Placement(new Space(10, 10, 6, 0, 0, 4), new Box(1, 2, 2)));
        assertEquals(new Dimension(2, 3, 6), container.getUsedSpace());
    }


}
