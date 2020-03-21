/**
 *
 */
package com.github.makotok.fractal.jfx.drawable;

import javafx.scene.canvas.Canvas;

/**
 * {@link Canvas}に対して図形を描画するためのインタフェースです。
 *
 * @author makot
 */
public interface ShapeDrawable {

    /**
     * {@link Canvas}に対して図形を描画を行います。
     *
     * @param canvas Canvasインスタンス
     */
    void draw(Canvas canvas);
}
