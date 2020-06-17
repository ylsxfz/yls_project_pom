package com.yls.core.jpql;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * @Author yls
 * @Date 2020/3/22 13:25
 * @Description 排序条件 order
 * @Version 1.0
 **/
public class BaseOrder implements Serializable {

    private static final long serialVersionUID = -3078342809727773232L;

    /**
     * 方向
     */
    public enum Direction {

        //递增
        asc,

        //递减
        desc
    }

    //默认方向
    private static final Direction DEFAULT_DIRECTION = Direction.desc;

    // 属性
    private String property;

    //方向
    private Direction direction = DEFAULT_DIRECTION;

    @Override
    public String toString() {
        return property+" " + direction.name();
    }

    /**
     * 构造方法
     */
    public BaseOrder() {
    }

    /**
     * @Author yls
     * @Description
     * @Date 2020/3/22 14:31
     * @param property 属性
     * @param direction 方向
     * @return
     */
    public BaseOrder(String property, Direction direction) {
        this.property = property;
        this.direction = direction;
    }

    /**
     * @Author yls
     * @Description 返回递增排序
     * @Date 2020/3/22 14:31
     * @param property 属性
     * @return 递增排序
     **/
    public static BaseOrder asc(String property) {
        return new BaseOrder(property, Direction.asc);
    }

    /**
     * @Author yls
     * @Description 返回递减排序
     * @Date 2020/3/22 14:31
     * @param property 属性
     * @return 递减排序
     **/
    public static BaseOrder desc(String property) {
        return new BaseOrder(property, Direction.desc);
    }

    /**
     *@Description  获取属性
     * @return 属性
     */
    public String getProperty() {
        return property;
    }

    /**
     * @Description 设置属性
     * @param property 属性
     */
    public void setProperty(String property) {
        this.property = property;
    }

    /**
     *@Description  获取方向
     * @return 方向
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     *@Description  设置方向
     * @param direction 方向
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * @Description 重写equals方法
     * @param obj 对象
     * @return 是否相等
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        BaseOrder other = (BaseOrder) obj;
        return new EqualsBuilder().append(getProperty(), other.getProperty()).append(getDirection(), other.getDirection()).isEquals();
    }

    /**
     * @Description 重写hashCode方法
     * @return HashCode
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getProperty()).append(getDirection()).toHashCode();
    }

}
