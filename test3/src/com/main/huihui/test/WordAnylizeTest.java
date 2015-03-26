package com.main.huihui.test;

import com.main.huihui.analyzer.ArticleAnalyzer;
import com.main.huihui.tool.Tool;
import org.apache.lucene.analysis.Analyzer;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by huihui on 15-3-26.
 */
public class WordAnylizeTest {

    public static void main(String[] args) throws IOException,Exception{

        // 分析页面,取出文章主体
        Tool tool = new Tool();
        ArticleAnalyzer articleAnalyzer = new ArticleAnalyzer();

        // 处理文章内容,解析文章,统计文章出现词的个数,放到List集合中去
        String article = tool.readWebPage();
        List<Map.Entry> worlds = articleAnalyzer.analyzer(article);

        // 展示结果,出现次数最多的前10个词语
        for (int i = 0; i < 10; i ++) {
            System.out.println("出现次数第" + (i + 1) + "的词语: " + worlds.get(i).getKey() +
                " 出现次数为: " + worlds.get(i).getValue());
        }
    }
}
