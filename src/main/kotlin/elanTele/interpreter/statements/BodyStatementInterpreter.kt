package elanTele.interpreter.statements

import elanTele.ir.statements.Statement
import elanTele.ir.statements.StatementsSequence
import elanTele.parser.ElanTeleParser
import org.antlr.v4.runtime.tree.ParseTree

object BodyStatementInterpreter {

    fun getBody(tree: ParseTree): StatementsSequence {
        if (tree is ElanTeleParser.BodyContext) {
            val statements = ArrayList<Statement>()
            for (st in tree.statement()) {
                statements.add(StatementInterpreter.getStatement(st))
            }
            return StatementsSequence(statements)
        } else {
            throw ClassCastException("Exception in Statement Sequence in ${tree.payload}")
        }

    }


}