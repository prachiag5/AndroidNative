package com.example.hp.trackyourlife;

/**
 * Created by hp on 16-04-2017.
 */

public class Item {
    String animalName;
    int animalImage;

    public Item(String animalName,int animalImage)
    {
        this.animalImage=animalImage;
        this.animalName=animalName;
    }
    public String getAnimalName()
    {
        return animalName;
    }
    public int getAnimalImage()
    {
        return animalImage;
    }
}
