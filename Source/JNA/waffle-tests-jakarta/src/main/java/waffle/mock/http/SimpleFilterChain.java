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

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

/**
 * Simple filter chain.
 *
 * @author dblock[at]dblock[dot]org
 */
public class SimpleFilterChain implements FilterChain {

    /** The request. */
    private ServletRequest request;

    /** The response. */
    private ServletResponse response;

    /**
     * Gets the request.
     *
     * @return the request
     */
    public ServletRequest getRequest() {
        return this.request;
    }

    /**
     * Gets the response.
     *
     * @return the response
     */
    public ServletResponse getResponse() {
        return this.response;
    }

    @Override
    public void doFilter(final ServletRequest sreq, final ServletResponse srep) throws IOException, ServletException {
        this.request = sreq;
        this.response = srep;
    }
}
