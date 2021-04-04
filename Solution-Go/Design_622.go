type MyCircularQueue struct {
    q []int
    capacity int
    size int
    start int
    end int
}


func Constructor(k int) MyCircularQueue {
    return MyCircularQueue{
        q: make([]int, k),
        capacity: k,
        size: 0,
        start: 0,
        end:0,
    }
}


func (this *MyCircularQueue) EnQueue(value int) bool {
    if this.IsFull() {
        return false
    }
    this.q[this.end] = value
    this.end = (this.end + 1) % this.capacity
    this.size++
    return true
}


func (this *MyCircularQueue) DeQueue() bool {
    if this.IsEmpty() {
        return false
    }
    this.start = (this.start + 1) % this.capacity
    this.size--
    return true
}


func (this *MyCircularQueue) Front() int {
    if this.IsEmpty() {
        return -1
    }
    return this.q[this.start]
}


func (this *MyCircularQueue) Rear() int {
    if this.IsEmpty() {
        return -1
    }
    return this.q[(this.end + this.capacity - 1) % this.capacity]
}


func (this *MyCircularQueue) IsEmpty() bool {
    return this.size == 0
}


func (this *MyCircularQueue) IsFull() bool {
    return this.size == this.capacity
}