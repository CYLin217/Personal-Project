package com.example.demo.service

import com.example.demo.dto.FinalDataDto
import com.example.demo.dto.outbound.ProductDescriptionDto
import com.example.demo.rest.client.CacheRestClient
import org.springframework.stereotype.Service

@Service
class ProductProcessor(private val cacheRestClient: CacheRestClient) {

    fun process(productDescriptionDto: ProductDescriptionDto){

        var sainID = cacheRestClient.getProductCacheWithSainsburySku(productDescriptionDto.skuID)?.sainId
        var list_data: MutableList<FinalDataDto> = mutableListOf()
    }
}