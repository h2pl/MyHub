package com.cat.dao.common;

import com.google.common.base.Preconditions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * This class is used to implement common hibernate CRUD operations.
 *
 * 
 */
public abstract class AbstractHibernateDao<T extends Serializable> implements IOperations<T> {

    private Class<T> clazz;

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    protected final void setClazz(final Class<T> clazzToSet) {
        this.clazz = Preconditions.checkNotNull(clazzToSet);
    }

    protected final Session getCurrentSession() {

        return sessionFactory.getCurrentSession();
    }

    protected final Session openSession() {

        return sessionFactory.openSession();
    }

    @Override
    public final T findOne(final Long id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    @Override
    public final T findOneById(final int id) {
        return (T) getCurrentSession().get(clazz, id);
    }

    @Override
    public final List<T> findAll() {
        return getCurrentSession().createQuery("from " + clazz.getName()).list();
    }

    @Override
    public final void create(final T entity) {
        Preconditions.checkNotNull(entity);
        // getCurrentSession().persist(entity);
        getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public final void cleanSession(final T entity) {
        getCurrentSession().evict(entity);
    }

    @Override
    public final T update(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().merge(entity);
        // getCurrentSession().update(entity);
        getCurrentSession().flush();
        return entity;
        // return (T)getCurrentSession().merge(entity);
    }

    @Override
    public final void delete(final T entity) {
        Preconditions.checkNotNull(entity);
        getCurrentSession().delete(entity);
    }

    @Override
    public final void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        Preconditions.checkState(entity != null);
        delete(entity);
    }

    /**
     * @author liangmanman
     * @param filterName
     * @param filterValue
     * @return
     */
    @Override
    public List<Map<String, Object>> findMapListByType(String filterName, Object filterValue) {
        StringBuffer hql = new StringBuffer();
        hql.append("select new map(t.").append(filterName).append(" as " + filterName + ") from ");
        hql.append(clazz.getName());
        hql.append(" as t where ");
        hql.append(filterName + "= :" + filterName);
        Query q = getCurrentSession().createQuery(hql.toString());
        q.setParameter(filterName, filterValue);
        List<Map<String, Object>> mapList = q.list();
        return mapList;
    }

    @Override
    public List<T> findByCondition(String colName, Object value) {
        StringBuffer hql = new StringBuffer();
        hql.append("from " + clazz.getName());
        hql.append(" where " + colName + "= :" + colName);
        Query q = getCurrentSession().createQuery(hql.toString());
        q.setParameter(colName, value);
        return q.list();
    }

    @Override
    public List<T> findByConditions(Map<String, Object> filterMaps) {
        StringBuffer hql = new StringBuffer();
        hql.append("from " + clazz.getName());
        hql.append(" where 1 = 1");
        boolean useFilter = false;
        if (filterMaps != null && !filterMaps.isEmpty()) {
            useFilter = true;
            for (Map.Entry<String, Object> entry : filterMaps.entrySet()) {
                String filterName = entry.getKey();
                hql.append(" and " + filterName + " = :" + filterName);
            }
        }
        Query q = getCurrentSession().createQuery(hql.toString());

        if (useFilter) {
            for (Map.Entry<String, Object> entry : filterMaps.entrySet()) {
                String filterName = entry.getKey();
                Object filterValue = entry.getValue();
                q.setParameter(filterName, filterValue);
            }
        }
        return q.list();
    }

    @Override
    public List<T> findByConditions(Map<String, Object> filterMaps, Map<String, List> inMaps) {
        StringBuffer hql = new StringBuffer();
        hql.append("from " + clazz.getName());
        hql.append(" where 1 = 1");
        boolean useFilter = false;
        if (filterMaps != null && !filterMaps.isEmpty()) {
            useFilter = true;
            for (Map.Entry<String, Object> entry : filterMaps.entrySet()) {
                String filterName = entry.getKey();
                hql.append(" and " + filterName + " = :" + filterName);
            }
        }

        boolean useIn = false;
        if (inMaps != null && !inMaps.isEmpty()) {
            useIn = true;
            for (Map.Entry<String, List> entry : inMaps.entrySet()) {
                String inName = entry.getKey();
                hql.append(" and " + inName + " in (:" + inName + ")");
            }
        }

        Query q = getCurrentSession().createQuery(hql.toString());

        if (useFilter) {
            for (Map.Entry<String, Object> entry : filterMaps.entrySet()) {
                String filterName = entry.getKey();
                Object filterValue = entry.getValue();
                q.setParameter(filterName, filterValue);
            }
        }

        if (useIn) {
            for (Map.Entry<String, List> entry : inMaps.entrySet()) {
                String inName = entry.getKey();
                List<Object> inValue = entry.getValue();
                q.setParameterList(inName, inValue);
            }
        }

        return q.list();
    }

    @Override
    public void deleteByCondition(String colName, Object value) {
        StringBuffer hql = new StringBuffer();
        hql.append("delete from " + clazz.getName());
        hql.append(" where " + colName + "= :" + colName);
        Query q = getCurrentSession().createQuery(hql.toString());
        q.setParameter(colName, value);
        q.executeUpdate();
    }

    @Override
    public void deleteByConditions(Map<String, Object> filterMaps) {
        StringBuffer hql = new StringBuffer();
        hql.append("delete from " + clazz.getName());
        hql.append(" where 1 = 1");
        boolean useFilter = false;
        if (filterMaps != null && !filterMaps.isEmpty()) {
            useFilter = true;
            for (Map.Entry<String, Object> entry : filterMaps.entrySet()) {
                String filterName = entry.getKey();
                hql.append(" and " + filterName + " = :" + filterName);
            }
        }
        Query q = getCurrentSession().createQuery(hql.toString());

        if (useFilter) {
            for (Map.Entry<String, Object> entry : filterMaps.entrySet()) {
                String filterName = entry.getKey();
                Object filterValue = entry.getValue();
                q.setParameter(filterName, filterValue);
            }
        }
        q.executeUpdate();
    }

    @Override
    public List<T> findByPageFilter(int start, int limit, String custHql, Map<String, Object> equalMaps,
            Map<String, Object> filterMaps, Map<String, List<Object>> inListMap, String orderColumn, String order) {

        StringBuffer hql = new StringBuffer();
        if (custHql == null || custHql.trim().equals("")) {
            hql.append("from ");
            hql.append(clazz.getName());
        } else {
            hql.append(custHql);
        }

        hql.append(" where 1=1 ");

        Query q = genQueryByFilter(hql, null, equalMaps, filterMaps, inListMap, orderColumn, order, false);

        q.setFirstResult(start);
        q.setMaxResults(limit);

        return q.list();
    }

    @Override
    public List<IResultTransformerBean> findByPageFilterUsingSql(int start, int limit, String custHql,
            IResultTransformerBean resultTransformerBean, Map<String, Object> equalMaps,
            Map<String, Object> filterMaps, Map<String, List<Object>> inListMap, String orderColumn, String order) {

        StringBuffer hql = new StringBuffer();
        if (custHql == null || custHql.trim().equals("")) {
            hql.append("from ");
            hql.append(clazz.getName());
            hql.append(" where 1=1 ");
        } else {
            hql.append(custHql);

        }
        Query q = genQueryByFilter(hql, resultTransformerBean, equalMaps, filterMaps, inListMap, orderColumn, order,
                true);
        q.setFirstResult(start);
        q.setMaxResults(limit);

        return q.list();
    }

    @Override
    public List<IResultTransformerBean> findByFilterUsingHql(
            String custHql, IResultTransformerBean resultTransformerBean,
            Map<String, Object> equalMaps, Map<String, Object> filterMaps, Map<String, List<Object>> inListMap,
            String orderColumn, String order) {

        StringBuffer hql = new StringBuffer();
        if (custHql == null || custHql.trim().equals("")) {
            hql.append("from ");
            hql.append(clazz.getName());
            hql.append(" where 1=1 ");
        } else {
            hql.append(custHql);

        }
        Query q = genQueryByFilter(hql, resultTransformerBean, equalMaps, filterMaps, inListMap, orderColumn, order,
                false);

        return q.list();
    }


    @Override
    public long findTotalCountByFilter(Map<String, Object> equalMaps, Map<String, Object> filterMaps,
            Map<String, List<Object>> inListMap) {
        StringBuffer hql = new StringBuffer();
        hql.append("select new map(count(id) as totalCount) from ");
        hql.append(clazz.getName());
        hql.append(" where 1=1 ");
        List<Map<Object, Long>> userList = genQueryByFilter(hql, null, equalMaps, filterMaps, inListMap, null, null,
                false).list();
        return userList.get(0).get("totalCount");
    }

    @Override
    public long findTotalCountBySqlFilter(String custHql, Map<String, Object> equalMaps,
            Map<String, Object> filterMaps, Map<String, List<Object>> inListMap) {
        StringBuffer hql = new StringBuffer();

        long resultTotal = 0L;
        if (custHql == null || custHql.trim().equals("")) {
            hql.append("select count(id) as totalCount) from ");
            hql.append(clazz.getName());
            hql.append(" where 1=1 ");
        } else {
            hql.append(custHql);
        }
        Query q = genQueryByFilter(hql, null, equalMaps, filterMaps, inListMap, null, null, true);
        List<Long> userList = q.list();
        resultTotal = userList.get(0);
        return resultTotal;
    }

    public Query genQueryByFilter(StringBuffer hql, IResultTransformerBean resultTransformerBean,
            Map<String, Object> equalMaps, Map<String, Object> filterMaps, Map<String, List<Object>> inListMap,
            String orderColumn, String order, boolean usingSql) {
        boolean useEqualFilter = false;
        if (equalMaps != null && !equalMaps.isEmpty()) {
            useEqualFilter = true;
            for (Map.Entry<String, Object> entry : equalMaps.entrySet()) {
                String equalName = entry.getKey();
                hql.append(" and " + equalName + " = :" + equalName);
            }
        }

        boolean useFilter = false;
        if (filterMaps != null && !filterMaps.isEmpty()) {
            useFilter = true;
            for (Map.Entry<String, Object> entry : filterMaps.entrySet()) {
                String filterName = entry.getKey();
                hql.append(" and " + filterName + " like :" + filterName);
            }
        }

        boolean useInListMap = false;
        if (inListMap != null && !inListMap.isEmpty()) {
            useInListMap = true;
            for (Map.Entry<String, List<Object>> entry : inListMap.entrySet()) {
                String equalName = entry.getKey();
                hql.append(" and " + equalName + " in (:" + equalName + ")");
            }
        }

        if (orderColumn != null && !StringUtils.isEmpty(orderColumn)) {
            if (null == order || StringUtils.isEmpty(order)) {
                order = "desc";
            }
            hql.append(" order by " + orderColumn + " " + order);
        }

        Query q = null;
        if (!usingSql) { // Use hql to do query
            q = getCurrentSession().createQuery(hql.toString());
        } else { // Use sql to do query
            if (resultTransformerBean == null) { // Query the total count
                q = getCurrentSession().createSQLQuery(hql.toString()).addScalar("totalCount", LongType.INSTANCE);
            } else { // Query the list by paging and filter info
                q = getCurrentSession().createSQLQuery(hql.toString()).setResultTransformer(
                        Transformers.aliasToBean(resultTransformerBean.getClass()));
            }
        }

        if (useEqualFilter) {
            for (Map.Entry<String, Object> entry : equalMaps.entrySet()) {
                String equalName = entry.getKey();
                Object equalValue = entry.getValue();
                q.setParameter(equalName, equalValue);
            }
        }

        if (useFilter) {
            for (Map.Entry<String, Object> entry : filterMaps.entrySet()) {
                String filterName = entry.getKey();
                Object filterValue = entry.getValue();
                q.setParameter(filterName, "%" + filterValue + "%");

            }
        }

        if (useInListMap) {
            for (Map.Entry<String, List<Object>> entry : inListMap.entrySet()) {
                String filterName = entry.getKey();
                List<Object> filterValue = entry.getValue();
                q.setParameterList(filterName, filterValue);

            }
        }
        return q;

    }

    @Override
    public List<T> findByFilter(Map<String, Object> equalMaps, Map<String, Object> filterMaps, String orderColumn,
            String order) {
        if (null == order || StringUtils.isEmpty(order)) {
            order = "desc";
        }
        StringBuffer hql = new StringBuffer();
        hql.append("from ");
        hql.append(clazz.getName());

        hql.append(" where 1=1 ");
        boolean useEqualMaps = false;
        if (equalMaps != null && !equalMaps.isEmpty()) {
            useEqualMaps = true;
            for (Map.Entry<String, Object> entry : equalMaps.entrySet()) {
                String equalName = entry.getKey();
                hql.append(" and " + equalName + "= :" + equalName);
            }
        }

        boolean useFilter = false;
        if (filterMaps != null && !filterMaps.isEmpty()) {
            useFilter = true;
            for (Map.Entry<String, Object> entry : filterMaps.entrySet()) {
                String filterName = entry.getKey();
                hql.append(" and " + filterName + " like :" + filterName);
            }
        }

        if (orderColumn != null && !StringUtils.isEmpty(orderColumn)) {
            hql.append(" order by " + orderColumn + " " + order);
        }
        Query q = getCurrentSession().createQuery(hql.toString());

        if (useEqualMaps) {
            for (Map.Entry<String, Object> entry : equalMaps.entrySet()) {
                String equalName = entry.getKey();
                Object equalValue = entry.getValue();
                q.setParameter(equalName, equalValue);

            }
        }

        if (useFilter) {
            for (Map.Entry<String, Object> entry : filterMaps.entrySet()) {
                String filterName = entry.getKey();
                Object filterValue = entry.getValue();
                q.setParameter(filterName, "%" + filterValue + "%");

            }
        }

        return q.list();
    }

    @Override
    public void batchDeleteByIds(String deletionKey, List<Integer> keyValueList) throws Exception {
        StringBuffer hql = new StringBuffer();
        hql.append("delete from ");
        hql.append(clazz.getName());
        hql.append(" where " + deletionKey + " in (:keyValueList)");
        Query query = getCurrentSession().createQuery(hql.toString());
        query.setParameterList("keyValueList", keyValueList);
        query.executeUpdate();
    }

    @Override
    public boolean isExist(String colName, Object value) {
        StringBuffer hql = new StringBuffer();
        hql.append("select 1 from " + clazz.getName());
        hql.append(" where " + colName + "= :" + colName);
        Query q = getCurrentSession().createQuery(hql.toString());
        q.setParameter(colName, value);
        return q.list().size() > 0;
    }

    @Override
    public boolean isExist(Map<String, Object> equalMaps) {
        StringBuffer hql = new StringBuffer();
        hql.append("select 1 from " + clazz.getName());
        hql.append(" where 1 = 1");
        boolean useFilter = false;
        if (equalMaps != null && !equalMaps.isEmpty()) {
            useFilter = true;
            for (Map.Entry<String, Object> entry : equalMaps.entrySet()) {
                String filterName = entry.getKey();
                hql.append(" and " + filterName + " = :" + filterName);
            }
        }
        Query q = getCurrentSession().createQuery(hql.toString());

        if (useFilter) {
            for (Map.Entry<String, Object> entry : equalMaps.entrySet()) {
                String filterName = entry.getKey();
                Object filterValue = entry.getValue();
                q.setParameter(filterName, filterValue);
            }
        }
        return q.list().size() > 0;
    }
}
