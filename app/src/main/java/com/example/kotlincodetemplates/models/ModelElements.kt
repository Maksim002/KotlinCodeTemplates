package com.example.kotlincodetemplates.models

class ModelElements(
    var code: String? = null,
    var xml: String? = null
){
    override fun toString(): String {
        return code.toString()
    }
}