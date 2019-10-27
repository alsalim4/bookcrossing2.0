package com.example.bookcrossing.presentation.sample

import androidx.lifecycle.MutableLiveData
import com.example.bookcrossing.base.BaseViewModel
import com.example.bookcrossing.entities.Sample
import com.example.fundament.presentation.sample.SampleRepository

class SampleViewModel(private val repository: SampleRepository) : BaseViewModel() {

    val sampleListLiveData = MutableLiveData<ArrayList<Sample>>()

    fun postSample(sampleObject: Sample) {
        makeRequest({repository.postSample(sampleObject)}){ res->
            unwrap(res){
                messageLiveData.value = "Успешно добавлено!"
            }
        }

    }

    fun getSamples() {
        makeRequest({ repository.getSamples() }) { res ->
            unwrap(res) {
                sampleListLiveData.value = it as ArrayList<Sample>
            }
        }
    }
}