package com.github.makotok.fractal.jfx.model;

import com.github.makotok.fractal.jfx.drawable.ShapeDrawable;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ShapeItem {

    private StringProperty name = new SimpleStringProperty();

    private ObjectProperty<ShapeDrawable> drawable = new SimpleObjectProperty<>();

    public ShapeItem() {
    }

    public ShapeItem(String name, ShapeDrawable drawable) {
        setName(name);
        setDrawable(drawable);
    }

    public final StringProperty nameProperty() {
        return this.name;
    }

    public final String getName() {
        return this.nameProperty().get();
    }

    public final void setName(final String name) {
        this.nameProperty().set(name);
    }

    public final ObjectProperty<ShapeDrawable> drawableProperty() {
        return this.drawable;
    }

    public final ShapeDrawable getDrawable() {
        return this.drawableProperty().get();
    }

    public final void setDrawable(final ShapeDrawable drawable) {
        this.drawableProperty().set(drawable);
    }

    /**
     * 文字列表現として、名前を返します。
     */
    @Override
    public String toString() {
        return getName();
    }

}
