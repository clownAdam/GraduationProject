package cn.clown.common.bean;

import java.io.Closeable;

/**
 * DataOut接口
 * >定义数据输出需要遵守的规范
 * >数据输出接口必须实现可设置输出路径和数据的写出
 * >设计传输,继承CloseAble
 *
 * @author clown
 */
public interface DataOut extends Closeable {
    /**
     * 设置文件/数据输出路径
     *
     * @param path 数据写出路径
     */
    public void setPath(String path);

    /**
     * 写出Object类型数据
     *
     * @param data Object数据
     * @throws Exception 异常
     */
    public void write(Object data) throws Exception;

    /**
     * 写出String类型数据
     *
     * @param data String数据
     * @throws Exception 异常
     */
    public void write(String data) throws Exception;
}
