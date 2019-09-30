package org.github.kgiven

class Then<T>(context: T) : Stage<T, Then<T>>(context) {

    fun then(): Then<T> {
        return this
    }

    fun it(): Then<T> {
        return this
    }
}
