package com.example.demo.dto


data class ProductCache(

    val sainId : String,
    val sainWrapper: SainWrapper,
    var barcodes: List<Barcode>?
)

data class Barcode(
    val type : String,
    val value :String
)