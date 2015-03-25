package test1.com.main.huihui;

/**
 * Created by huihui on 15-3-25.
 */
public class StringRollbackTool {


    /**
     * 字符串反转
     * 将string类型转换成char数组,利用for循环将char数组的值反转到临时char
     * 数组中去,在将临时char数组转换成string类型,并返回
     * @param str
     * @return
     */
    public String rollback(String str) {

        if (str.length() == 0) {
            return null;
        }

        int length = str.length();
        char[] chars= str.toCharArray();
        char[] temp = new char[length];

        for (int i = 0;i < length;i++) {

            temp[length - 1 - i] = chars[i];
        }

        String strTemp = String.valueOf(temp);
        return strTemp;

    }

}
