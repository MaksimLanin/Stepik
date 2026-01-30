package OOP.Corporartion

fun main() {

    val director  = Director("Sergey", 25) // Upcast Downcast Smartcast
    val consultant  = Consultant("Jora")
    val assistant = Assistant("Helen", 18)
    val accountant = Accountant(name = "Helen", age = 25)
   /* (assistant as Assistant).bringCoffee() // при таком преобразовании as Assistant мы должны быть точно уверены, что assistant это точно Assistant, иначе ошибка
    (director as Director).getConsultantToWork(consultant as Consultant)*/
    director.takeCoffee(assistant) // Зелененькое, Smart cast, он видит что мы привели director к Director, и срабатывает умное приведение типов

    val employees = listOf<Worker>(director, consultant, accountant, )

    for (i in employees){
        i.work()// ТК мы положили все элементы в одну коллекцию, произошел Upcast теперь мы имеем доступ только к полям и методам Родительского класса!!!
    }
}