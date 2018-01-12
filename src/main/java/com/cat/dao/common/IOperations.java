package com.cat.dao.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * This class is a common operation interface.
 * 
 * @author liangmanman
 * 
 * @param <T>
 */
public interface IOperations<T extends Serializable> {

    /**
     * 根据id查好记录
     * 
     * @param id
     *            记录id
     * @return
     */
    T findOne(final Long id);

    /**
     * 查找所有记录
     * 
     * @return
     */
    List<T> findAll();

    /**
     * 创建记录
     * 
     * @param entity
     */
    void create(final T entity);

    /**
     * 更新记录
     * 
     * @param entity
     *            记录对应实体类
     * @return
     */
    T update(final T entity);

    /**
     * 根据实体删除记录
     * 
     * @param entity
     */
    void delete(final T entity);

    /**
     * 根据记录id删除记录
     * 
     * @param entityId
     *            记录id
     */
    void deleteById(final long entityId);

    /**
     * 根据记录id查找记录
     * 
     * @param id
     *            记录id
     * @return
     */
    T findOneById(final int id);

    public List<Map<String, Object>> findMapListByType(String filterName, Object filterValue);

    void cleanSession(T entity);

    /**
     * 根据单一条件查询
     * 
     * @param tableName
     * @param value
     * @return
     */
    public List<T> findByCondition(String colName, Object value);

    /**
     * 根据多个条件查询
     * 
     * @param filterMaps
     * @return
     */
    public List<T> findByConditions(Map<String, Object> equalMaps);

    /**
     * 根据条件查询
     * 
     * @param equalMaps
     * @param inMaps
     * @return
     */
    public List<T> findByConditions(Map<String, Object> filterMaps, Map<String, List> inMaps);

    /**
     * 根据单个条件删除
     * 
     * @param colName
     * @param value
     */
    public void deleteByCondition(String colName, Object value);

    /**
     * 根据多个条件删除
     * 
     * @param filterMaps
     */
    public void deleteByConditions(Map<String, Object> equalMaps);

    /**
     * 分页查询
     * 
     * @param start
     * @param limit
     * @param custHql
     * @param equalMaps
     *            精确匹配条件
     * @param filterMaps
     *            模糊匹配条件
     * @param orderColumn
     *            排序列
     * @param order
     *            排序方式
     * @return
     */
    public List<T> findByPageFilter(int start, int limit, String custHql, Map<String, Object> equalMaps,
                                    Map<String, Object> filterMaps, Map<String, List<Object>> inListMap, String orderColumn, String order);

    /**
     * 分页查询totalCount
     *
     * @param equalMaps
     *            精确匹配条件
     * @param filterMaps
     *            模糊匹配条件
     * @return
     */
    public long findTotalCountByFilter(Map<String, Object> equalMaps, Map<String, Object> filterMaps,
                                       Map<String, List<Object>> inListMap);

    /**
     * 分页查询
     *
     * @param start
     * @param limit
     * @param custHql
     * @param equalMaps
     *            精确匹配条件
     * @param filterMaps
     *            模糊匹配条件
     * @param orderColumn
     *            排序列
     * @param order
     *            排序方式
     * @return
     */
    public List<IResultTransformerBean> findByPageFilterUsingSql(int start, int limit, String custHql,
                                                                 IResultTransformerBean resultTransformerBean, Map<String, Object> equalMaps,
                                                                 Map<String, Object> filterMaps, Map<String, List<Object>> inListMap, String orderColumn, String order);

    /**
     * 原生sql查询
     *
     * @param custHql
     * @param equalMaps
     *            精确匹配条件
     * @param filterMaps
     *            模糊匹配条件
     * @param orderColumn
     *            排序列
     * @param order
     *            排序方式
     * @return
     */
    public List<IResultTransformerBean> findByFilterUsingHql(
            String custHql, IResultTransformerBean resultTransformerBean,
            Map<String, Object> equalMaps, Map<String, Object> filterMaps, Map<String, List<Object>> inListMap,
            String orderColumn, String order);


    /**
     * 分页查询totalCount
     *
     * @param equalMaps
     *            精确匹配条件
     * @param filterMaps
     *            模糊匹配条件
     * @return
     */
    public long findTotalCountBySqlFilter(String custHql, Map<String, Object> equalMaps,
                                          Map<String, Object> filterMaps, Map<String, List<Object>> inListMap);

    public List<T> findByFilter(Map<String, Object> equalMaps, Map<String, Object> filterMaps, String orderColumn,
                                String order);

    /**
     * Batch delete entity by one key and its value list.
     * 
     * @param keyValueList
     *            The deletion key's value list
     */
    public void batchDeleteByIds(String deletionKey, List<Integer> keyValueList) throws Exception;

    /**
     * 判断指定条件 记录是否存在
     * 
     * @param colName
     * @param value
     */
    public boolean isExist(String colName, Object value);

    /**
     * 满足多个条件的记录是否存在
     * 
     * @param equalMaps
     * @return
     */
    public boolean isExist(Map<String, Object> equalMaps);

}
