import java.util.Scanner

abstract class Menu<T>(protected val elements: List<T>, protected val menuTitle: String) {
    protected val inputReader = Scanner(System.`in`)

    open fun display() {
        while (true) {
            showOptions()
            when (val choice = readMenuSelection()) {
                0 -> if (addNewItem()) continue else break
                in 1..elements.size -> if (pickItem(elements[choice - 1])) continue else break
                elements.size + 1 -> break
                else -> displayError("Некорректный выбор пункта")
            }
        }
    }

    protected open fun showOptions() {
        println(menuTitle)
        println("0. Добавить")
        elements.forEachIndexed { idx, element -> println("${idx + 1}. ${getItemName(element)}") }
        println("${elements.size + 1}. Завершить")
    }

    protected fun readMenuSelection(): Int {
        var selectedOption: Int? = null
        while (selectedOption == null) {
            val inputText = inputReader.nextLine()
            selectedOption = inputText.toIntOrNull()
            if (selectedOption == null) {
                displayError("Пожалуйста, введите номер пункта")
            }
        }
        return selectedOption
    }
    protected fun displayError(errorText: String) {
        println("Ошибка: $errorText")
    }

    abstract fun getItemName(element: T): String
    abstract fun addNewItem(): Boolean
    abstract fun pickItem(element: T): Boolean
}