package org.github.kgiven

class When<T>(context: T) : Stage<T, When<T>>(context) {

    override fun self(): When<T> {
        return this
    }
}