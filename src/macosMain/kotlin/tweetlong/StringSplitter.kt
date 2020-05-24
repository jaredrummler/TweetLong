package tweetlong

abstract class StringSplitter(protected val input: String) {

    abstract fun split(): List<String>

}