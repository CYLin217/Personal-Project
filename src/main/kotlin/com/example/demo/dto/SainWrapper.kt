package com.example.demo.dto

data class SainWrapper(
    val sain: String,
    val identifiers: Set<Identifier>,
)

data class Identifier(
    val alias: String,
    val value: Set<String>,
)