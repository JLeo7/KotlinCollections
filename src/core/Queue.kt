package core

class Queue {
    private var head: Node? = null
    private var tail: Node? = null

    fun isEmpty(): Boolean {
        return head == null && tail == null
    }

    fun receive(value: Int) {
        val newNode = Node(value)

        when {
            isEmpty() -> {
                head = newNode
                tail = newNode
            }
            tail != null -> {
                tail!!.next = newNode
                tail = newNode
            }
        }
    }

    fun send(): Node? {
        var aux = head
        head = head?.next
        return aux
    }

    private fun getPrevious(): Node? {
        when {
            isEmpty() || head == tail || tail!!.next == null -> return null
            else -> {
                var previous = head
                while (previous!!.next != tail) {
                    previous = previous.next
                }
                return previous
            }
        }
    }

    fun printNodes(): String {
        var detail: String

        if (isEmpty()) detail = "La cola esta vacia."
        else {
            detail = "Cola: \n  - ${head!!.value}"

            if (head!!.next != null) {
                var aux = head!!.next

                while (aux!!.next != null) {
                    detail += "\n  - ${aux.value}"
                    aux = aux.next
                }
                detail += "\n  - ${aux.value}"
            }
        }
        return detail
    }
}