package org.github.kgiven.fruit

import org.github.kgiven.Then

fun Then<FruitTestContext>.`has a core`(): Then<FruitTestContext> {

    assert(context.fruit!!.hasCore())

    return this
}

