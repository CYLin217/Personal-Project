package com.example.demo.service.kafka.consumer

import com.example.demo.dto.outbound.ProductDescriptionDto
import com.example.demo.service.ProductProcessor
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class Listener(private val productProcessor: ProductProcessor) {

    @KafkaListener(topics = ["quickstart-events"], groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
    fun consume(productDescriptionDto: ProductDescriptionDto) {
        try{
            productProcessor.process(productDescriptionDto)
        } catch (error: Exception) {
            throw error
        }
    }
}