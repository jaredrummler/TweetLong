package tweetlong

class SentenceSplitter(input: String) : StringSplitter(input) {

    override fun split(): List<String> = mutableListOf<String>().also { sentences ->
        var sentence = StringBuilder()
        var isLastEndingChar = false
        var isInQuote = false
        for (c in input) {
            if (c.isQuoteChar()) {
                isInQuote = !isInQuote
            }
            if (isLastEndingChar && !isInQuote) {
                if (c.isEndOfSentenceChar()) {
                    sentence.append(c)
                } else if (!c.isWhitespace()) {
                    sentences.add(sentence.toString())
                    sentence = StringBuilder().append(c)
                    isLastEndingChar = false
                }
            } else {
                sentence.append(c)
                isLastEndingChar = c.isEndOfSentenceChar()
            }
        }
        if (sentence.isNotBlank()) {
            sentences.add(sentence.toString())
        }
    }.toList()

    private fun Char.isQuoteChar(): Boolean = when (this) {
        '“', '"', '”' -> true
        else -> false
    }

    private fun Char.isEndOfSentenceChar(): Boolean = when (this) {
        '.', '?', '!' -> true
        else -> false
    }

}