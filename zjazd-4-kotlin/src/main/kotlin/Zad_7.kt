package com.pjatk

/**
 * You have a program that counts pizza slices until there’s a whole pizza with 8 slices. Refactor this program in two ways:
 * Use a while loop.
 * Use a do-while loop.
 */
fun main() {
    versionWithWhile()
    versionWithDoWhile()
}

fun versionWithWhile() {
    var pizzaSlices = 0
    while(++pizzaSlices < 8) {
        println("There's only $pizzaSlices slice/s of pizza :(")
    }
    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
}

fun versionWithDoWhile() {
    var pizzaSlices = 0
    pizzaSlices++
    do {
        println("There's only $pizzaSlices slice/s of pizza :(")
    } while (++pizzaSlices < 8)
    println("There are $pizzaSlices slices of pizza. Hooray! We have a whole pizza! :D")
}