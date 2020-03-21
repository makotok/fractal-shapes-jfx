package com.github.makotok.fractal.jfx.drawable;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * コッホ曲線を描画するクラスです。
 * 参考：https://codezine.jp/article/detail/73
 *
 * @author makot
 */
public class KochCurvePainter implements ShapeDrawable {

    /** 三角形の線の色 */
    private Color strokeColor = Color.BLUE;

    /** 再帰描画数 */
    private int repeatCount = 3;

    /** 線の幅 */
    private double lineWidth = 0.5;

    /** 出発点P */
    private Point2D startP = new Point2D(100, 160);

    /** 出発点Q */
    private Point2D startQ = new Point2D(400, 160);

    /** 出発点R */
    private Point2D startR = new Point2D(250, 420);

    /**
     * コンストラクタ
     */
    public KochCurvePainter() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(Canvas canvas) {
        // 線の色と幅を設定
        var gc = canvas.getGraphicsContext2D();
        gc.setStroke(strokeColor);
        gc.setLineWidth(lineWidth);

        // 線色を青色に設定した後、上記３点の間にコッホ曲線を描きます
        drawKoch(gc, startP, startQ, repeatCount);
        drawKoch(gc, startQ, startR, repeatCount);
        drawKoch(gc, startR, startP, repeatCount);
    }

    /**
     * コッホ曲線を描画します。
     *
     * @param gc 描画コンテキスト
     * @param a 点A
     * @param b 点B
     * @param n 再帰用のカウンタ
     */
    public void drawKoch(GraphicsContext gc, Point2D a, Point2D b, int n) {
        // 角度と距離を算出
        var ba = new Point2D(b.getX() - a.getX(), -(b.getY() - a.getY()));
        var angle1 = Math.atan((double) ba.getY() / ba.getX()) + Math.PI / 6;
        var angle2 = Math.atan((double) ba.getY() / ba.getX()) - Math.PI / 6;
        var distance = Math.sqrt(ba.getX() * ba.getX() + ba.getY() * ba.getY()) / Math.sqrt(3);

        // メソッド内部で使用する３点を生成します
        var c = new Point2D((2 * a.getX() + b.getX()) / 3, (2 * a.getY() + b.getY()) / 3);
        var d = new Point2D((a.getX() + 2 * b.getX()) / 3, (a.getY() + 2 * b.getY()) / 3);
        var e = ba.getX() >= 0
                ? new Point2D(a.getX() + distance * Math.cos(angle1), a.getY() - distance * Math.sin(angle1))
                : new Point2D(b.getX() + distance * Math.cos(angle2), b.getY() - distance * Math.sin(angle2));

        // 描画処理
        if (n <= 0) {
            // 最後なので、実際に線を引きます
            gc.strokeLine(a.getX(), a.getY(), c.getX(), c.getY()); //点Aから点Cへ
            gc.strokeLine(c.getX(), c.getY(), e.getX(), e.getY()); //点Cから点Eへ
            gc.strokeLine(e.getX(), e.getY(), d.getX(), d.getY()); //点Eから点Dへ
            gc.strokeLine(d.getX(), d.getY(), b.getX(), b.getY()); //点Dから点Bへ
        } else {
            // 最後ではないので、更にメソッドを呼び出します（再帰処理）
            drawKoch(gc, a, c, n - 1); //点Aから点Cへ
            drawKoch(gc, c, e, n - 1); //点Cから点Eへ
            drawKoch(gc, e, d, n - 1); //点Eから点Dへ
            drawKoch(gc, d, b, n - 1); //点Dから点Bへ
        }
    }

    /**
     * @return strokeColor
     */
    public Color getStrokeColor() {
        return strokeColor;
    }

    /**
     * @param strokeColor セットする strokeColor
     */
    public void setStrokeColor(Color strokeColor) {
        this.strokeColor = strokeColor;
    }

    /**
     * @return repeatCount
     */
    public int getRepeatCount() {
        return repeatCount;
    }

    /**
     * @param repeatCount セットする repeatCount
     */
    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    /**
     * @return lineWidth
     */
    public double getLineWidth() {
        return lineWidth;
    }

    /**
     * @param lineWidth セットする lineWidth
     */
    public void setLineWidth(double lineWidth) {
        this.lineWidth = lineWidth;
    }

    /**
     * @return startP
     */
    public Point2D getStartP() {
        return startP;
    }

    /**
     * @param startP セットする startP
     */
    public void setStartP(Point2D startP) {
        this.startP = startP;
    }

    /**
     * @return startQ
     */
    public Point2D getStartQ() {
        return startQ;
    }

    /**
     * @param startQ セットする startQ
     */
    public void setStartQ(Point2D startQ) {
        this.startQ = startQ;
    }

    /**
     * @return startR
     */
    public Point2D getStartR() {
        return startR;
    }

    /**
     * @param startR セットする startR
     */
    public void setStartR(Point2D startR) {
        this.startR = startR;
    }
}
