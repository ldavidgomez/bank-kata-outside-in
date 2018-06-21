package com.bankkata

import java.lang.UnsupportedOperationException

open class Console {
    fun println(text: String) {
        throw UnsupportedOperationException()
    }
}