package com.example.demo.service.startup

import com.example.demo.dto.outbound.ProductDescriptionDto
import java.io.InputStream

class readData {
    fun readCsv(inputStram: InputStream): List<ProductDescriptionDto> {
        val reader = inputStram.bufferedReader()
        return reader.lineSequence().filter { it.isNotBlank() }
            .map {
                val (sainWrapper, description) = it.split(',', ignoreCase = false, limit = 3)
                ProductDescriptionDto(sainWrapper.trim(), description.trim())
            }.toList()
    }
}