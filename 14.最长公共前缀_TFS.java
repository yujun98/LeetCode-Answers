/**
 * 通过使用第一个数组元素作为临时判定依据，判断它是不是最长公共前缀，
 * 如果不是，则将此判定依据的字符串去掉末尾一位，继续判断。
 * 如果最后此判定依据为空，则不存在最长公共前缀，否则此判定依据就是最长公共前缀。
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }        
        return prefix;
    }    
}
