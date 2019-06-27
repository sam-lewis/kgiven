package org.github.kgiven

abstract class Stage<out T, out S>(context: T) {

    val context = context


    abstract fun self(): S
}