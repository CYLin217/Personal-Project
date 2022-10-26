package com.example.demo

import com.example.demo.service.startup.readData
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import java.io.File

@SpringBootApplication
@EnableFeignClients
class KafkaPersonalProjectApplication

fun main(args: Array<String>) {
//	val file = File("src/main/resources/data.csv")
//	readData().readCsv(file.inputStream())
	runApplication<KafkaPersonalProjectApplication>(*args)
}
