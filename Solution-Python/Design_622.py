class MyCircularQueue:

    def __init__(self, k: int):
        self.q = [0] * k
        self.cap = k
        self.size = 0
        self.start = 0
        self.end = 0
        
    def enQueue(self, value: int) -> bool:
        if self.isFull():
            return False
        self.q[self.end] = value
        self.end = (self.end + 1) % self.cap
        self.size += 1
        return True

    def deQueue(self) -> bool:
        if self.isEmpty():
            return False
        self.start = (self.start + 1) % self.cap
        self.size -= 1
        return True

    def Front(self) -> int:
        if self.isEmpty():
            return -1
        return self.q[self.start]

    def Rear(self) -> int:
        if self.isEmpty():
            return -1
        idx = (self.end + self.cap - 1) % self.cap
        return self.q[idx]

    def isEmpty(self) -> bool:
        return self.size == 0

    def isFull(self) -> bool:
        return self.size == self.cap