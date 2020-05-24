package tweetlong

class ParagraphSplitter(input: String) : StringSplitter(input) {

    override fun split(): List<String> = input.split("[\\n\\r]+".toRegex()).toList()

}