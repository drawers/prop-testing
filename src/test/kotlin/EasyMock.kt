import org.easymock.EasyMock.*
import org.easymock.EasyMockSupport
import org.easymock.Mock
import org.junit.Before
import org.junit.Test

class EasyMock {

    @Mock
    lateinit var mock: MutableList<String>

    @Before
    fun setUp() {
        EasyMockSupport.injectMocks(this)
    }

    @Test
    fun easyMock() {
        expect(mock.get(0)).andStubReturn("one")
        expect(mock.get(1)).andStubReturn("two")

        replay(mock)

        someCodeThatInteractsWithMock(mock)

        verify(mock)
    }

    private fun someCodeThatInteractsWithMock(strings: MutableList<String>) {
        strings.clear()
    }
}