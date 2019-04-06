package com.example.materialdesign.model

import java.util.ArrayList

internal class CardRepository private constructor() {
    var cards = ArrayList<Card>()

    companion object {
        val instance = CardRepository()
    }
}
