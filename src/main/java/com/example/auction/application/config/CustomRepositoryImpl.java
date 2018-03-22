package com.example.auction.application.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.util.Assert;

public class CustomRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
        implements CustomRepository<T, ID> {

    private final EntityManager em;

    public CustomRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.em = entityManager;
    }

//    public List<T> findAll() {
//        Sort sort = getRequestSort();
//        if(null != sort) {
//            return super.findAll(sort);
//        }
//        return super.findAll();
//    }
//
//    public List<T> findAll(Iterable<ID> ids) {
//        return super.findAll(ids);
//    }
//
//    public Page<T> findAll(Pageable pageable) {
//        if(null == pageable) {
//            pageable = getRequestPageable();
//        }
//        return super.findAll(pageable);
//    }
//
//    public List<T> findAll(Specification<T> spec) {
//        Sort sort = getRequestSort();
//        if(null != sort) {
//            return super.findAll(spec, sort);
//        }
//        return super.findAll(spec);
//    }
//
//    public Page<T> findAll(Specification<T> spec, Pageable pageable) {
//        if(null == pageable) {
//            pageable = getRequestPageable();
//        }
//        return super.findAll(spec, pageable);
//    }
//
//    @Override
//    public <S extends T> List<S> findAll(Example<S> example) {
//        Sort sort = getRequestSort();
//        if(null != sort) {
//            return super.findAll(example, sort);
//        }
//        return super.findAll(example);
//    }
//
//    @Override
//    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
//        if(null == pageable) {
//            pageable = getRequestPageable();
//        }
//        return super.findAll(example, pageable);
//    }
//
//    protected <S extends T> TypedQuery<S> getQuery(Specification<S> spec, Class<S> domainClass, Sort sort) {
//
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<S> query = builder.createQuery(domainClass);
//
//        Root<S> root = applySpecificationToCriteria(spec, domainClass, query);
//        if(null == query.getSelection()) {
//            query.select(root);
//        }
//
//        if (sort != null) {
//            query.orderBy(QueryUtils.toOrders(sort, root, builder));
//        }
//
//        return applyRepositoryMethodMetadata(em.createQuery(query));
//    }
//
//    private <S, U extends T> Root<U> applySpecificationToCriteria(Specification<U> spec, Class<U> domainClass,
//                                                                  CriteriaQuery<S> query) {
//
//        Assert.notNull(query);
//        Assert.notNull(domainClass);
//        Root<U> root = query.from(domainClass);
//
//        if (spec == null) {
//            return root;
//        }
//
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        Predicate predicate = spec.toPredicate(root, query, builder);
//
//        if (predicate != null) {
//            query.where(predicate);
//        }
//
//        return root;
//    }
//
//    private <S> TypedQuery<S> applyRepositoryMethodMetadata(TypedQuery<S> query) {
//        CrudMethodMetadata metadata = this.getRepositoryMethodMetadata();
//
//        if (metadata == null) {
//            return query;
//        }
//
//        LockModeType type = metadata.getLockModeType();
//        TypedQuery<S> toReturn = type == null ? query : query.setLockMode(type);
//
//        applyQueryHints(toReturn);
//
//        return toReturn;
//    }
//
//    private void applyQueryHints(Query query) {
//
//        for (Entry<String, Object> hint : getQueryHints().entrySet()) {
//            query.setHint(hint.getKey(), hint.getValue());
//        }
//    }
//
//    private Sort getRequestSort() {
//        SystemRequest sr = SystemRequestHolder.getSystemRequest();
//        if(null == sr) {
//            return null;
//        }
//        String order = sr.getOrder();
//        String sort = sr.getSort();
//        if(null == sort || "".equals(sort)) {
//            return null;
//        }
//        if(null != order && !"".equals(order)) {
//            order = order.toLowerCase();
//        }
//        sort = sort.replaceAll("\\s*", "");
//        String[] atts = sort.split(",");
//        if(0 >= atts.length){
//            return null;
//        }
//        if(null == order || "".equals(order)) {
//            order = "desc";
//        }
//        String[] orderTypes = order.split(",");
//        List<Order> orders=new ArrayList<Order>();
//        for(int i = 0; i < atts.length; i ++) {
//            String property = null;
//            Class<T> clazz = this.getDomainClass();
//            try {
//                clazz.getDeclaredField(atts[i]);
//                property = atts[i];
//            } catch (NoSuchFieldException | SecurityException e) {
//                property = null;
//            }
//            if(property == null) {
//                continue;
//            }
//            Sort.Direction direction = null;
//            if(i < orderTypes.length) {
//                direction = "desc".equals(orderTypes[i]) ? Sort.Direction.DESC : Sort.Direction.ASC;
//            } else {
//                direction = "desc".equals(orderTypes[orderTypes.length - 1]) ? Sort.Direction.DESC : Sort.Direction.ASC;
//            }
//            orders.add(new Order(direction, property));
//        }
//        if(0 >= orders.size()) {
//            return null;
//        }
//        return new Sort(orders);
//    }
//
//    private Pageable getRequestPageable() {
//        Sort sort = getRequestSort();
//        if(null == sort) {
//            return new PageRequest(getRequestPageOffset(), getRequestPageSize());
//        } else {
//            return new PageRequest(getRequestPageOffset(), getRequestPageSize(), sort);
//        }
//    }
//
//    protected SystemRequest getSystemRequest() {
//        SystemRequest sr = SystemRequestHolder.getSystemRequest();
//        if (sr == null){
//            sr = new SystemRequest();
//        }
//        return sr;
//    }
//
//    private Integer getRequestPageOffset() {
//        Integer pageOffset = getSystemRequest().getPageOffset();
//        if (pageOffset == null || pageOffset < 1) {
//            pageOffset = 1;
//        }
//        return pageOffset - 1;
//    }
//
//    private Integer getRequestPageSize() {
//        Integer pageSize = getSystemRequest().getPageSize();
//        if (pageSize == null || pageSize < 0) {
//            pageSize = PageParams.DEFAULT_PAGE_SIZE;
//        }
//        return pageSize;
//    }
}
