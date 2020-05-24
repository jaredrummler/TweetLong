package tweetlong

class TweetSplitter(input: String) : StringSplitter(input) {

    var tweetLength = 280
    var paragraphSeperator = "\n\n"
    var sentenceSeperator = " "

    override fun split(): List<String> {
        val tweets = mutableListOf<String>()
        val paragraphs = ParagraphSplitter(input).split()
        var tweet = StringBuilder()
        var pSep = ""
        for (p in paragraphs) {
            var sSep = ""
            val sentences = SentenceSplitter(p).split()
            sentences.forEach { sentence ->
                val curTweetLength = tweet.length
                val sentenceLength = sentence.length
                val newLength = curTweetLength + sentenceLength

                if (newLength > tweetLength) {
                    tweets.add(tweet.trim().toString())
                    if (sentence.length >= tweetLength) {
                        val strings = SentenceTrimmer(sentence, tweetLength).split()
                        for (i in 0 until (strings.size - 1)) {
                            tweets.add(strings[i])
                        }
                        tweet = StringBuilder().append(strings.last())
                        return@forEach
                    } else {
                        tweet = StringBuilder()
                    }
                }
                if (curTweetLength > 0) {
                    tweet.append(sSep) // TODO: account for separator lengths in tweet
                }
                tweet.append(sentence)
                sSep = sentenceSeperator
            }

            if (tweet.isNotEmpty()) {
                tweet.append(pSep)
            }

            pSep = paragraphSeperator
        }
        if (tweet.isNotEmpty()) {
            tweets.add(tweet.toString().trim())
        }
        return tweets.toList()
    }

    companion object {
        const val DEFAULT_MAX_TWEET_LENGTH = 280

    }


}

