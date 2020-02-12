import io.kotlintest.specs.StringSpec
import junit.framework.Assert.assertEquals
import org.junit.Test

class ValueBased : StringSpec() {

    init {
        "test largest value" {
            val ints = listOf(4, 8, 7)

            assertEquals(8, ints.myMax())
        }

        "test largest value reverse" {
            val ints = listOf(7, 8, 4)

            assertEquals(8, ints.myMax())
        }

        "test empty" {
            val ints = emptyList<Int>()

            assertEquals(null, ints.myMax())
        }
    }
}