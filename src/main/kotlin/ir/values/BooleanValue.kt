package ir.values

class BooleanValue(val value: Boolean) : Value(ValueClass.BOOLEAN){
    override fun and(other: Value): Value = when(other){
        is BooleanValue -> BooleanValue(value and other.value)
        else -> super.and(other)
    }

    override fun or(other: Value): Value = when(other){
        is BooleanValue -> BooleanValue(value or other.value)
        else -> super.or(other)
    }
    override fun xor(other: Value): Value = when(other){
        is BooleanValue -> BooleanValue(value xor other.value)
        else -> super.xor(other)
    }

    override fun toString(): String = value.toString()
}
