package hansel.dev.businesscard.ui

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import hansel.dev.businesscard.app


import hansel.dev.businesscard.databinding.ActivityMainBinding
import hansel.dev.businesscard.util.image
import hansel.dev.businesscard.util.image.Companion.share

class MainActivity : AppCompatActivity() {

    private  val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as app).repository)
    }

    private val adapter by lazy { BusinessCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCard.adapter = adapter
        getAllBusinessCard()
        insertListener()
    }


    private fun insertListener(){
        binding.fab.setOnClickListener{
            val intent = Intent(this,AddBusinessCardActivity::class.java)
            startActivity(intent)
        }
        adapter.listenerShare = { card ->
        image.share(this, card)

        }
    }


    private fun getAllBusinessCard(){
        mainViewModel.getAll().observe(this,{   businessCards ->
            adapter.submitList(businessCards)


        })
    }


}