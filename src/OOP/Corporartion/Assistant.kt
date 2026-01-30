package OOP.Corporartion

class Assistant(
    name: String,
    age: Int
) : Worker(name = name, age = age) {
    fun bringCoffee(brinkName: String = "Cappuccino", count: Int = 1): String {
        repeat(count) {
            println("Get up")
            println("Go to the coffee machine")
            println("Press the \"$brinkName\" button")
            println("Wait for the $brinkName to be prepared")
            println("Take coffee")
            println("Bring coffee to the director")
            println("Put coffee on the table")
            println("Return to the work place")
        }
        return "Espresso"
    }
}


