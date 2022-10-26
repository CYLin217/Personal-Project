package com.example.demo.service.kafka.consumer

import com.example.demo.dto.PersonalProjectDto
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class Listener() {

    @KafkaListener(topics = ["quickstart-events"], groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
    fun consume(item: PersonalProjectDto) {
        try{
            println(item.toString())
        } catch (error: Exception) {
            throw error
        }
    }
}