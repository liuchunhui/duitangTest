package com.main.huihui.tool;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

/**
 * Created by huihui on 15-3-26.
 */
public class Tool {

    public static void main(String[] args) throws IOException{

        Tool tool = new Tool();
        tool.readWebPage();

    }

    /**
     * 读取网页正文,并将正文以String形式返回
     * @return
     * @throws IOException
     */
    public String readWebPage() throws IOException{

        // 提取数据的网页链接
        String URL = "http://taoduanfang.baijia.baidu.com/article/40410";
        Document doc = Jsoup.connect(URL).get();

        // 获取正文
        String str = doc.select("div.article-detail").get(0).text();

        return str;

    }
}
