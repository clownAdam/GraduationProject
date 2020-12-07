package cn.clown.common.bean;

/**
 * 值对象接口
 * 实现值接口可以设置值和获取值
 *
 * @author clown
 */
public interface Val {
    /**
     * 设置值
     *
     * @param val 值属性
     */
    public void setValue(Object val);

    /**
     * 获取值
     *
     * @return 返回Object的值
     */
    public Object getValue();
}
