package com.pjatk

/**
 * You have a list of “green” numbers and a list of “red” numbers. Complete the code to print how many numbers there are in total.
 */

fun main() {
    val greenNumbers = listOf(1, 4, 23)
    val redNumbers = listOf(17, 2)
    println(greenNumbers.count() + redNumbers.count())
}