package OOP.Corporartion

class Director(
    name: String,
    age: Int
) : Worker(name = name, age = age){
    fun takeCoffee(assistant: Assistant) {
        val drinkName: String = assistant.bringCoffee()
        println("Thank you ${assistant.name}! The $drinkName is so tasty")
    }

    fun getConsultantToWork(consultant: Consultant){
        val count = consultant.serveCustomers()
        println("Consultant ${consultant.name} served $count clients")
    }

    override fun work(){ // Переопределение метода work класса Worker тут мы просто меняем поведение метода, для расширения его функционала ключевым словом override,
        // Соотв, родительский метод мы должны сделать open
        println("Im drink coffee...")
    }
}