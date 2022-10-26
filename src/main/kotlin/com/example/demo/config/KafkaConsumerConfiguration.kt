package com.example.demo.config

import com.example.demo.dto.PersonalProjectDto
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer
import org.springframework.kafka.support.serializer.JsonDeserializer
import org.springframework.kafka.support.serializer.JsonSerializer

@EnableKafka
@Configuration
class KafkaConsumerConfiguration {

    @Bean
    fun consumerFactory(): ConsumerFactory<String, String?> {

        var config = HashMap<String, Any>()

        config[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = "127.0.0.1:9092"
        config[ConsumerConfig.GROUP_ID_CONFIG] = "group_id"
        config[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        config[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = JsonDeserializer::class.java
        config[JsonSerializer.TYPE_MAPPINGS] =  "personalProjectDto:com.example.demo.dto.PersonalProjectDto"
        config[JsonDeserializer.VALUE_DEFAULT_TYPE] =  "com.example.demo.dto.PersonalProjectDto"
        config[ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS] = StringDeserializer::class.java
        config[ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS] = JsonDeserializer::class.java

        return DefaultKafkaConsumerFactory<String, String?>(config, StringDeserializer(), JsonDeserializer())
    }

    @Bean
    fun kafkaListenerContainerFactory(): ConcurrentKafkaListenerContainerFactory<String, String?> {

        var factory = ConcurrentKafkaListenerContainerFactory<String, String?>()
        factory.consumerFactory = consumerFactory()
        return factory
    }
}