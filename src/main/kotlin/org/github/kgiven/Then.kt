package org.github.kgiven

class Then<T>(context: T) : Stage<T, Then<T>>(context) {

    override fun self(): Then<T> {
        return this
    }

    fun it(): Then<T> {
        return this
    }
}
