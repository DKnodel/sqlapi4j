/**
 * Copyright 2013 freiheit.com technologies gmbh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.freiheit.sqlapi.dao;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import com.freiheit.sqlapi.query.SqlResultRow;


/**
 * Transforms a SELECT result row into a Java object of type T.
 *
 * @param <T> the type of the resulting Java object
 *
 * @author Carsten Luckmann (carsten.luckmann@freiheit.com)
 */
@ParametersAreNonnullByDefault
public interface ResultTransformer<T> {

    /**
     * Transform the result row into a Java object of type T.
     */
    @Nonnull
    T apply(SqlResultRow row);

}