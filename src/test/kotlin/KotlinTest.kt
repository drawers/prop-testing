import io.kotlintest.matchers.beGreaterThan
import io.kotlintest.matchers.collections.shouldContain
import io.kotlintest.properties.assertAll
import io.kotlintest.shouldBe
import io.kotlintest.shouldNot
import io.kotlintest.specs.StringSpec

class KotlinTest : StringSpec() {

    init {
        "no elements greater than myMax" {
            assertAll { ints: List<Int> ->
                val myMax = ints.myMax() ?: return@assertAll

                ints.forEach {
                    it shouldNot beGreaterThan(myMax)
                }
            }
        }







        "myMax is in the collection" {
            assertAll { ints: List<Int> ->
                val myMax = ints.myMax() ?: return@assertAll

                ints shouldContain myMax
            }
        }





        "empty is null" {
            assertAll { ints: List<Int> ->
                if (ints.isNotEmpty()) return@assertAll

                ints.myMax() shouldBe null
            }
        }
    }
}