package com.example.lab22;

public enum Thumbnail {
    Thumbnail1("Thumbnail 1", R.drawable.food1),
    Thumbnail2("Thumbnail 2", R.drawable.food2),
    Thumbnail3("Thumbnail 3", R.drawable.food3),
    Thumbnail4("Thumbnail 4", R.drawable.food4);

    private String name;
    private int img;

    Thumbnail(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }
}

