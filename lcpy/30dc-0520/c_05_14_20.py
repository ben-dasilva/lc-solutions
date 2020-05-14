class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.words = set()
        self.trie = set()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """

        self.words.add(word)

        for i in range(len(word), 0, -1):
            fragment = word[:i]
            if fragment in self.trie:
                return
            self.trie.add(fragment)

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        return word in self.words

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        return prefix in self.trie


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)

t = Trie()

ret = [None, t.insert('apple'),
       t.search('apple'),
       t.search('app'),
       t.startsWith('app'),
       t.insert('app'),
       t.search('app')]

print(ret)