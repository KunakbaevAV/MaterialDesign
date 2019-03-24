package com.example.materialdesign

fun getCards(): ArrayList<Card> {
    val desk = java.util.ArrayList<Card>()
    desk.add(Card("Разведчик", "Исследует космос", R.drawable.ship01))
    desk.add(Card("Торговец", "Добывает деньги", R.drawable.ship02))
    desk.add(Card("Военный корабль", "Защищает границы", R.drawable.ship03))
    desk.add(Card("Исследователь", "Развивает новые технологии", R.drawable.ship04))
    desk.add(Card("Флагман", "Ведет вперед наступательную армию", R.drawable.ship05))
    desk.add(Card("Мобильный госпиталь", "Лечит", R.drawable.ship06))
    return desk
}