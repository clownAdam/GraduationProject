package cn.clown.common.bean;

/**
 * 数据对象抽象类
 * >继承Val值对象接口
 * >实现对数据对象content的get/set
 *
 * @author clown
 */
public abstract class AbstractData implements Val {
    /**
     * 数据对象内容
     */
    public String content;

    /**
     * 设置content
     *
     * @param val 值属性
     */
    @Override
    public void setValue(Object val) {
        content = (String) val;
    }

    /**
     * 获取值
     *
     * @return 返回content的值
     */
    @Override
    public String getValue() {
        return content;
    }
}
