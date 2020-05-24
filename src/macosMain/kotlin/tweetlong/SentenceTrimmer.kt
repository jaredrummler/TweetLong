package tweetlong

class SentenceTrimmer(
    input: String, private val characters: Int = TweetSplitter.DEFAULT_MAX_TWEET_LENGTH
) : StringSplitter(input) {

    override fun split(): List<String> {
        val split = mutableListOf<String>()
        val length = input.length
        val size = characters + 1
        val max = length - 1
        var start = 0
        var n = 1
        while (true) {
            val range = start until ((start + characters).coerceAtMost(max))
            val end = input.substring(range).lastIndexOf(' ').coerceAtMost(max) + start
            val line = (if (n == 1) "" else "…") +
                    input.substring(start until end).trim() +
                    (if (end < max) "…" else "")
            split.add(line)
            start = end
            if (start + size >= length) {
                split.add("…" + input.substring(start).trim())
                break
            }
            n++
        }
        return split.toList()
    }

}