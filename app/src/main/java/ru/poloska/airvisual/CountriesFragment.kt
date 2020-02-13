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
import ru.poloska.airvisual.adapters.CountriesAdapter
import ru.poloska.airvisual.adapters.RecyclerItemDecorator
import ru.poloska.airvisual.adapters.setOnItemClickListener
import ru.poloska.airvisual.view_model.CountriesViewModel

class CountriesFragment : Fragment() {

    private lateinit var recyclerAdapter: CountriesAdapter
    private val viewModel = CountriesViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.countries_fg, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerAdapter = CountriesAdapter(context!!)

        activity?.findViewById<RecyclerView>(R.id.countries_rc)?.apply {
            addItemDecoration(RecyclerItemDecorator(8, 8, 8, 8))
            layoutManager = LinearLayoutManager(activity)
            adapter = recyclerAdapter
            setOnItemClickListener {
                val item = recyclerAdapter.getItem(it)
                Toast.makeText(context, item, Toast.LENGTH_LONG).show()
            }
        }

        viewModel.getCountriesList().observeOn(AndroidSchedulers.mainThread()).subscribe({
            recyclerAdapter.replaceItems(it.countriesList)
        }, {

        })
    }
}

