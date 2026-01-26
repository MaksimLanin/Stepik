package OOP.Corporartion

class Assistant(
    val name: String
) {
    fun bringCoffee(brinkName: String = "Cappuccino", count: Int = 1): String{
        repeat(count){
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

class Director(
    val name: String,
    val age: Int
) {
    fun takeCoffee(assistant: Assistant) {
        val brinkName: String = assistant.bringCoffee()
        println("Thank you ${assistant.name}! The $brinkName is so tasty")
    }
}

fun main(){
    val director = Director("Maksim", 25)
    val assistant = Assistant("Helen")

    director.takeCoffee(assistant)
}