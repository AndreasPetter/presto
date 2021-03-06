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
package com.facebook.presto.sql.gen;

import com.facebook.presto.byteCode.ByteCodeNode;
import com.facebook.presto.metadata.Signature;
import com.facebook.presto.spi.type.Type;
import com.facebook.presto.sql.relational.RowExpression;

import java.util.ArrayList;
import java.util.List;

import static com.facebook.presto.sql.gen.ByteCodeUtils.generateFunctionCall;

public class FunctionCallCodeGenerator
        implements ByteCodeGenerator
{
    @Override
    public ByteCodeNode generateExpression(Signature signature, ByteCodeGeneratorContext context, Type returnType, List<RowExpression> arguments)
    {
        List<ByteCodeNode> argumentsByteCode = new ArrayList<>();
        for (RowExpression argument : arguments) {
            argumentsByteCode.add(context.generate(argument));
        }

        FunctionBinding binding = context.getBootstrapBinder()
                .bindFunction(signature, context.generateGetSession(), argumentsByteCode);

        return generateFunctionCall(signature, context.getContext(), binding, signature.toString());
    }
}
