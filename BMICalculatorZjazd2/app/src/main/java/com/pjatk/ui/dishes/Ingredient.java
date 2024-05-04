package com.pjatk.ui.dishes;

public class Ingredient {

    private final String name;
    private boolean isChecked = false;

    public Ingredient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void toggle() {
        isChecked = !isChecked;
    }
}
