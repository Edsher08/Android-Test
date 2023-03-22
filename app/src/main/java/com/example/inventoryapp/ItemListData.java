package com.example.inventoryapp;

import android.media.Image;

public class ItemListData {

    private String itemName, itemUnit,itemDate;
    private Integer itemPrice, itemImage;

    public ItemListData(String itemName, String itemUnit, String itemDate, Integer itemPrice, Integer itemImage) {
        this.itemName = itemName;
        this.itemUnit = itemUnit;
        this.itemDate = itemDate;
        this.itemPrice = itemPrice;
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public String getItemDate() {
        return itemDate;
    }

    public void setItemDate(String itemDate) {
        this.itemDate = itemDate;
    }

    public Integer getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getItemImage() {
        return itemImage;
    }

    public void setItemImage(Integer itemImage) {
        this.itemImage = itemImage;
    }
}
