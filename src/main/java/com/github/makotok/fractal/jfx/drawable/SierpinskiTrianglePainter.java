package com.github.makotok.fractal.jfx.drawable;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * シェルピンスキーの三角形を描画するクラスです。
 *
 * @author makot
 */
public class SierpinskiTrianglePainter implements ShapeDrawable {

    /** 背景色 */
    private Color backgroundColor = Color.WHITE;

    /** 三角形の塗りつぶし色 */
    private Color fillColor = Color.AQUA;

    /** 三角形の線の色 */
    private Color strokeColor = Color.BLACK;

    /** 再帰描画数 */
    private int repeatCount = 5;

    /** 線の幅 */
    private double lineWidth = 0.5;

    /** 三角形の幅 */
    private double width = 500;

    /** 描画開始位置 */
    private Point2D startPoint = new Point2D(6, 6);

    /**
     * コンストラクタ
     */
    public SierpinskiTrianglePainter() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(Canvas canvas) {
        final var height = width * Math.sqrt(3) / 2;
        drawSierpinskiTriangle(canvas, startPoint.getX(), startPoint.getY(), width, height);
    }

    /**
     * シェルピンスキーの三角形を描画します。
     * @param canvas キャンバス
     * @param x 開始位置x
     * @param y 開始位置y
     * @param w 幅
     * @param h 高さ
     */
    protected void drawSierpinskiTriangle(Canvas canvas, double x, double y, double w, double h) {
        var gc = canvas.getGraphicsContext2D();

        // 座標の計算
        var xPoints = new double[] { x, x + w / 2, x + w, x };
        var yPoints = new double[] { y + h, y, y + h, y + h };

        // 三角形の塗りつぶし
        gc.setFill(fillColor);
        gc.fillPolygon(xPoints, yPoints, 4);
        gc.setStroke(strokeColor);
        gc.setLineWidth(lineWidth);
        gc.strokePolygon(xPoints, yPoints, 4);

        //
        drawCutTriangle(gc, x, y, w, h, 1);
    }

    /**
     * 指定された三角形内部に逆三角形を描画します。
     */
    protected void drawCutTriangle(GraphicsContext gc, double x, double y, double w, double h, int count) {
        if (count > repeatCount) {
            return;
        }

        // 座標の計算
        var xPoints = new double[] { x + w / 4, x + w / 4 * 3, x + w / 2, x + w / 4 };
        var yPoints = new double[] { y + h / 2, y + h / 2, y + h, y + h / 2 };

        // 逆三角形を描画
        gc.setFill(backgroundColor);
        gc.fillPolygon(xPoints, yPoints, 4);
        gc.setStroke(strokeColor);
        gc.setLineWidth(lineWidth);
        gc.strokePolygon(xPoints, yPoints, 4);

        // 再帰的に
        drawCutTriangle(gc, x + w / 4, y, w / 2, h / 2, count + 1);
        drawCutTriangle(gc, x, y + h / 2, w / 2, h / 2, count + 1);
        drawCutTriangle(gc, x + w / 2, y + h / 2, w / 2, h / 2, count + 1);
    }

    /**
     * @return backgroundColor
     */
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @param backgroundColor セットする backgroundColor
     */
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * @return fillColor
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * @param fillColor セットする fillColor
     */
    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
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
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * @param width セットする width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * @return startPoint
     */
    public Point2D getStartPoint() {
        return startPoint;
    }

    /**
     * @param startPoint セットする startPoint
     */
    public void setStartPoint(Point2D startPoint) {
        this.startPoint = startPoint;
    }
}
