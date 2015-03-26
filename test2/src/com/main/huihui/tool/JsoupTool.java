package com.main.huihui.tool;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by huihui on 15-3-25.
 */
public class JsoupTool {

    LinkedList<UrlBookModel> url_books = new LinkedList<UrlBookModel>();

    /**
     * 根据关键字抓取网页数据
     * 将url存储到临时变量中,书籍名称存储到UrlBooks的name属性
     * 在根据取得的相应图书的url,爬取相应图书的价格
     * @param key
     * @throws IOException
     */
    public  LinkedList<UrlBookModel> extract(String key) throws IOException {

        // 取出搜索结果的前500本书籍的信息
        for (int i = 0; i <= 100; i += 20) {
            String URL = "http://book.douban.com/tag/" + key + "?start=" + i + "&type=T";
            Document doc = Jsoup.connect(URL).get();

            Elements links = doc.select("div.info h2");

            for (Element link : links) {
                String[] strTemp = link.toString().split("\"");
                UrlBookModel urlBookModel = new UrlBookModel(strTemp[5]);

                // 链接图书对应的页面,根据判断得出图书地址在strTemp字符串的第3个位置
                Document docTemp = Jsoup.connect(strTemp[3]).get();

                Elements elements = docTemp.select("#buyinfo-ebook .buylink-price");

                // 取出价格,放到类UrlBookModel的price属性中去
                if (!"".equals(elements.toString())) {
                    String[] strs = elements.toString().split("<|>");
                    urlBookModel.setPrice(strs[4]);
                }

                url_books.add(urlBookModel);

                System.out.println(strTemp[3] + " " + urlBookModel.getName() + " " + urlBookModel.getPrice());

            }
        }

        return url_books;
    }
}
