package org.github.kgiven

class When<T>(context: T) : Stage<T, When<T>>(context) {

    fun `when`(): When<T> {
        return this
    }
}