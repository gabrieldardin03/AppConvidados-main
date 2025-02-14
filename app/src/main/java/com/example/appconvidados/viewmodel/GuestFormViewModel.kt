package com.example.appconvidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appconvidados.model.GuestModel
import com.example.appconvidados.model.SucessFailure
import com.example.appconvidados.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application)

    private val guestModel = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = guestModel

    private val _saveGuest = MutableLiveData<SucessFailure>()
    val saveGuest: LiveData<SucessFailure> = _saveGuest

    fun get(id: Int){
        guestModel.value = repository.get(id)
    }

    fun save(guest: GuestModel) {
        val successFailure = SucessFailure(true, "")
        if (guest.id == 0) {
            successFailure.sucess = repository.insert(guest)
        }else{
            successFailure.sucess = repository.update(guest)
        }
    }

}