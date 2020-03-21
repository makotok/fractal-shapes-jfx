package com.github.makotok.fractal.jfx.drawable;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.geometry.Point2D;

public class KochCurvePainterTest {

    @Test
    public void testPoint() {
        var a = new Point2D(1, 1);
        var b = new Point2D(10, 10);
        var c = new Point2D(10, 1);
        var d = new Point2D(10, -10);
        var angleB = a.angle(b);
        var angleC = a.angle(c);
        var angleD = a.angle(d);
        var distanceAB = a.distance(b);
        var distanceAC = a.distance(c);
        var distanceAD = a.distance(d);

        System.out.println(angleB);
        System.out.println(angleC);
        System.out.println(angleD);
        System.out.println(distanceAB);
        System.out.println(distanceAC);
        System.out.println(distanceAD);
    }

    @Test
    public void testDraw() {
        fail("まだ実装されていません");
    }

    @Test
    public void testDrawKoch() {
        fail("まだ実装されていません");
    }

}
