package com.example.zzb.aac.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zzb on 2017/11/15.
 */

public class JsonBean {
    @Override
    public String toString() {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return gson.toJson(this);
    }

    public Map<String, Object> toMap() {
        Class<? extends JsonBean> clazz = this.getClass();
        Class<? extends Object> superclass = clazz.getSuperclass();

        Field[] fields = clazz.getDeclaredFields();
        Field[] superFields = superclass.getDeclaredFields();

        if (fields == null || fields.length == 0) {
            return Collections.emptyMap();
        }

        Map<String, Object> params = new HashMap<>();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                Object object = field.get(this);
                if (object == null || "serialVersionUID".equals(field.getName())) {
                    continue;
                }
                params.put(field.getName(), object);
            }

            for (Field superField : superFields) {
                superField.setAccessible(true);
                Object object = superField.get(this);
                if (object == null || "serialVersionUID".equals(superField.getName())) {
                    continue;
                }
                if (superField.get(this) != null) {
                    params.put(superField.getName(), superField.get(this));
                }
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return params;
    }
}
