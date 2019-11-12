import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assumptions.assumeThat
import org.junit.experimental.theories.*
import org.junit.runner.RunWith


@RunWith(Theories::class)
class JUnitTheoryDataPoints {

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
    fun noElementsGreaterThanMyMax(
        ints: List<Int>
    ) {
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

    @Retention(AnnotationRetention.RUNTIME)
    @ParametersSuppliedBy(BetweenSupplier::class)
    annotation class Between(val first: Int, val last: Int)

    class BetweenSupplier : ParameterSupplier() {

        override fun getValueSources(sig: ParameterSignature?): MutableList<PotentialAssignment> {
            requireNotNull(sig)
            val annotation = sig.getAnnotation(Between::class.java)

            return (annotation.first..annotation.last)
                .map {
                    PotentialAssignment.forValue(it.toString(), it)
                }.toMutableList()
        }
    }
}