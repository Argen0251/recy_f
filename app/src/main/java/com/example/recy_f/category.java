package com.example.recy_f;
public class category {
    private String name;
    private int icon;

    public category(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }
}