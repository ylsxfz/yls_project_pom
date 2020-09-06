package com.yls.core.page;

/**
 * @Auther: yls
 * @Date: 2020/09/06 22:26
 * @Description:
 * @Version 1.0
 */
public class Params {

    private String field;
    private Object value;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Params{" +
                "field='" + field + '\'' +
                ", value=" + value +
                '}';
    }
}
