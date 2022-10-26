package com.example.demo.controllers

import com.example.demo.dto.FinalDataDto
import com.example.demo.rest.client.CacheRestClient
import feign.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("feign")
class FeignClientController{



    @GetMapping("/append-id")
    fun appendID(){

    }




}