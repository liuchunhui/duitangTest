package com.main.huihui.tool;

/**
 * UrlBooks类
 * 抓取的url放进url属性
 * 抓取的书名放进name属性
 * Created by huihui on 15-3-25.
 */
public class UrlBookModel {

    // 书籍的名字
    private String name;
//    // 书籍的URL
//    private String URL;
    // 书籍的价格
    private String price;

    // get/set方法
    public String getName() {
        return name;
    }

    public UrlBookModel(String name) {
        //this.URL = URL;
        this.name = name;
        this.price = null;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getURL() {
//        return URL;
//    }
//
//    public void setURL(String URL) {
//        this.URL = URL;
//    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
