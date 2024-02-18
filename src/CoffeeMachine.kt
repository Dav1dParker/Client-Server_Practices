class CoffeeMachine() {
    var water: Int = 2000
    var milk: Int = 1000
    var beans: Int = 500

    private fun checkCoffee(name: String, coffee: Coffee) {
        if (coffee.water > water) {
            println("Недостаточно воды!\n")
        } else if (coffee.milk > milk) {
            println("Недостаточно молока!\n")
        } else if (coffee.beans > beans) {
            println("Недостаточно кофе!\n")
        } else {
            water -= coffee.water
            milk -= coffee.milk
            beans -= coffee.beans
            println("$name готов\n")
        }
    }

    fun start() {
        println("Кофемашина готова к работе")
        while (true) {
            println("Введите команду\n>>")
            var input = readlnOrNull()
            when (input) {
                "выключить" -> {
                    print("До свидания!\n")
                    break
                }

                "наполнить" -> {
                    water = 2000
                    milk = 1000
                    beans = 500
                    print("Ингридиенты пополнены\n")
                }

                "статус" -> print("Ингридиентов осталось:\n$water мл воды\n$milk мл молока\n$beans гр кофе\n")
                "кофе" -> {
                    print("Введите название напитка или \"назад\" для возврата в главное меню\n>>")
                    input = readlnOrNull()
                    when (input) {
                        "назад" -> {}
                        "эспрессо" -> {
                            checkCoffee(input, Coffee.Espresso)
                        }

                        "американо" -> {
                            checkCoffee(input, Coffee.Americano)
                        }

                        "капучино" -> {
                            checkCoffee(input, Coffee.Cappuccino)
                        }

                        "латте" -> {
                            checkCoffee(input, Coffee.Latte)
                        }

                        else -> {
                            print("Рецепт не найден!\n")
                        }
                    }
                }

                else -> {
                    print("Неизвестная команда\n")
                }
            }
        }
    }
}


fun main() {
    val coffeeMachine = CoffeeMachine()
    coffeeMachine.start()
}