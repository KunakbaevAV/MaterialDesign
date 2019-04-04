package com.example.materialdesign.interfaces

import com.example.materialdesign.model.Card

interface ChoosenDeck {
    fun getDeck(): ArrayList<Card>
}