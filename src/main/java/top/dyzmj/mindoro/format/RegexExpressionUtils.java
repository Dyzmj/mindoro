package top.dyzmj.mindoro.format;

import java.util.regex.Pattern;

/**
 * 描述:
 *
 * @author dongYu
 * @date 2023/03/22
 */
public class RegexExpressionUtils {

    public static String replace(String str, String regex, String newStr) {
        return Pattern.compile(regex).matcher(str).replaceAll(newStr);
    }


}
