package OOP

class Car {
    var brand: String
    var model: String
    var enginePower: Int
    var bodyColor: String

    constructor(brand: String, model: String, enginePower: Int, bodyColor: String){
        this.brand = brand
        this.model = model
        this.enginePower = enginePower
        this.bodyColor = bodyColor
    }

    fun drive() {
       val carName = "$brand $model"
        if (enginePower >= 120){
            println("Еду быстро, но недалеко на $carName")
        } else {
            println("Еду далеко, но небыстро на $carName")
        }
    }

    fun printInfo(){
        println("$brand $model $enginePower л.с. $bodyColor")
    }

    fun refuel(label: String, marck: String, liter: Int ){
        println("Произведена заправка на АЗС \"${label}\"\nМарка бензина: $marck\nКол-во литров: $liter")
    }
}
private fun task1() {
    val input = readln().split(" ")

    val brand = input[0]
    val model = input[1]
    val enginePower = input[2].toInt()
    val bodyColor = input[3]


    val car = Car(brand, model, enginePower, bodyColor)
    car.printInfo()
}

fun main(){
    task1()
}
