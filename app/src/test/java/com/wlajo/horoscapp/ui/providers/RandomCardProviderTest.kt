package com.wlajo.horoscapp.ui.providers

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class RandomCardProviderTest {
    @Test
    fun `getRandomCard should return a random card`() {
        val randomCard = RandomCardProvider()

        val card = randomCard.getLuck()

        assertNotNull(card)
    }
}