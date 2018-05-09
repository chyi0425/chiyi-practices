class Codec:
    def __init__(self):
        self.cache = {}

    def encode(self, longUrl):
        hsh = hash(longUrl)
        if hsh not in self.cache:
            self.cache[hsh] = longUrl
        return hsh
        """Encodes a URL to a shortened URL.

        :type longUrl: str
        :rtype: str
        """


    def decode(self, shortUrl):
        return self.cache.get(shortUrl)
        """Decodes a shortened URL to its original URL.

        :type shortUrl: str
        :rtype: str
        """


# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(url))