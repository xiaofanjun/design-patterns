package utils;

/**
 * Java 工具类
 */
public class JavaUtils {
    /**
     * 测试：
     * JavaUtils.printUniCode('a');
     * JavaUtils.printUniCode('你');
     * JavaUtils.printUniCode('编');
     *
     * @param c
     * @return
     */
    public static int printUniCode(char c) {
        int uniCode = 0;
        uniCode = c;
        System.out.println("字符‘" + c + "’的UniCode = " + uniCode);
        return uniCode;
    }

    public static void main(String[] args) {
        String str1 = "F";
        String str2 = "G";
        String str3 = "FG";
        //2241
        System.out.println(str1.hashCode());//
        System.out.println(str2.hashCode());//
        System.out.println(str3.hashCode());//
    }
}
