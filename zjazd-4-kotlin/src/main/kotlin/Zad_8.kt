package com.pjatk

/**
 * Write a program that simulates the Fizz buzz game. Your task is to print numbers from 1 to 100 incrementally, replacing any number divisible by three with the word
 * "fizz", and any number divisible by five with the word "buzz". Any number divisible by both 3 and 5 must be replaced with the word "fizzbuzz".
 * Hint
 * Use a for loop to count numbers and a when expression to decide what to print at each step.
 */

fun main() {
    for(i in 1..100) {
        println(
            when {
                i % 15 == 0 -> "fizzbuzz"
                i % 3 == 0 -> "fizz"
                i % 5 == 0 -> "buzz"
                else -> i
            }
        )
    }
}