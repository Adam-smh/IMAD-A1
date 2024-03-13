package com.example.imad_a1

fun checkAge(age: Int, listOfCeleb: List<NameAge>): RenameMsg {
    if (age in 20..100) {
        val match = listOfCeleb.find { it.age == age }
        if (match == null){
            return RenameMsg(true, null, 404)
        }else {
            return RenameMsg(true, match, 200)
        }
    }else{
        return RenameMsg(false, null, 400)
    }
}