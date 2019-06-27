package org.github.kgiven

open class Given<T>(context: T) : Stage<T, Given<T>>(context) {

    override fun self(): Given<T> {
        return this
    }

    fun an(): Given<T> {
        return this
    }
}