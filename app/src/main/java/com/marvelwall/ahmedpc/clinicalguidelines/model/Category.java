package com.marvelwall.ahmedpc.clinicalguidelines.model;


import java.util.ArrayList;

public class Category {

    public Category(){}

    public Category(String name, int icon, ArrayList<Index> indexs) {
        this.name = name;
        this.icon = icon;
        this.indexs = indexs;
    }

    public ArrayList<Index> getIndexs() {
        return indexs;
    }

    public void setIndexs(ArrayList<Index> indexs) {
        this.indexs = indexs;
    }

    private String name;
    private int icon;



    private ArrayList<Index> indexs = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
