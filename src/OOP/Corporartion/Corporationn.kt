package OOP.Corporartion

fun main() {

    val accountant = Accountant(
        id = 0, name = "Helen", age = 25,

        )
    accountant.work()
    /* (assistant as Assistant).bringCoffee() // при таком преобразовании as Assistant мы должны быть точно уверены, что assistant это точно Assistant, иначе ошибка
     (director as Director).getConsultantToWork(consultant as Consultant)*/


}