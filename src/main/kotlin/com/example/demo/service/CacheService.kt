package com.example.demo.service

import com.example.demo.dto.FinalDataDto
import com.example.demo.dto.ProductCache
import com.example.demo.rest.client.CacheRestClient
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable

@Service
class CacheService(val cacheRestClient: CacheRestClient){

    var list_data: MutableList<FinalDataDto> = mutableListOf()

    fun appendID(sku: String): ProductCache?{
        return cacheRestClient.getProductCacheWithSainsburySku(sku)
    }




}