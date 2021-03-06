/*
 * Waffle (https://github.com/Waffle/waffle)
 *
 * Copyright (c) 2010-2020 Application Security, Inc.
 *
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v10.html.
 *
 * Contributors: Application Security, Inc.
 */
package waffle.mock.http;

import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The Class SimpleFilterConfig.
 *
 * @author dblock[at]dblock[dot]org
 */
public class SimpleFilterConfig implements FilterConfig {

    /** The filter name. */
    private String filterName = "Simple Filter";

    /** The parameters. */
    private final Map<String, String> parameters = new TreeMap<>();

    @Override
    public String getFilterName() {
        return this.filterName;
    }

    /**
     * Sets the filter name.
     *
     * @param value
     *            the new filter name
     */
    public void setFilterName(final String value) {
        this.filterName = value;
    }

    @Override
    public String getInitParameter(final String s) {
        return this.parameters.get(s);
    }

    @Override
    public Enumeration<String> getInitParameterNames() {
        final List<String> keys = new ArrayList<>();
        keys.addAll(this.parameters.keySet());
        return Collections.enumeration(keys);
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    /**
     * Sets the parameter.
     *
     * @param parameterName
     *            the parameter name
     * @param parameterValue
     *            the parameter value
     */
    public void setParameter(final String parameterName, final String parameterValue) {
        this.parameters.put(parameterName, parameterValue);
    }
}
