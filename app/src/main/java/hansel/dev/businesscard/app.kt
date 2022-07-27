package hansel.dev.businesscard

import android.app.Application
import hansel.dev.businesscard.data.AppDatabase
import hansel.dev.businesscard.data.BusinessCardRepository

class app: Application() {
    val database by lazy {AppDatabase.getDatabase(this)}
    val repository by lazy {BusinessCardRepository(database.businessDao())}
}