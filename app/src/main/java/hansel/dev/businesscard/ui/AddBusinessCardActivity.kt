package hansel.dev.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import hansel.dev.businesscard.R
import hansel.dev.businesscard.app
import hansel.dev.businesscard.data.BusinessCard
import hansel.dev.businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private  val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as app).repository)
    }

    private fun insertListener(){
        binding.btnClose.setOnClickListener{
            finish()
        }
        binding.btnConfirm.setOnClickListener{
            val businessCard = BusinessCard(
                nome = binding.tillNome.editText?.text.toString(),
                empresa = binding.tillEmpresa.editText?.text.toString(),
                telefone = binding.tillTelefone.editText?.text.toString(),
                email = binding.tillEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tillCor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_sucess,Toast.LENGTH_SHORT).show()
            finish()
        }
    }




}