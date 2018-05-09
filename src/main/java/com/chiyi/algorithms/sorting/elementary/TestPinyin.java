package com.chiyi.algorithms.sorting.elementary;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * @author chiyi
 */
public class TestPinyin {
    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
        String name="张奡";
        char[] t1 = name.toCharArray();
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();

        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
        for(int i=0;i<t1.length;i++){
            if (java.lang.Character.toString(t1[i]).matches(
                    "[\\u4E00-\\u9FA5]+")){
            String[] t = PinyinHelper.toHanyuPinyinStringArray(t1[i],t3);
            if(t!=null)
            System.out.println(t[0]);
            }
        }
    }
}
