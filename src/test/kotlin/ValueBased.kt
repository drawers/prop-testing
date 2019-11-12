import junit.framework.Assert.assertEquals
import org.junit.Test

class ValueBased {

    @Test
    fun testLargestValue() {
        val ints = listOf(4, 8, 7)

        assertEquals(8, ints.myMax())
    }

    @Test
    fun testLastValueReverse() {
        val ints = listOf(7, 8, 4)

        assertEquals(8, ints.myMax())
    }

    @Test
    fun testEmpty() {
        val ints = emptyList<Int>()

        assertEquals(null, ints.myMax())
    }
}