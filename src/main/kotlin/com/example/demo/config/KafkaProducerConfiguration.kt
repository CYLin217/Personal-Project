package com.example.demo.config

import com.example.demo.dto.outbound.ProductDescriptionDto
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.kafka.support.serializer.JsonSerializer


@Configuration
class KafkaProducerConfiguration(private val kafkaProperties: KafkaProperties ) {

    @Bean
    fun producerFactory(): ProducerFactory<String, ProductDescriptionDto> {

        var config = HashMap<String, Any>()

        config[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = "127.0.0.1:9092"
        config[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
        config[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = JsonSerializer::class.java

        return DefaultKafkaProducerFactory(config)
    }

    @Bean("kafkaTemplate")
    fun kafkaTemplate(): KafkaTemplate<String, ProductDescriptionDto> {
        return KafkaTemplate(producerFactory())
    }






}