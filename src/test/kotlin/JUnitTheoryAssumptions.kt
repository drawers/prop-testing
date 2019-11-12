import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assumptions.assumeThat
import org.junit.experimental.theories.DataPoints
import org.junit.experimental.theories.Theories
import org.junit.experimental.theories.Theory
import org.junit.runner.RunWith

@RunWith(Theories::class)
class JUnitTheoryAssumptions {

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
            listOf(
                123, -448, 1224, 88
            ),
            emptyList()
        )
    }

    @Theory
    fun noElementsGreaterThanMyMax(@RandomInts ints: List<Int>) {
        assumeThat(ints).isNotEmpty

        val myMax = ints.myMax()
        ints.forEach {
            assertThat(it).isLessThanOrEqualTo(myMax)
        }
    }

    @Theory
    fun myMaxIsInTheCollection(ints: List<Int>) {
        assumeThat(ints).isNotEmpty

        assertThat(ints).contains(ints.myMax())
    }
}