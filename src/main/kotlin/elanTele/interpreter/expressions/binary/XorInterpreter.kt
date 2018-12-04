package elanTele.interpreter.expressions.binary

import elanTele.ir.expressions.BinaryExpression
import elanTele.ir.expressions.Expression
import elanTele.ir.expressions.OperatorType
import elanTele.parser.ElanTeleParser


object XorInterpreter {

    fun getXorExpression(tree: ElanTeleParser.XorContext): Expression =
            tree.xor()?.let {
                BinaryExpression(
                        getXorExpression(tree.xor()),
                        DisjunctionInterpreter.getDisjunctionExpression(tree.disjuntion()),
                        OperatorType.XOR)
            } ?: DisjunctionInterpreter.getDisjunctionExpression(tree.disjuntion())


}