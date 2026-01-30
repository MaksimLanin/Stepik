package OOP

import kotlin.random.Random

class Monster(
    val pawsCount: Int,
    val eyesCount: Int,
    val fangsCount: Int,
    val clawsCount: Int,
    val tentaclesCount: Int
) {

    constructor(number: Int) : this(number, number, number, number, number)

    constructor() : this(
        Random.nextInt(1, 10),
        Random.nextInt(1, 10),
        Random.nextInt(1, 10),
        Random.nextInt(1, 10),
        Random.nextInt(1, 10)
    )

    fun printInfo(){
        println("Кол-во лап: $pawsCount\nКол-во глаз: $eyesCount\nКол-во клыков: $fangsCount\nКол-во когтей: $clawsCount\nКол-во щупалец: $tentaclesCount")
    }
}

 fun task2(){
    val input = readln().split(" ")
    val paws = input[0].toInt()
    val eyes = input[1].toInt()
    val fangs = input[2].toInt()
    val claws = input[3].toInt()
    val tentacles = input[4].toInt()

    val monster = Monster(paws, eyes, fangs, claws, tentacles)
    monster.printInfo()
}

fun main() {
    task2()
}