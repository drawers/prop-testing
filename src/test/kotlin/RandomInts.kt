import org.junit.experimental.theories.ParameterSignature
import org.junit.experimental.theories.ParameterSupplier
import org.junit.experimental.theories.ParametersSuppliedBy
import org.junit.experimental.theories.PotentialAssignment
import kotlin.random.Random

@Retention(AnnotationRetention.RUNTIME)
@ParametersSuppliedBy(RandomIntSupplier::class)
annotation class RandomInts(val iterations: Int = 50, val seed: Int = 0)

class RandomIntSupplier : ParameterSupplier() {
    override fun getValueSources(sig: ParameterSignature?): MutableList<PotentialAssignment> {
        val annotation = requireNotNull(sig).getAnnotation(RandomInts::class.java)
        val rng = Random(annotation.seed)

        return generateSequence { randomInts(rng) }
            .take(annotation.iterations)
            .map {
                PotentialAssignment.forValue("ints", it)
            }
            .toMutableList()
    }

    private fun randomInts(rng: Random) =
        generateSequence { rng.nextInt() }.takeWhile { rng.nextDouble() < 0.9 }.toList()
}