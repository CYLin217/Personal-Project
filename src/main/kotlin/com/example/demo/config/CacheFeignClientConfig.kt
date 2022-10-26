package com.example.demo.config

import com.fasterxml.jackson.databind.ObjectMapper
import feign.codec.Decoder
import feign.Retryer
import feign.jackson.JacksonDecoder
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableFeignClients
class CacheFeignClientConfig {
    @Bean
    fun feignDecoder(objectMapper: ObjectMapper): Decoder {
        return JacksonDecoder(objectMapper)
    }

    @Bean
    fun retryer(): Retryer {
        return Retryer.Default()
    }
}