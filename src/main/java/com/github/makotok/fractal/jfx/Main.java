/**
 *
 */
package com.github.makotok.fractal.jfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * アプリケーション起動用クラスです。
 *
 * @author makot
 */
public class Main {

    /**
     * アプリケーションメインクラスです。
     * Java9以降では、MainクラスとApplicationクラスを分離する必要があります。
     *
     * @author makot
     */
    public static class MainApplication extends Application {

        /**
         * アプリケーションを開始します。
         */
        @Override
        public void start(Stage primaryStage) throws Exception {
            // Root生成
            final var loader = new FXMLLoader(getClass().getClassLoader().getResource("Main.fxml"));
            final Parent root = loader.load();

            // Scene生成
            final var scene = new Scene(root);

            // Stageの表示
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }

    /**
     * アプリケーションを起動します。
     *
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        Application.launch(MainApplication.class, args);
    }
}
