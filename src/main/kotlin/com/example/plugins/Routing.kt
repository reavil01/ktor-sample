package com.example.plugins

import com.example.routes.registerOrderRoutes
import customerRouting
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {
    routing {
        customerRouting()
        registerOrderRoutes()
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
