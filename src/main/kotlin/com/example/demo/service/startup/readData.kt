package com.example.demo.service.startup

import com.example.demo.dto.PersonalProjectDto
import java.io.InputStream
import java.nio.file.Paths

class readData {
    fun readCsv(inputStram: InputStream): List<PersonalProjectDto> {
        val reader = inputStram.bufferedReader()
        return reader.lineSequence().filter { it.isNotBlank() }
            .map {
                val (sainWrapper, description) = it.split(',', ignoreCase = false, limit = 3)
                PersonalProjectDto(sainWrapper.trim(), description.trim())
            }.toList()
    }
}