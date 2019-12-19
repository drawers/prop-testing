import io.kotlintest.matchers.collections.shouldContain
import io.kotlintest.matchers.numerics.shouldNotBeGreaterThan
import io.kotlintest.properties.Gen
import io.kotlintest.properties.assertAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class KotlinTestAssumptions : StringSpec() {

    init {
        "no elements greater than myMax" {
            assertAll(nonEmptyIntList()) { ints: List<Int> ->
                val myMax = ints.myMax()!!

                ints.forEach {
                    it shouldNotBeGreaterThan myMax
                }
            }
        }

        "myMax is in the collection" {
            assertAll(nonEmptyIntList()) { /*a property */ ints: List<Int> ->
                val myMax = ints.myMax()!!

                ints shouldContain myMax
            }
        }

        "empty is null" {
            assertAll(emptyIntList()) { ints: List<Int> ->
                ints.myMax() shouldBe null
            }
        }
    }

    private fun nonEmptyIntList() = Gen.list(Gen.int()).filterNot { it.isEmpty() }

    private fun emptyIntList() = Gen.list(Gen.int()).filter { it.isEmpty() }
}