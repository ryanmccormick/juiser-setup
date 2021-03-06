/*
 * Copyright (C) 2017 Stormpath, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.juiser.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.lang.Strings;

import java.util.function.Function;

/**
 * @since 0.1.0
 */
public class StringClaimResolver extends ClaimValueResolver<String> {

    public StringClaimResolver(Function<Claims, ?> delegate) {
        this(delegate, true);
    }

    public StringClaimResolver(Function<Claims, ?> delegate, boolean resultRequired) {
        super(delegate, resultRequired);
    }

    @Override
    protected String toTypedValue(Object v, Claims claims) {

        String value = String.valueOf(v);

        if (!Strings.hasText(value) || "null".equalsIgnoreCase(value)) {
            illegal(claims);
        }

        return value;
    }
}
