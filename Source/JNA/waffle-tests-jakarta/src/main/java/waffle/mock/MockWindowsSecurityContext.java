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
package waffle.mock;

import com.sun.jna.platform.win32.Sspi.CtxtHandle;
import com.sun.jna.platform.win32.Sspi.SecBufferDesc;

import java.util.ArrayList;
import java.util.List;

import waffle.windows.auth.IWindowsIdentity;
import waffle.windows.auth.IWindowsImpersonationContext;
import waffle.windows.auth.IWindowsSecurityContext;

/**
 * The Class MockWindowsSecurityContext.
 *
 * @author dblock[at]dblock[dot]org
 */
public class MockWindowsSecurityContext implements IWindowsSecurityContext {

    /** The identity. */
    private final IWindowsIdentity identity;

    /**
     * Instantiates a new mock windows security context.
     *
     * @param username
     *            the username
     */
    public MockWindowsSecurityContext(final String username) {
        final List<String> groups = new ArrayList<>();
        groups.add("Users");
        groups.add("Everyone");
        this.identity = new MockWindowsIdentity(username, groups);
    }

    @Override
    public void dispose() {
        // Do Nothing
    }

    @Override
    public boolean isContinue() {
        return false;
    }

    @Override
    public CtxtHandle getHandle() {
        return new CtxtHandle();
    }

    @Override
    public IWindowsIdentity getIdentity() {
        return this.identity;
    }

    @Override
    public String getPrincipalName() {
        return this.identity.getFqn();
    }

    @Override
    public String getSecurityPackage() {
        return "Mock";
    }

    @Override
    public byte[] getToken() {
        return new byte[0];
    }

    @Override
    public IWindowsImpersonationContext impersonate() {
        return new MockWindowsImpersonationContext();
    }

    /**
     * Initialize.
     */
    public void initialize() {
        // Do Nothing
    }

    @Override
    public void initialize(final CtxtHandle continueCtx, final SecBufferDesc continueToken,
            final String targetPrincipalName) {
        // Do Nothing
    }

}
