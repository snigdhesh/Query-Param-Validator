package com.example.queryparamvalidation.utils;

import com.example.queryparamvalidation.services.Queryable;


import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ArgsChecker<T> {

    private Set<String> validArgs;

    private ArgsChecker(){};

    public Set<String> getValidArgs() {
        return validArgs;
    }

    public void setValidArgs(Set<String> validArgs) {
        this.validArgs = validArgs;
    }

    public ArgsChecker(Class<T> someEntityClass){
        validArgs= FieldUtils.getFieldsListWithAnnotation(someEntityClass,Queryable.class)
                .stream()
                .map(Field::getName)
                .collect(Collectors.toSet());
        validArgs.add("page");
        validArgs.add("size");

    }

    public Set<String> getInvalidArgs(final Set<String> args){
        Set<String> invalidArgs=new HashSet<>(args);
        invalidArgs.removeAll(validArgs);
        return invalidArgs;



    }
}