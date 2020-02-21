package ru.poloska.airvisual

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.countries_fg.*
import ru.poloska.airvisual.adapters.CountriesAdapter
import ru.poloska.airvisual.adapters.RecyclerItemDecorator
import ru.poloska.airvisual.adapters.setOnItemClickListener
import ru.poloska.airvisual.navgation.Router
import ru.poloska.airvisual.view_model.CountriesViewModel

class CountriesFragment : Fragment() {

    private val LOG_TAG = CountriesFragment::class.java.simpleName

    private lateinit var recyclerAdapter: CountriesAdapter
    private val viewModel = CountriesViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.countries_fg, container, false)
    }

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerAdapter = CountriesAdapter()

        activity?.findViewById<RecyclerView>(R.id.countries_rc)?.apply {
            addItemDecoration(RecyclerItemDecorator(4, 4, 4, 4))
            layoutManager = LinearLayoutManager(activity)
            adapter = recyclerAdapter
            setOnItemClickListener {
                Router.goToStatesFragment(recyclerAdapter.getItem(it))
            }
        }

        subscribeResources()

        viewModel.progressObserver.observeOn(AndroidSchedulers.mainThread()).subscribe {
            showProgress(it)
        }
    }

    private fun showProgress(flag: Boolean) {
        progress.visibility = if (flag) View.VISIBLE else View.GONE
    }

    @SuppressLint("CheckResult")
    private fun subscribeResources() {
        viewModel.getCountriesList()
            .observeOn(AndroidSchedulers.mainThread())
            .retryWhen {
               it.flatMap {
                   showDialog()
                   viewModel.retrySubject }
            }
            .subscribe({
                recyclerAdapter.replaceAllItems(it)
            }, {

            })
    }

   private fun showDialog() {
        AlertDialog.Builder(context!!)
            .setMessage("Something Wrong")
            .setPositiveButton("Retry") { _, _ ->
                viewModel.startRetry()
            }.create().show()
    }
}

