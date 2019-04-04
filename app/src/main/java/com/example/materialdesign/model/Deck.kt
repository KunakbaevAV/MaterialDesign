package com.example.materialdesign.model

import com.example.materialdesign.R

fun getCards(): ArrayList<Card> {
    val desk = java.util.ArrayList<Card>()
    desk.add(Card("Разведчик", "Исследует космос", R.drawable.ship01, R.drawable.icon_coin))
    desk.add(Card("Торговец", "Добывает деньги", R.drawable.ship02, R.drawable.icon_coin))
    desk.add(Card("Военный корабль", "Защищает границы", R.drawable.ship03, R.drawable.icon_coin))
    desk.add(Card("Исследователь", "Развивает новые технологии", R.drawable.ship04, R.drawable.icon_coin))
    desk.add(Card("Флагман", "Ведет вперед наступательную армию", R.drawable.ship05, R.drawable.icon_coin))
    desk.add(Card("Мобильный госпиталь", "Лечит", R.drawable.ship06, R.drawable.icon_coin))
    desk.add(Card("Строитель врат", "Строит межгалактиеские врата", R.drawable.ship07, R.drawable.icon_coin))
    desk.add(Card("Инквизитор", "Защищает порядок внутри владений", R.drawable.ship08, R.drawable.icon_coin))
    desk.add(Card("Пират", "Живет по своим законам", R.drawable.ship09, R.drawable.icon_coin))
    desk.add(Card("Ремонтник", "Чинит другие космические корабли и станции", R.drawable.ship10, R.drawable.icon_coin))
    desk.add(Card("Круизный корабль", "Совершает экскурсии", R.drawable.ship11, R.drawable.icon_coin))
    desk.add(Card("Шахтер", "Добывает ресурсы", R.drawable.ship12, R.drawable.icon_coin))
    desk.add(Card("Истребитель", "Быстрый и маневренный", R.drawable.ship13, R.drawable.icon_coin))
    return desk
}