package elanTele.ir.references

import elanTele.ir.Context
import elanTele.ir.exceptions.InvalidTypeException
import elanTele.ir.exceptions.UnresolvedIdentifierException
import elanTele.ir.values.Value
import elanTele.ir.values.classes.TupleValue

data class TupleElementIndexReference(
        val arrayReference: Reference,
        val identifier: Int
) : Reference {

    override fun setValue(context: Context, value: Value) {
        val dict = arrayReference.getValue(context)
        if (dict is TupleValue) {
            dict.setElement(identifier, value)
        } else {
            throw InvalidTypeException("Expected ArrayValue, got ${dict.javaClass.simpleName}")
        }
    }

    override fun getValue(context: Context): Value {
        val dict = arrayReference.getValue(context)
        if (dict is TupleValue) {
            return dict.getElement(identifier)
                    ?: throw UnresolvedIdentifierException("Unresolved identifier: $dict has no $identifier")
        } else {
            throw InvalidTypeException("Expected ArrayValue, got ${dict.javaClass.simpleName}")
        }
    }
}