package palmariuntec.com.br.pocketpersonaltrainer.menuPrincipalFragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import palmariuntec.com.br.pocketpersonaltrainer.AgendarTreinoActivity
import palmariuntec.com.br.pocketpersonaltrainer.R

class CalendarioTreino : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_calendario, container, false)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnAddTreino -> {
                val intent = Intent(activity!!.applicationContext, AgendarTreinoActivity::class.java)
                startActivity(intent)
            }
        }
    }

}