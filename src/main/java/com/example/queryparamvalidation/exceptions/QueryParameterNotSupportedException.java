package com.example.queryparamvalidation.exceptions;


import java.util.Set;


public class QueryParameterNotSupportedException extends RuntimeException{
    private Set<String> invalidArgs;

    private Set<String> validArgs;

    public Set<String> getInvalidArgs() {
        return invalidArgs;
    }

    public Set<String> getValidArgs() {
        return validArgs;
    }

    public QueryParameterNotSupportedException(String msg, Set<String> invalidArgs, Set<String> validArgs){
        super(msg);
        this.invalidArgs=invalidArgs;
        this.validArgs=validArgs;
    }

}