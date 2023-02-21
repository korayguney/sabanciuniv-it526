package edu.sabanciuniv.sabanci04.controller;

public class MyResponse {

    public int toplam;

    public MyResponse(int toplam) {
        this.toplam = toplam;
    }
    public MyResponse() {

    }

    public int getToplam() {
        return toplam;
    }

    public void setToplam(int toplam) {
        this.toplam = toplam;
    }
}
