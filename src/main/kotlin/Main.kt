fun main() {
    println("Первая задача")
    println("был(а) в сети ${agoToText(3600)}")
    println("------")
    println("Вторая задача")
    println(comissionPay("Mastercard"))
    println(comissionPay("Мир"))
}

fun agoToText(timeSeconds: Int): String {
    val minutesText: String
    val hoursText: String
    val timeMinutes = timeSeconds/60
    val timeHours = timeMinutes/60

    return when (timeSeconds){
        in 0..60 -> "только что"
        in 61..60*60 -> "$timeMinutes ${minutesText(timeMinutes)} назад"
        in (60*60)+1..24*60*60 -> "$timeHours ${hoursText(timeHours)} назад"
        in (24*60*60)+1..24*60*60*2 -> "сегодня"
        in (24*60*60*2)+1..(24*60*60*3) -> "вчера"
        else -> "давно"
    }
}

fun comissionPay(cardType: String): Int {
    val summTrans = 400
    val summPrevTrans = 0

    return when (cardType) {
        "Mastercard", "Maestro" -> if ((summTrans > 300) && ((summTrans+summPrevTrans) < 75000)) 0 else (summTrans*100/1000*6)+20*100
        "Visa", "Мир" -> if((summTrans/10000*75) > 35) summTrans*100/10000*75 else 35
        "VK Pay" -> 0
        else -> 0
    }
}
fun minutesText (timeMinutes: Int): String {
    return when {
        (timeMinutes > 10) && (timeMinutes < 20) -> "минут"
        timeMinutes%10 == 1 -> "минуту"
        timeMinutes%10 == 2 -> "минуты"
        timeMinutes%10 == 3 -> "минуты"
        timeMinutes%10 == 4 -> "минуты"
        timeMinutes%10 == 5 -> "минут"
        else -> "минут"
    }
}
fun hoursText(timeHours: Int) : String {
    return when {
        timeHours == 1 -> "час"
        timeHours == 2 -> "часа"
        timeHours == 3 -> "часа"
        timeHours == 4 -> "часа"
        timeHours == 21 -> "час"
        timeHours == 22 -> "часа"
        timeHours == 23 -> "часа"
        else -> "часов"
    }
}