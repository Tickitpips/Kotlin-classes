package com.example.classesinkotlin

//Store functions in a variable
fun main() {
    val trickFunction = trick
    trick()          //Calling the trick function
    trickFunction()
}


val trick = {              //Defines a lambda function (a function in a variable)
        println("No treats!")
    }


    fun trickOrTreat(isTrick: Boolean): () -> Unit {
        if (isTrick) {
            return trick
        } else {
            return treat
        }
    }

    val trick2 = {
        println("No treats!")
    }

    val treat = {
        println("Have a treat!")
    }

fun main32(){
    fun main() {
        val treatFunction = trickOrTreat(false)
        val trickFunction = trickOrTreat(true)
    }
}