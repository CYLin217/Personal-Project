package com.example.demo.logging

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface Logging

fun <T : Logging> T.logger(): Logger = getLogger(javaClass)

fun getLogger(forClass: Class<*>): Logger = LoggerFactory.getLogger(forClass)