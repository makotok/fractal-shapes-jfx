package com.github.makotok.fractal.jfx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.github.makotok.fractal.jfx.drawable.KochCurvePainter;
import com.github.makotok.fractal.jfx.drawable.SierpinskiTrianglePainter;
import com.github.makotok.fractal.jfx.model.ShapeItem;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;

/**
 * 画面のコントローラクラスです。
 *
 * @author makot
 */
public class MainController implements Initializable {

    /** キャンバス */
    @FXML
    private Canvas canvas;

    /** 図形リストビュー */
    @FXML
    private ListView<ShapeItem> shapeItemListView;

    /** 図形リスト */
    private ObservableList<ShapeItem> shapeItems = FXCollections.observableArrayList(
            new ShapeItem("シェルピンスキーの三角形", new SierpinskiTrianglePainter()),
            new ShapeItem("コッホ曲線", new KochCurvePainter()));

    /**
     * デフォルトコンストラクタ
     */
    public MainController() {
    }

    /**
     * 画面の初期化処理を行います。
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // 図形リストを初期化
        shapeItemListView.setItems(shapeItems);
        shapeItemListView.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends ShapeItem> observable, ShapeItem oldValue, ShapeItem newValue) -> {
                    drawCanvas(newValue);
                });

        // 図形を描画
        drawCanvas(shapeItems.get(0));
    }

    /**
     * 図形を描画します。
     *
     * @param shapeItem
     */
    private void drawCanvas(ShapeItem shapeItem) {
        // 背景色、枠線を描画
        final var gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        gc.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // 図形を描画
        if (shapeItem != null) {
            shapeItem.getDrawable().draw(canvas);
        }
    }
}
