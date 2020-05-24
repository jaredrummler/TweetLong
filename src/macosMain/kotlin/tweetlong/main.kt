package tweetlong

fun main(args: Array<String>) {
    if (args.size == 2) {
        if (args[0] == "--tweet") {
            val longTweet = args[1]
            val tweets = TweetSplitter(longTweet).split()
            val numTweets = tweets.size
            tweets.forEachIndexed { index, tweet ->
                val n = index + 1
                println("==> $n/$numTweets <=================")
                println("${index+1}/ $tweet")
                println()
            }
            return
        }
    }
    println("Usage: tweetlong --tweet [LONG TWEET]")
}