package org.github.kgiven.fruit

import org.github.kgiven.ScenarioTest
import org.junit.jupiter.api.Test

class MyTest : ScenarioTest<FruitTestContext>(FruitTestContext()) {

    @Test
    fun `apples have a core`() {
        given().an().apple()

        then().it().`has a core`()
    }
}