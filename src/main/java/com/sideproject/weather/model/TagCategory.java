package com.sideproject.weather.model;

//전체 시계 상품과 커플 시계 나누기 위한 클래스
public enum TagCategory {

    DIGITAL("digital"),
    COUPLE("couple");

    final private String category;

    TagCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}