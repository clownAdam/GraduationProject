package cn.clown.common.bean;

import java.io.Closeable;

/**
 * 生产者接口
 * >定义数据生产的规范
 * >数据生产会涉及流的相关操作,继承Closeable可关闭资源.
 * >生产者接口必须设置数据来源,数据输出,和数据生产.
 *
 * @author clown
 */
public interface Producer extends Closeable {
    /**
     * 设置数据来源
     *
     * @param dataIn 数据来源
     */
    public void setIn(DataIn dataIn);

    /**
     * 设置数据输出
     *
     * @param dataOut 数据输出
     */
    public void setOut(DataOut dataOut);

    /**
     * 生产数据
     */
    public void produce();
}
