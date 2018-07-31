package com.marvelwall.ahmedpc.clinicalguidelines.model;

public class Index {
    private String name;
    private String pageNumb;

    public Index(){}

    public Index(String name,String pageNumb){
        this.name = name;
        this.pageNumb = pageNumb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPageNumb() {
        return pageNumb;
    }

    public void setPageNumb(String pageNumb) {
        this.pageNumb = pageNumb;
    }
}
