package org.github.kgiven

import io.mockk.MockKGateway
import io.mockk.impl.instantiation.AbstractMockFactory
import io.mockk.mockkStatic
import io.mockk.spyk
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach


abstract class ScenarioTest<T>(testContext: T) {

    private val given = spyk(Given(testContext))
    private val `when` = spyk(When(testContext))
    private val then = spyk(Then(testContext))


    fun given(): Given<T> {
        return given
    }

    fun `when`(): When<T> {
        return `when`
    }

    fun then(): Then<T> {
        return then
    }

    @BeforeEach
    fun before() {
        mockkStatic("org.github.kgiven.fruit.GivenFruitKt", "org.github.kgiven.fruit.ThenFruitKt")
    }

    @AfterEach
    fun after() {


        (MockKGateway.implementation().mockFactory as AbstractMockFactory).gatewayAccess.stubRepository
                .allStubs.flatMap { it.allRecordedCalls() }
                .filter { !(it.method.name == "getContext") }
                .sortedBy { it.timestamp }
                .map {
                    println(it.timestamp)
                    println(it.method.name)
                }


    }


}