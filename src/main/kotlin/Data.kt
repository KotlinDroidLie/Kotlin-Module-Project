
data class ArchiveContainer(val title: String, val notesList: MutableList<NoteItem> = mutableListOf())

data class NoteItem(val heading: String, val text: String)



