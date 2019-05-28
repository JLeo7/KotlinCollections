package core

class List {
    private var head: Node? = null

    fun insertSorted(newValue: Int) {
        val newNode = Node(newValue)

        when {
            isEmpty() -> head = newNode
            head!!.value > newValue -> {
                newNode.next = head
                head = newNode
            }
            else -> {
                var aux = head
                if (aux!!.value == newValue) return
                while (aux!!.next != null && aux.next!!.value <= newValue) {
                    if (aux.next!!.value == newValue) return
                    aux = aux.next
                }
                newNode.next = aux.next
                aux.next = newNode
            }
        }

        if (isEmpty()) {
            head = newNode
        } else if (head!!.value > newValue) {

        } else {

        }
    }

    fun isEmpty(): Boolean {
        return head == null
    }

    fun printNodes(): String {
        var detail: String

        if (isEmpty()) {
            detail = "La lista esta vacia."
        } else {
            detail = "Lista: \n  - ${head!!.value}"

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

    fun valueIsInList(value: Int): Boolean {
        var aux = head

        if (aux!!.value == value) return true
        while (aux?.next != null) {
            if (aux.next!!.value == value) return true
            aux = aux.next
        }
        return false
    }

    fun removeNode(value: Int): Node? {
        var aux: Node = head!!
        var deleted: Node? = null
        if (aux.value == value) {
            if (aux.next != null) {
                deleted = aux
                head = aux.next
            } else {
                deleted = head
                head = null
            }
        } else {
            while (aux.next != null) {
                if (aux.next!!.value == value) {
                    deleted = aux.next
                    if (aux.next!!.next == null) {
                        aux.next = null

                    } else {
                        aux.next = aux.next!!.next!!
                    }
                }
                aux = aux.next!!
            }
        }
        return deleted
    }
}