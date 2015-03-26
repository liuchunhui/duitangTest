package com.main.huihui.analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;

import jeasy.analysis.MMAnalyzer;

import java.io.StringReader;
import java.util.*;

/**
 * Created by huihui on 15-3-26.
 */
public class ArticleAnalyzer {

    TreeMap<String,Integer> worlds = new TreeMap<String, Integer>();
    /**
     * 用词库分词进行文章分割
     * @param text
     * @throws Exception
     */
    public List<Map.Entry> analyzer(String text) throws Exception {

        // 词库分词
        Analyzer analyzerMM = new MMAnalyzer();

        // 分词器将text文本的内容分词,并打印出来
        TokenStream tokensStream = analyzerMM.tokenStream("content",new StringReader(text));

        // 将取出来的词放进TreeMap里,取出来的词作为key,词的数量作为value
        for(Token token = new Token();(token=tokensStream.next(token)) !=null;) {
            //System.out.println(token.term());
            String strTemp = token.term();

            Integer count = 1;
            // 判断取出来的词是否已经存在TreeMap中
            if(worlds.get(strTemp) != null) {
                count  = worlds.get(strTemp).intValue() + 1;
                worlds.put(strTemp,count);
            }else {
                worlds.put(strTemp,count);
            }
        }

        // 将TreeMap转换为ArrayList,并将ArrayList进行排序
        List<Map.Entry>  wordsList = new ArrayList<Map.Entry>(worlds.entrySet());

        Collections.sort(wordsList, new Comparator<Map.Entry>() {
            @Override
            public int compare(Map.Entry o1, Map.Entry o2) {
                Integer I1 = (Integer)o1.getValue();
                Integer I2 = (Integer)o2.getValue();

                return (I1 > I2) ? -1 : ((I1 == I2) ? 0 : 1);
            }
        });

        return wordsList;
    }
}
