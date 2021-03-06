/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.operator.aggregation;

import static com.facebook.presto.operator.aggregation.AggregationUtils.createIsolatedApproximateAggregation;
import static com.facebook.presto.spi.type.BigintType.BIGINT;
import static com.facebook.presto.spi.type.BooleanType.BOOLEAN;
import static com.facebook.presto.spi.type.DoubleType.DOUBLE;
import static com.facebook.presto.spi.type.VarcharType.VARCHAR;

public final class ApproximateCountColumnAggregations
{
    public static final AggregationFunction BOOLEAN_APPROXIMATE_COUNT_AGGREGATION = createIsolatedApproximateAggregation(ApproximateCountColumnAggregation.class, BOOLEAN);
    public static final AggregationFunction LONG_APPROXIMATE_COUNT_AGGREGATION = createIsolatedApproximateAggregation(ApproximateCountColumnAggregation.class, BIGINT);
    public static final AggregationFunction DOUBLE_APPROXIMATE_COUNT_AGGREGATION = createIsolatedApproximateAggregation(ApproximateCountColumnAggregation.class, DOUBLE);
    public static final AggregationFunction VARBINARY_APPROXIMATE_COUNT_AGGREGATION = createIsolatedApproximateAggregation(ApproximateCountColumnAggregation.class, VARCHAR);

    private ApproximateCountColumnAggregations() {}
}
