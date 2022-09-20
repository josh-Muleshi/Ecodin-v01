package com.joshMuleshi.ecodim.data.model

import java.util.*

data class Admin(
    val uid: String = "",
    val matricule: String = "",
    val full_name: String = "",
    val email: String = "",
    val passWord: String = "",
    val createdAt: Date? = null
)
