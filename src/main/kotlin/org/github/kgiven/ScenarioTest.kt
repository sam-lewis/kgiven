package org.github.kgiven

import io.mockk.MockKGateway
import io.mockk.impl.instantiation.AbstractMockFactory
import io.mockk.mockkStatic
import io.mockk.spyk
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach


abstract class ScenarioTest<T>(testContext: T, val steps: Array<String>) {

    private val given = spyk(Given(testContext))
    private val `when` = spyk(When(testContext))
    private val then = spyk(Then(testContext))


    fun given(): Given<T> {
        return given.given()
    }

    fun `when`(): When<T> {
        return `when`.`when`()
    }

    fun then(): Then<T> {
        return then.then()
    }

    @BeforeEach
    fun before() {
        steps.forEach {
            mockkStatic(it)
        }
    }

    @AfterEach
    fun after() {

        val methodsWithLineBreak = arrayOf("given", "when", "then")

        (MockKGateway.implementation().mockFactory as AbstractMockFactory).gatewayAccess.stubRepository
                .allStubs.flatMap { it.allRecordedCalls() }
                .filter { it.method.name != "getContext" }
                .sortedBy { it.timestamp }
                .map {
                    if (methodsWithLineBreak.contains(it.method.name)) {
                        println()
                    }
                    print(it.method.name)
                    print(" ")
                }
    }


}