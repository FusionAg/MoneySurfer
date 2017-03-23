@file:Suppress("IllegalIdentifier")

package pro.agfusion.moneysurfer.test

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class StubTest {

    @Test
    fun `stub test for check environment`() {
        assertThat(true, equalTo(true))
    }
}