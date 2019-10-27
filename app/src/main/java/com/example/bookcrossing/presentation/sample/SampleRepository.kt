package com.example.fundament.presentation.sample

import com.example.bookcrossing.entities.AsyncResult
import com.example.bookcrossing.entities.Sample
import com.example.bookcrossing.entities.Table
import com.example.bookcrossing.extensions.getData
import com.example.bookcrossing.extensions.postData
import com.google.firebase.database.DatabaseReference

class SampleRepository(private val firebase: DatabaseReference) {

    suspend fun postSample(sampleObject: Sample): AsyncResult<Sample> {
        return firebase.postData(Table.SAMPLE, sampleObject)
    }

    suspend fun getSamples(): AsyncResult<List<Sample>> {
        return firebase.getData(Table.SAMPLE)
    }
}


