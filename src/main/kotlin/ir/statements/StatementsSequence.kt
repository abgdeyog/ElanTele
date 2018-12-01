package ir.statements

import ir.Context

class StatementsSequence(private val statements: List<Statement>) {

    fun executeAll(context: Context) {
        statements.forEach { it.execute(context) }
    }

}