package elanTele.ir.expressions

import elanTele.ir.Context
import elanTele.ir.values.Value

data class ValueExpression(val value: Value) : Expression {
    /**
     * @return value which is inside of Expression
     */
    override fun execute(context: Context): Value = value

}