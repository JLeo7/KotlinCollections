package core

class Stack {
    private var head: Node? = null

    fun isEmpty(): Boolean {
        return head == null
    }

    fun push(value: Int) {
        val newNode = Node(value)

        if (isEmpty()) {
            head = newNode
        } else {
            val aux = head
            if (aux!!.value == value) return
            while (aux!!.next != null) {
                if (aux!!.value == value) return
            }
            newNode.next = aux
            head = newNode
        }
    }

    fun pop(): Node? {
        when {
            isEmpty() || head!!.next == null -> return null
            else -> {
                val aux = head
                head = aux!!.next
                return aux
            }
        }
    }

    fun printNodes(): String {
        var detail: String

        if (isEmpty()) detail = "La pila esta vacia."
        else {
            detail = "Pila: \n  - ${head!!.value}"

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