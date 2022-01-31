package com.example

import com.example.plugins.*
import com.example.routes.registerOrderRoutes
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureRouting()
        install(ContentNegotiation) {
            gson {
                setPrettyPrinting()
                disableHtmlEscaping()
            }
        }
    }.start(wait = true)
}
//
//fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)
//
//fun Application.module(testing: Boolean = false) {
//    routing {
//        get("/") {
//            call.respondText("Hello, world!")
//        }
//    }
//}