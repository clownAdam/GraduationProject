package cn.clown.common.bean;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/**
 * DataIn接口
 * >定义数据来源需要遵守的规范
 * >数据来源可设置路径和读取数据
 * >涉及传输,继承Closeable
 *
 * @author clown
 */
public interface DataIn extends Closeable {
    /**
     * 设置文件数据路径或数据的来源
     *
     * @param path 数据数据/文件路径
     */
    public void setPath(String path);

    /**
     * 读取数据
     *
     * @return 返回数据内容
     * @throws IOException io异常
     */
    public Object read() throws IOException;

    /**
     * 读取固定bean类型的数据并返回该类型多条数据
     *
     * @param clazz 根据反射获取需要读取类型的数据
     * @param <T>   反射类型必须继承抽象数据类
     * @return 返回该类型多条List数据
     * @throws IOException io异常
     */
    public <T extends AbstractData> List<T> read(Class<T> clazz) throws IOException;
}
