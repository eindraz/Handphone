package com.wahyuindra.handphone

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HandphoneDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun tambahHandphone(handphone: Handphone)

    @Query("SELECT * FROM Handphone")
    fun ambilSemuaHandphone(): LiveData<List<Handphone>>

}