fun addBook(books: MutableList<Book>, bookTitle: String, bookAuthor: String, bookRating: Double) {
    val book = Book().apply {
        title = bookTitle
        author = bookAuthor
        rating = bookRating
    }
    books.add(book)
}

fun printCatalog(books: MutableList<Book>) {
    books.run {
        //println(this)
        println()
        println("Каталог книг:")
        for (book in this) {
            println("${book.author}, ${book.title}, рейтинг: ${book.rating}")
        }
    }
}

fun printAverageRating(books: MutableList<Book>) {
    val averageRating = with(books) {
        var sum = 0.0
        for (book in this) {
            sum += book.rating
        }
        sum / size
    }
    println()
    println("Средний рейтинг: ${String.format("%.2f", averageRating)}")
}

fun filterByLetter(books: MutableList<Book>, letter: String) {
    val filteredBooks = books.filter { it.title.contains(letter) }
    //println("$filteredBooks")
    println()
    println("Книги с буквой '$letter':")
    for (book in filteredBooks) {
        println("${book.author}, ${book.title}, рейтинг: ${book.rating}")
    }
}

fun findBook(books: MutableList<Book>, bookTitle: String) {
    println()
    println("Поиск $bookTitle")
    val foundBook = books.find { it.title == bookTitle }
    //println("$foundBook")
    if (foundBook != null) {
        println("Найдено: ${foundBook.author}, ${foundBook.title}, рейтинг: ${foundBook.rating}")
    } else {
        println("Книга не найдена")
    }
}

fun removeBook(books: MutableList<Book>, bookTitle: String) {
    val bookToRemove = books.find { it.title == bookTitle }
    bookToRemove?.let {
        books.remove(it)
        println()
        println("Удалили книгу: ${it.title}")
    }
}

fun main() {
    val books = mutableListOf<Book>()

    addBook(books, "Мастер и Маргарита", "Булгаков Михаил Афанасьевич", 4.9)
    addBook(books, "Преступление и наказание", "Достоевский Фёдор Михайлович", 4.7)
    addBook(books, "Евгений Онегин", "Пушкин Александр Сергеевич", 4.8)
    addBook(books, "Мёртвые души", "Гоголь Николай Васильевич", 4.5)
    addBook(books, "Война и мир", "Толстой Лев Николаевич", 4.6)

    printCatalog(books)
    printAverageRating(books)
    filterByLetter(books, "й")
    findBook(books, "Вий")
    findBook(books, "Евгений Онегин")
    removeBook(books, "Евгений Онегин")
    printCatalog(books)
    printAverageRating(books)
}
