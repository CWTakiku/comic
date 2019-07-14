package com.example.cwl.db.utils;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author:chengwl
 * Description:
 * Date:2019/7/3
 */
public class StringConverter implements PropertyConverter<List<String>,String> {
    @Override
    public List<String> convertToEntityProperty(String databaseValue) {
        if (databaseValue==null){
            return null;
        }else {
            List<String> list= Arrays.asList(databaseValue.split(","));
            return list;
        }

    }

    @Override
    public String convertToDatabaseValue(List<String> entityProperty) {
        if (entityProperty==null||entityProperty.size()==0){
            return null;
        }else {
            StringBuilder sb=new StringBuilder();
            for (String link:entityProperty){
                sb.append(link);
                sb.append(",");
            }
            return sb.toString();
        }

    }
}
