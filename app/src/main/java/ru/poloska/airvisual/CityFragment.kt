package ru.poloska.airvisual

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.city_fg.*
import ru.poloska.airvisual.adapters.CityAdapter
import ru.poloska.airvisual.adapters.RecyclerItemDecorator
import ru.poloska.airvisual.adapters.setOnItemClickListener
import ru.poloska.airvisual.view_model.CityViewModel


class CityFragment : Fragment() {
    private lateinit var cityAdapter: CityAdapter
    private val viewModel = CityViewModel()
    private var country: String = ""
    private var state: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.city_fg, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments!!
        country = bundle.getString("CountryKey")!!
        state = bundle.getString("StateKey")!!

        cityAdapter = CityAdapter()

        activity?.findViewById<RecyclerView>(R.id.city_rc)?.apply {
            adapter = cityAdapter
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(RecyclerItemDecorator(4,4,4,4))
            setOnItemClickListener {

            }
        }

        viewModel.getCity(state, country).observeOn(AndroidSchedulers.mainThread()).subscribe ({
            cityAdapter.addAllItems(it)
        },{

        })

        viewModel.progressObserver.observeOn(AndroidSchedulers.mainThread()).subscribe{
            showProgres(it)
        }
    }

    private fun showProgres(flag: Boolean){
        progress.visibility = if (flag) View.VISIBLE else View.GONE
    }
}
