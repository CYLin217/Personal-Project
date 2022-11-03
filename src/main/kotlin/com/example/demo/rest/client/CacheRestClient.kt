package com.example.demo.rest.client

import com.example.demo.config.CacheFeignClientConfig
import com.example.demo.dto.FinalDataDto
import com.example.demo.dto.ProductCache
import feign.Response
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "demoClient",
    url = "https://product-data-cache-service-dev.service.eu-west-1.dev.deveng.systems",
    decode404 = true,
    configuration = [CacheFeignClientConfig::class])
interface CacheRestClient {

    @GetMapping(value = ["/v1/api/cache/queryBySainSku/{sainsburysSku}"])
    fun getProductCacheWithSainsburySku(@RequestParam("sainsburysSku") sainsburysSku: String): ProductCache?

}