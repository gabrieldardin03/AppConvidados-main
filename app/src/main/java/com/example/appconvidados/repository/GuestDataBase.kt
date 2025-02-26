package com.example.appconvidados.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.appconvidados.constants.DataBaseConstants

class GuestDataBase(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION){

    companion object {
        private const val NAME = "guestdb"
        private const val VERSION = 2 // Aumente a versão para forçar o onUpgrade
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE " + DataBaseConstants.GUEST.TABLE_NAME + " (" +
                    DataBaseConstants.GUEST.COLUMNS.ID + " integer primary key autoincrement, " +
                    DataBaseConstants.GUEST.COLUMNS.NAME + " text, " +
                    DataBaseConstants.GUEST.COLUMNS.PRESENCE + " integer, " +
                    DataBaseConstants.GUEST.COLUMNS.INGREDIENTES + " text);"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (oldVersion < 2) {
            db.execSQL(
                "CREATE TABLE " + DataBaseConstants.GUEST.TABLE_NAME + " (" +
                        DataBaseConstants.GUEST.COLUMNS.ID + " integer primary key autoincrement, " +
                        DataBaseConstants.GUEST.COLUMNS.NAME + " text, " +
                        DataBaseConstants.GUEST.COLUMNS.PRESENCE + " integer, " +
                        DataBaseConstants.GUEST.COLUMNS.INGREDIENTES + " text);"
            )
        }
    }
}