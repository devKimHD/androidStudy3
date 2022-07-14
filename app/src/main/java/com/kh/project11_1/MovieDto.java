package com.kh.project11_1;

public class MovieDto {
    int imgId;
    String title;

    public MovieDto() {
    }

    public MovieDto(int imgId, String title) {
        this.imgId = imgId;
        this.title = title;
    }


    @Override
    public String toString() {
        return "MovieDto{" +
                "imgId=" + imgId +
                ", title='" + title + '\'' +
                '}';
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
