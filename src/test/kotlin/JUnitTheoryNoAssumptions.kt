import org.assertj.core.api.Assertions.assertThat
import org.junit.experimental.theories.DataPoints
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith

@RunWith(Theories::class)
class JUnitTheoryNoAssumptions {

    companion object {

        @DataPoints
        @JvmField
        val intPoints: List<List<Int>> = listOf(
            listOf(
                1, 2, 3, 4, 5
            ),
            listOf(
                10, 99, 20
            ),
            emptyList()
        )
    }

    @Theory
    fun noElementsGreaterThanMyMax(ints: List<Int>) {
        if (ints.isEmpty()) return

        val myMax = ints.myMax()
        ints.forEach {
            assertThat(it).isLessThanOrEqualTo(myMax)
        }
    }

    @Theory
    fun myMaxIsInTheCollection(ints: List<Int>) {
        if (ints.isEmpty()) return

        assertThat(ints).contains(ints.myMax())
    }
}