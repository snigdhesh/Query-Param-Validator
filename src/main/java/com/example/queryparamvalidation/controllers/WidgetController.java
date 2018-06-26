package com.example.queryparamvalidation.controllers;

import com.example.queryparamvalidation.exceptions.QueryParameterNotSupportedException;
import com.example.queryparamvalidation.models.Widget;
import com.example.queryparamvalidation.utils.ArgsChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
@ExposesResourceFor(Widget.class)
@RequestMapping("/widgets")
public class WidgetController {


    @Autowired
    ArgsChecker<Widget> widgetArgsChecker;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/hal+json"})
    public HttpEntity<PagedResources<Widget>> findAll(@RequestParam Map<String, String> allRequestParams, SpringDataWebProperties.Pageable pageable) {
        Set<String> invalidArgs = widgetArgsChecker.getInvalidArgs(allRequestParams.keySet());
        if (invalidArgs.size() > 0) {
            throw new QueryParameterNotSupportedException("The user supplied query parameter(s) that are not supported: " + invalidArgs + " . See below for a list of query paramters that are supported by the widget endpoint.", invalidArgs, widgetArgsChecker.getValidArgs());

        }
        return null;
    }

}