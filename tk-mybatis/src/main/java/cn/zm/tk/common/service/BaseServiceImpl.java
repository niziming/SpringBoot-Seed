package cn.zm.tk.common.service;

import cn.zm.tk.common.func.ListFunc;
import cn.zm.tk.common.mapper.BaseMapper;
import cn.zm.tk.common.util.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @ClassName BaseServiceImpl
 * @Description 基础service
 * @Author yeehaw
 * @Date 2019/12/12 10:58
 * @Version 1.0.0
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    @Autowired
    protected BaseMapper<T> mapper;

    public Mapper<T> getMapper() {
        return mapper;
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    /**
     * 条件查询
     *
     * @param record
     * @return
     */
    @Override
    public List<T> selectByProperty(T record) {
        return mapper.select(record);
    }

    /**
     * 条件查询单个 若存在多个则异常
     *
     * @param record
     * @return
     */
    @Override
    public T selectOneByProperty(T record) {
        return mapper.selectOne(record);
    }

    /**
     * 通过主键 id 查询
     *
     * @param id
     * @return
     */
    @Override
    public T selectById(Object id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 通过主键 ids 查询
     *
     * @param ids
     * @return
     */
    @Override
    public List<T> selectByIds(List<Long> ids) {
        return mapper.selectByIds(ids);
    }
    /**
     * 保存
     *
     * @param record
     * @return
     */
    @Override
    public int save(T record) {
        return mapper.insert(record);
    }

    /**
     * 保存多个
     *
     * @param records
     * @return
     */
    @Override
    public int saveBatch(List<T> records) {
        return mapper.insertList(records);
    }

    /**
     * 存在字段保存
     *
     * @param record
     * @return
     */
    @Override
    public int saveSelective(T record) {
        return mapper.insertSelective(record);
    }

    /**
     * 根据主键更新
     *
     * @param record
     * @return
     */
    @Override
    public int updateById(T record) {
        return mapper.updateByPrimaryKey(record);
    }

    /**
     * 根据主键更新不为空的字段
     *
     * @param record
     * @return
     */
    @Override
    public int updateSelectiveById(T record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageBean<T> selectPageByProperty(T record, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<T> list = mapper.select(record);
        return new PageBean<T>(list);
    }

    public PageBean<T> selectPageByFunc(ListFunc<T> func, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<T> list = func.list();
        return new PageBean<T>(list);
    }
}