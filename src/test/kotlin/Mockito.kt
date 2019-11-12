import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class Mockito {

    @Mock
    lateinit var mock: MutableList<String>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun mockito() {
        `when`(mock.get(0)).thenReturn("one")
        `when`(mock.get(1)).thenReturn("two")

        someCodeThatInteractsWithMock(mock)

        verify(mock).clear()
    }

    private fun someCodeThatInteractsWithMock(strings: MutableList<String>) {
        strings.clear()
    }
}