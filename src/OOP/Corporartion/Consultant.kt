package OOP.Corporartion

import kotlin.random.Random

class Consultant(
    name: String,
    age: Int = 0
): Worker(name = name, age = age){
    fun serveCustomers(): Int{
        val count = Random.nextInt(0, 100)
        repeat(count){
            println("The customer is sereved...")
        }
        println()
        return count
    }

    fun sayHello(){
        println("Hello! My name is $name")
        if (age > 0){
            println("im $age years old. \n")
        }
    }
}