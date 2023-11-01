package com.example.avtosalon;

public class Car {
    private String name; // название
    private String description;  // описание
    private int imageResource; // ресурс фото
    private int count;

    public Car(String name, String description, int image){

        this.name=name;
        this.description=description;
        this.imageResource=image;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageResource() {
        return this.imageResource;
    }
    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }
}

