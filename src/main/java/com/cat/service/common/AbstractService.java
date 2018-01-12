package com.cat.service.common;

import com.cat.dao.common.IOperations;
import com.cat.dao.common.IResultTransformerBean;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * This is a class to implement the common service operations.
 * 
 * @author liangmanman
 * 
 * @param <T>
 */
@Transactional
public abstract class AbstractService<T extends Serializable> implements IOperations<T> {

    protected abstract IOperations<T> getDao();

    @Override
    public T findOne(final Long id) {
        return getDao().findOne(id);
    }

    @Override
    public T findOneById(final int id) {
        return getDao().findOneById(id);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public void create(final T entity) {
        getDao().create(entity);
    }

    @Override
    public T update(final T entity) {
        return getDao().update(entity);
    }

    @Override
    public void delete(final T entity) {
        getDao().delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        getDao().deleteById(entityId);
    }

    /**
     * @author liangmanman
     * @param filterName
     * @param filterValue
     * @return
     */
    @Override
    public List<Map<String, Object>> findMapListByType(String name, Object value) {
        return getDao().findMapListByType(name, value);
    }

    @Override
    public void cleanSession(T entity) {
        getDao().cleanSession(entity);
    }

    @Override
    public List<T> findByCondition(String tableName, Object value) {
        return getDao().findByCondition(tableName, value);
    }

    @Override
    public List<T> findByConditions(Map<String, Object> filterMaps) {
        return getDao().findByConditions(filterMaps);
    }

    @Override
    public List<T> findByConditions(Map<String, Object> filterMaps, Map<String, List> inMaps) {
        return getDao().findByConditions(filterMaps, inMaps);
    }

    @Override
    public void deleteByCondition(String colName, Object value) {
        getDao().deleteByCondition(colName, value);
    }

    @Override
    public void deleteByConditions(Map<String, Object> filterMaps) {
        getDao().deleteByConditions(filterMaps);
    }

    @Override
    public List<T> findByPageFilter(int start, int limit, String custHql, Map<String, Object> equalMaps,
            Map<String, Object> filterMaps, Map<String, List<Object>> inListMap, String orderColumn, String order) {
        return getDao().findByPageFilter(start, limit, custHql, equalMaps, filterMaps, inListMap, orderColumn, order);
    }

    @Override
    public List<IResultTransformerBean> findByPageFilterUsingSql(int start, int limit, String custHql,
            IResultTransformerBean resultTransformerBean, Map<String, Object> equalMaps,
            Map<String, Object> filterMaps, Map<String, List<Object>> inListMap, String orderColumn, String order) {
        return getDao().findByPageFilterUsingSql(start, limit, custHql, resultTransformerBean, equalMaps, filterMaps,
                inListMap, orderColumn, order);
    }

    @Override
    public List<IResultTransformerBean> findByFilterUsingHql(
            String custHql, IResultTransformerBean resultTransformerBean,
            Map<String, Object> equalMaps, Map<String, Object> filterMaps, Map<String, List<Object>> inListMap,
            String orderColumn, String order) {
        return getDao().findByFilterUsingHql(custHql, resultTransformerBean, equalMaps, filterMaps,
                inListMap, orderColumn, order);
    }

    @Override
    public List<T> findByFilter(Map<String, Object> equalMaps, Map<String, Object> filterMaps, String orderColumn,
            String order) {
        return getDao().findByFilter(equalMaps, filterMaps, orderColumn, order);
    }

    @Override
    public long findTotalCountByFilter(Map<String, Object> equalMaps, Map<String, Object> filterMaps,
            Map<String, List<Object>> inListMap) {
        return getDao().findTotalCountByFilter(equalMaps, filterMaps, inListMap);
    }

    @Override
    public long findTotalCountBySqlFilter(String custHql, Map<String, Object> equalMaps,
            Map<String, Object> filterMaps, Map<String, List<Object>> inListMap) {
        return getDao().findTotalCountBySqlFilter(custHql, equalMaps, filterMaps, inListMap);
    }

    /**
     * Batch delete entity by one key and its value list.
     * 
     * @param keyValueList
     *            The deletion key's value list
     */
    @Override
    public void batchDeleteByIds(String deletionKey, List<Integer> keyValueList) throws Exception {
        getDao().batchDeleteByIds(deletionKey, keyValueList);
    }

    @Override
    public boolean isExist(String colName, Object value) {
        return getDao().isExist(colName, value);
    }

    @Override
    public boolean isExist(Map<String, Object> equalMaps) {
        return getDao().isExist(equalMaps);
    }
}
