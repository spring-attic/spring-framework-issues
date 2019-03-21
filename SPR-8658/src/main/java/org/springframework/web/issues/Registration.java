/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.web.issues;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
public class Registration implements Serializable {

    @NotEmpty(message = "{NotEmpty.abnYn}")
    private String abnYn;
    private String abn;

    public String getAbnYn() {
        return abnYn;
    }

    public void setAbnYn(String abnYn) {
        this.abnYn = abnYn;
    }

    public String getAbn() {
        return abn;
    }

    public void setAbn(String abn) {
        this.abn = abn;
    }

}