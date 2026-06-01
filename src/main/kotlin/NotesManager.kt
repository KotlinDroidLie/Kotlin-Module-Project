class NotesManager(private val notesCollection: MutableList<NoteItem>) : Menu<NoteItem>(notesCollection, "Список записей:") {
    override fun getItemName(element: NoteItem) = element.heading

    override fun addNewItem(): Boolean {
        print("Введите заголовок записи: ")
        val heading = inputReader.nextLine().trim()
        if (heading.isBlank()) {
            displayError("Заголовок обязателен для заполнения")
            return true
        }

        print("Введите текст записи: ")
        val text = inputReader.nextLine().trim()
        if (text.isBlank()) {
            displayError("Текст записи не может быть пустым")
            return true
        }

        notesCollection.add(NoteItem(heading, text))
        println("Запись '$heading' успешно добавлена")
        return true
    }

    override fun pickItem(element: NoteItem): Boolean {
        println("\n--- ${element.heading} ---")
        println(element.text)
        println("\nДля продолжения нажмите Enter")
        inputReader.nextLine()
        return true
    }
}