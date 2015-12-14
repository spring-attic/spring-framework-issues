/* ***************************************************************************
 * Copyright 2015 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * **************************************************************************/
package com.repro;

@SuppressWarnings("serial")
public class SystemException extends RuntimeException {
    public SystemException(Throwable t) {
        super(t);
    }
}
