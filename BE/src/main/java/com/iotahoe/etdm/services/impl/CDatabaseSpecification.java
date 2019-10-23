package com.iotahoe.etdm.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.iotahoe.etdm.entities.CDatabase;
import com.iotahoe.etdm.entities.CDatabase_;
import com.iotahoe.etdm.entities.RDatabaseType_;

import org.springframework.data.jpa.domain.Specification;

public class CDatabaseSpecification implements Specification<CDatabase> {
    Map<String, String> filters;

    public CDatabaseSpecification(Map<String, String> filters) {
        this.filters = filters;
    }

    @Override
    public Predicate toPredicate(Root<CDatabase> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> preds = new ArrayList<>();
        String value = filters.get("type");
        if (value != null && !"all".equals(value.toLowerCase())) {
            preds.add(builder.and(builder.equal(root.join(CDatabase_.databaseType).get(RDatabaseType_.type), value)));
        }
        value = filters.get("url");
        if (value != null && !value.isEmpty())) {
            preds.add(builder.and(builder.like(root.join(CDatabase_.url), wildCards(value))));
        }
        
        value = filters.get("name");
        if (value != null && !value.isEmpty())) {
            preds.add(builder.and(builder.like(root.join(CDatabase_.url), wildCards(value))));
        }
        
        return builder.and(preds.toArray(new Predicate[preds.size()]));
    }

    private String wildCards(String value) {
        return value.replace("*", "%").replace("?", "_");
    }

}