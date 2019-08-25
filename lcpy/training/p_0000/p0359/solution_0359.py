class Logger:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.last_printed = {}


    def shouldPrintMessage(self, timestamp: int, message: str) -> bool:
        """
        Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity.
        """

        last = self.last_printed.get(message, None)

        if last is None or timestamp >= last + 10:
            self.last_printed[message] = timestamp
            return True

        return False



# Your Logger object will be instantiated and called as such:
# obj = Logger()
# param_1 = obj.shouldPrintMessage(timestamp,message)


logger = Logger()

print(logger.shouldPrintMessage( 1, "foo"))
print(logger.shouldPrintMessage( 2, "bar"))
print(logger.shouldPrintMessage( 3, "foo"))
print(logger.shouldPrintMessage( 8, "bar"))
print(logger.shouldPrintMessage(10, "foo"))
print(logger.shouldPrintMessage(11, "foo"))

