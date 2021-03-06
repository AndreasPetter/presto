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
package com.facebook.presto.block.uncompressed;

import com.facebook.presto.block.AbstractTestBlock;
import com.facebook.presto.spi.block.Block;
import org.testng.annotations.Test;

import java.util.SortedMap;

import static org.testng.Assert.assertTrue;

public abstract class AbstractTestSingleColumnBlockWithNulls
        extends AbstractTestBlock
{
    @Test
    public void testNullValues()
    {
        Block block = createTestBlock();

        SortedMap<Integer, Object> expectedValues = getExpectedValues();
        for (int position = 0; position < block.getPositionCount(); position++) {
            assertPositionEquals(block, position, expectedValues.get(position));
            if (position % 2 == 0) {
                assertTrue(block.isNull(position));
                assertTrue(block.getObjectValue(SESSION, position) == null);
            }
        }
    }
}
