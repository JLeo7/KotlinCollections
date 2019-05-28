import manager.Manager

fun main() {
    val manager = Manager()
    mainMenu(manager)
    println("\nTerminando el programa.")
}

fun processNumber(msg: String?): Int {
    var isNumeric = false
    var value: String? = ""
    resetLoop@ while (!isNumeric) {
        print("\n$msg:    ")
        value = readLine()
        println()
        isNumeric = value!!.matches("-?\\d+(\\.\\d+)?".toRegex())
        if (!isNumeric) {
            println("La lista solo contiene numeros.\n")
            continue@resetLoop
        }
    }
    return value!!.toInt()
}

fun processOption(): String {
    print("Seleccione la opcion deseada:   ")
    return readLine()!!
}

fun mainMenu(manager: Manager) {
    var selectedOption = ""

    options@ while (selectedOption != "0") {

        println("\n--- Menu principal --- \n")
        println("\n1. Lista")
        println("2. Pila")
        println("3. Cola")
        println("0. Salir \n")

        selectedOption = processOption()

        when (selectedOption) {
            "1" -> listMenu(manager)
            "2" -> stackMenu(manager)
            "3" -> queueMenu(manager)
            "0" -> continue@options
            else -> println("\nPor favor seleccione alguno de los valores.")
        }
    }
}

fun listMenu(manager: Manager) {
    var selectedOption = ""

    options@ while (selectedOption != "0") {

        println("\n--- Menu de lista ---\n")
        println("\n1. Imprimir lista")
        println("2. Agregar numero a la lista")
        println("3. Mover numero a la pila")
        println("4. Mover numero a la cola")
        println("0. Volver al menu principal\n")

        selectedOption = processOption()

        when (selectedOption) {
            "1" -> println(manager.printList())
            "2" -> addToList(manager)
            "3" -> fromListToStack(manager)
            "4" -> fromListToQueue(manager)
            "0" -> continue@options
            else -> println("\nPor favor seleccione alguno de los valores.")
        }
    }
}

fun addToList(manager: Manager) {
    manager.addToList(processNumber("Ingrese el numero que desea agregar"))
}

fun fromListToStack(manager: Manager) {
    if (manager.listIsEmpty()) {
        println("La lista esta vacia\n")
    } else {
        var input: Int
        do {
            println(manager.printList())
            input = processNumber("Seleccione un numero de la lista")
        } while (!manager.valueInList(input))
        println(manager.fromListToStack(input))
    }
}

fun fromListToQueue(manager: Manager) {
    if (manager.listIsEmpty()) {
        println("La lista esta vacia\n")
    } else {
        var input: Int
        do {
            println(manager.printList())
            input = processNumber("Seleccione un numero de la lista")
        } while (!manager.valueInList(input))
        println(manager.fromListToQueue(input))
    }
}

fun stackMenu(manager: Manager) {
    var selectedOption = ""

    options@ while (selectedOption != "0") {

        println("\n--- Menu de pila ---\n")
        println("\n1. Imprimir pila")
        println("2. Agregar numero a la pila")
        println("3. Mover numero a la lista")
        println("4. Mover numero a la cola")
        println("0. Volver al menu principal\n")

        selectedOption = processOption()

        when (selectedOption) {
            "1" -> println(manager.printStack())
            "2" -> addToStack(manager)
            "3" -> println(manager.fromStackToList())
            "4" -> println(manager.fromStackToQueue())
            "0" -> continue@options
            else -> println("\nPor favor seleccione alguno de los valores.")
        }
    }
}

fun addToStack(manager: Manager) {
    manager.addToStack(processNumber("Ingrese el numero que desea agregar"))
}

fun queueMenu(manager: Manager) {
    var selectedOption = ""

    options@ while (selectedOption != "0") {

        println("\n--- Menu de cola ---\n")
        println("\n1. Imprimir cola")
        println("2. Insertar numero a la cola")
        println("3. Mover numero a la lista")
        println("4. Remover numero de la pila")
        println("0. Volver al menu principal\n")

        selectedOption = processOption()

        when (selectedOption) {
            "1" -> println(manager.printQueue())
            "2" -> addToQueue(manager)
            "3" -> println(manager.fromQueueToList())
            "4" -> println(manager.fromQueueToStack())
            "0" -> continue@options
            else -> println("\nPor favor seleccione alguno de los valores.")
        }
    }
}

fun addToQueue(manager: Manager) {
    manager.addToQueue(processNumber("Ingrese el numero que desea agregar"))
}