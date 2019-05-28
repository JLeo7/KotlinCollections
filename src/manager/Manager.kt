package manager

class Manager {
    private val list = core.List()
    private val stack = core.Stack()
    private val queue = core.Queue()

    fun listIsEmpty(): Boolean {
        return list.isEmpty()
    }

    fun printList(): String {
        return list.printNodes()
    }

    fun addToList(value: Int) {
        list.insertSorted(value)
    }

    fun fromListToStack(value: Int): String {
        if (listIsEmpty()) return "No hay mas elementos que mover"
        stack.push(list.removeNode(value)!!.value)
        return "Elemeto movido con exito"
    }

    fun fromListToQueue(value: Int): String {
        if (listIsEmpty()) return "No hay mas elementos que mover"
        queue.receive(list.removeNode(value)!!.value)
        return "Elemeto movido con exito"
    }

    fun valueInList(value: Int): Boolean {
        return list.valueIsInList(value)
    }

    fun stackIsEmpty(): Boolean {
        return stack.isEmpty()
    }

    fun printStack(): String {
        return stack.printNodes()
    }

    fun addToStack(value: Int) {
        stack.push(value)
    }

    fun fromStackToList(): String {
        if (stackIsEmpty()) return "No hay mas elementos que mover"
        list.insertSorted(stack.pop()!!.value)
        return "Elemeto movido con exito"
    }

    fun fromStackToQueue(): String {
        if (stackIsEmpty()) return "No hay mas elementos que mover"
        queue.receive(stack.pop()!!.value)
        return "Elemeto movido con exito"
    }

    fun queueIsEmpty(): Boolean {
        return queue.isEmpty()
    }

    fun printQueue(): String {
        return queue.printNodes()
    }

    fun addToQueue(value: Int) {
        queue.receive(value)
    }

    fun fromQueueToList(): String {
        if (queueIsEmpty()) return "No hay mas elementos que mover"
        list.insertSorted(queue.send()!!.value)
        return "Elemeto movido con exito"
    }

    fun fromQueueToStack(): String {
        if (queueIsEmpty()) return "No hay mas elementos que mover"
        stack.push(queue.send()!!.value)
        return "Elemeto movido con exito"
    }

}