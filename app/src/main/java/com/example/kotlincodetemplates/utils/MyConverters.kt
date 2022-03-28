package com.example.kotlincodetemplates.utils

object MyConverters {

    fun deletingCharacters(string: String): String {
        val con1 = string.replace("\\n", "\n")
        val con2 = con1.replace("\"", "")
        return con2.replace("\\", "\"")
    }
}