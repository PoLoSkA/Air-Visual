package ru.poloska.airvisual


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.countries_fg.*
import ru.poloska.airvisual.adapters.RecyclerItemDecorator
import ru.poloska.airvisual.adapters.StatesAdapter
import ru.poloska.airvisual.adapters.setOnItemClickListener
import ru.poloska.airvisual.navgation.Router
import ru.poloska.airvisual.view_model.StatesViewModel

class StatesFragment : Fragment() {
    private var country = ""
    private val viewModel = StatesViewModel()
    private lateinit var recyclerAdapter: StatesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.states_fg, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle: Bundle = this.arguments!!
         country = bundle.getString("CountryKey")!!

        recyclerAdapter = StatesAdapter()
        activity?.findViewById<RecyclerView>(R.id.states_rc)?.apply {
            adapter = recyclerAdapter
            addItemDecoration(RecyclerItemDecorator(4,4,4,4))
            layoutManager = LinearLayoutManager(activity)
            setOnItemClickListener {
                Router.goToCityFragment(recyclerAdapter.getItem(it), country )
            }
        }

        subscribeViewModel()
    }

    private fun showProgress(flag: Boolean){
        progress.visibility = if (flag) View.VISIBLE else View.GONE
    }

    private fun subscribeViewModel(){
        viewModel.getStatesList(country).observeOn(AndroidSchedulers.mainThread()).subscribe(
            {
                recyclerAdapter.addAllItems(it)
            }, {}
        )

        viewModel.progressObserver.observeOn(AndroidSchedulers.mainThread()).subscribe {
            showProgress(it)
        }
    }
}
