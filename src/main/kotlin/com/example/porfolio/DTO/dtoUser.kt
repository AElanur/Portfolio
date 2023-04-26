package com.example.porfolio.DTO

class dtoUser {
    var username: String? = null
    var password: String? = null

    constructor(username: String?, password: String?) {
        this.username = username
        this.password = password
    }

    fun check() : Boolean {
        var result = false
        if (username != null && password != null) {
            result = true
        }
        return result
    }
}