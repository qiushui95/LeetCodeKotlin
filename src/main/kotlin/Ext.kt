inline fun <reified T> assertEquals(from: T, to: T) {
    if (from != to) {
        throw RuntimeException("$from != $to")
    }
}