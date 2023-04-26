package com.example.porfolio.controller

import com.example.porfolio.DTO.dtoUser
import db.Database
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class MainController {
    @GetMapping("")
    fun index(): String {
        return "index"
    }

    @PostMapping("/auth")
    fun getInfo(@RequestBody user: dtoUser): ResponseEntity<String> {
        var result = "false"
        println(user.password)
        if (user.check()) {
            val db = Database()
            val rs = db.auth(user.username!!, user.password!!)
            if (rs?.next()!!) {
                result = "true"
            }
        }
        return ResponseEntity(result, HttpStatus.OK)
    }
}