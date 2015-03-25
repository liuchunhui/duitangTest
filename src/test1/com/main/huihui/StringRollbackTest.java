package test1.com.main.huihui;

import java.util.Scanner;

/**
 * Created by huihui on 15-3-25.
 */
public class StringRollbackTest {

    public static void main(String[] args) {

        StringRollbackTool tool = new StringRollbackTool();

        Scanner in = new Scanner(System.in);

        // 输入字符串
        System.out.println("请输入:");
        String str = in.next();

        // 方法一反转
        // 利用char数组和for循环
        System.out.println("方法一:反转");
        String strTemp = tool.rollback(str);
        System.out.println(strTemp);

        // 方法二反转
        // 利用StringBuilder提供reverse的方法
        System.out.println("方法二:反转");

        StringBuilder strBuilder = new StringBuilder(str);
        System.out.println(strBuilder.reverse());


    }


}
