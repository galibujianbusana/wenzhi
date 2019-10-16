package com.gail.wenzhi.bean;

import androidx.annotation.NonNull;

import java.util.List;

public class TopRootInfo {

    private String reason;
    private Result result;
    private int error_code;

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public int getError_code() {
        return error_code;
    }


    public class Result {

        private String stat;
        private List<Data> data;

        public void setStat(String stat) {
            this.stat = stat;
        }

        public String getStat() {
            return stat;
        }

        public void setData(List<Data> data) {
            this.data = data;
        }

        public List<Data> getData() {
            return data;
        }


        @NonNull
        @Override
        public String toString() {
            String s = "";
            for (int i = 0; i < data.size(); i++){
                s = s + data.get(i).toString();
            }
            return s;
        }
    }




    public class Data {

        private String uniquekey;
        private String title;
        private String date;
        private String category;
        private String author_name;
        private String url;
        private String thumbnail_pic_s;
        private String thumbnail_pic_s02;
        private String thumbnail_pic_s03;
        public void setUniquekey(String uniquekey) {
            this.uniquekey = uniquekey;
        }
        public String getUniquekey() {
            return uniquekey;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }
        public void setDate(String date) {
            this.date = date;
        }
        public String getDate() {
            return date;
        }
        public void setCategory(String category) {
            this.category = category;
        }
        public String getCategory() {
            return category;
        }
        public void setAuthor_name(String author_name) {
            this.author_name = author_name;
        }
        public String getAuthor_name() {
            return author_name;
        }
        public void setUrl(String url) {
            this.url = url;
        }
        public String getUrl() {
            return url;
        }
        public void setThumbnail_pic_s(String thumbnail_pic_s) {
            this.thumbnail_pic_s = thumbnail_pic_s;
        }
        public String getThumbnail_pic_s() {
            return thumbnail_pic_s;
        }
        public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
            this.thumbnail_pic_s02 = thumbnail_pic_s02;
        }
        public String getThumbnail_pic_s02() {
            return thumbnail_pic_s02;
        }
        public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
            this.thumbnail_pic_s03 = thumbnail_pic_s03;
        }
        public String getThumbnail_pic_s03() {
            return thumbnail_pic_s03;
        }

        @NonNull
        @Override
        public String toString() {
            return "uniquekey: "+getUniquekey()
                    + " title :" +getTitle()
                    +" author_name : "+ getAuthor_name();
        }
    }


}
