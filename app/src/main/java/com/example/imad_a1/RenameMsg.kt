package com.example.imad_a1

//response model
data class RenameMsg(
    val valid: Boolean,
    val nameAge: NameAge?,
    val status: Int
)