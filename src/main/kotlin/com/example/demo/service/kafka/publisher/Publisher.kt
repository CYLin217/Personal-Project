package com.example.demo.service.kafka.publisher

import com.example.demo.dto.outbound.ProductDescriptionDto
import com.example.demo.service.startup.readData
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File

@RestController
@RequestMapping("kafka")
class Publisher(@Autowired private val kafkaTemplate: KafkaTemplate<String, ProductDescriptionDto>) {

    val topic: String = "quickstart-events"
    val data: List<ProductDescriptionDto> = readData().readCsv(File("src/main/resources/data.csv").inputStream())

    @GetMapping("/publish")
    fun post(): String {
        for (item in data) kafkaTemplate.send(topic, item.skuID, item)
        return "Published successfully"
    }
}