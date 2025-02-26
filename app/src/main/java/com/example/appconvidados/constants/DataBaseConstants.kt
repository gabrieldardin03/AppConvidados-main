package com.example.appconvidados.constants

class DataBaseConstants {

    object GUEST{
        const val ID = "guestid"
        const val TABLE_NAME = "Guest"

        object COLUMNS {
            const val ID = "id"
            const val NAME = "name"
            const val PRESENCE = "presence"
            const val INGREDIENTES = "ingredientes"
        }
    }
}