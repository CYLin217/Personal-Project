package com.example.demo.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("SainSku")
class CacheServiceController {


    @GetMapping("/queryBySainSku/{value}")
    fun getCacheService(@RequestParam("value") value: String): String{
        return value
    }
}