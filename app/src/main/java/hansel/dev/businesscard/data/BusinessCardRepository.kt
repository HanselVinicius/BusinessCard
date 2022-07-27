package hansel.dev.businesscard.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinessCardRepository(private val Dao : BusinessCardDao){

    fun insert (businessCard: BusinessCard) = runBlocking {
        launch(Dispatchers.IO){
            Dao.insert(businessCard)
        }
    }


    fun getAll() = Dao.getAll()
}