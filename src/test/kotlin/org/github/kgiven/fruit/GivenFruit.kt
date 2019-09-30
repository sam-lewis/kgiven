package org.github.kgiven.fruit

import org.github.kgiven.Given
import org.github.kgiven.fruit.fruit.Apple

fun Given<FruitTestContext>.apple(): Given<FruitTestContext> {
    context.fruit = Apple()
    return this
}


