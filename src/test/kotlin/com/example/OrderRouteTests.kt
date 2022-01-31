import com.example.main
import com.example.plugins.configureRouting
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.testing.*
import io.netty.handler.codec.http.HttpHeaders.addHeader
import org.junit.Test
import kotlin.test.assertEquals

class OrderRouteTests {
    @Test
    fun testGetOrder() {
        withTestApplication({
            configureRouting()
            install(ContentNegotiation) {
                gson()
            }
        }) {
            handleRequest(HttpMethod.Get, "/order/2020-04-06-01") {
                addHeader(
                    HttpHeaders.ContentType,
                    ContentType.Application.Json.toString()
                )
            }.apply {
                assertEquals(
                    """{"number":"2020-04-06-01","contents":[{"item":"Ham Sandwich","amount":2,"price":5.5},{"item":"Water","amount":1,"price":1.5},{"item":"Beer","amount":3,"price":2.3},{"item":"Cheesecake","amount":1,"price":3.75}]}""",
                    response.content
                )
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }
}
