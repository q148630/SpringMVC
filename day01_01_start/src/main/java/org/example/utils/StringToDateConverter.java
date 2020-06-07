package org.example.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把字串轉換為日期
 */
public class StringToDateConverter implements Converter<String, Date> {

    /**
     * 方法: 把字串轉換為日期
     * @param s 傳進來的字串
     * @return java.util.Date
     */
    @Override
    public Date convert(String s) {
        // 判斷
        if (s == null) {
            throw new RuntimeException("請您傳入數據");
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 把字串轉為日期
            return df.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("數據類型轉換出現錯誤");
        }
    }

}
