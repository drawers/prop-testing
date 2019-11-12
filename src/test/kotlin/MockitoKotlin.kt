import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class MockitoKotlin {

    @Mock
    lateinit var mock: MutableList<String>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun mockito() {
        whenever(mock.get(0)).thenReturn("one")
        whenever(mock.get(1)).thenReturn("two")

        someCodeThatInteractsWithMock(mock)

        verify(mock).clear()
    }

    private fun someCodeThatInteractsWithMock(strings: MutableList<String>) {
        strings.clear()
    }
}