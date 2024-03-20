package com.example.imad_a1

//checkAge fun verifies age range and matches with age in list
fun checkAge(age: Int, listOfCeleb: List<NameAge>): RenameMsg {
    if (age in 20..100) {
        val match = listOfCeleb.find { it.age == age }
        if (match == null){
            //if age is in range but not on list, return age not on list error
            return RenameMsg(true, null, 404)
        }else {
            //if age is in range and found on list, return matching celeb details
            return RenameMsg(true, match, 200)
        }
    }else{
        //if age is out of range return error
        return RenameMsg(false, null, 400)
    }
}