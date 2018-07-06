package com.formation.spring.udemy.Utils.PojoQueryingPredicates;

import com.formation.spring.udemy.Utils.QPojoUtils.PojoUtils;

public class PojoQueryingPredicator<T> {

    private Class className;

    public PojoQueryingPredicator(Class className) {
        this.className = className;
    }

    public T getQClasse() {
        return (T) PojoUtils.getQPojo(className);
    }

}
