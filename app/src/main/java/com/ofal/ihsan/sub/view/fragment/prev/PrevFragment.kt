package com.ofal.ihsan.sub.view.fragment.prev


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.google.gson.Gson
import com.ofal.ihsan.sub.R
import com.ofal.ihsan.sub.R.color.colorAccent
import com.ofal.ihsan.sub.adapter.PrevAdapter
import com.ofal.ihsan.sub.api.ApiRequest
import com.ofal.ihsan.sub.model.Event
import com.ofal.ihsan.sub.utils.SpaceItemDecoration
import com.ofal.ihsan.sub.utils.gone
import com.ofal.ihsan.sub.utils.visible
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout

/**
 * A simple [Fragment] subclass.
 *
 */
class PrevFragment : Fragment(), PrevView {

    private var schedules: MutableList<Event> = mutableListOf()
    private lateinit var listSchedules: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var adapter: PrevAdapter
    private lateinit var presenter: PrevPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return UI {
            frameLayout {
                lparams(width = matchParent, height = matchParent)
                swipeRefresh = swipeRefreshLayout {
                    id = R.id.swipeRefresh
                    setColorSchemeResources(colorAccent,
                            android.R.color.holo_green_light,
                            android.R.color.holo_orange_light,
                            android.R.color.holo_red_light)

                    relativeLayout {
                        lparams(width = matchParent, height = matchParent)

                        listSchedules = recyclerView {
                            id = R.id.rvPrevEvent
                            layoutManager = LinearLayoutManager(ctx)
                            addItemDecoration(SpaceItemDecoration(8))
                        }.lparams(width = matchParent, height = matchParent) {
                            centerInParent()

                        }

                        progressBar = progressBar {
                            id = R.id.pbPrevEvent
                        }.lparams {
                            centerHorizontally()
                        }
                    }
                }
            }
        }.view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initAdapter()

        swipeRefresh.onRefresh {
            presenter.getEventList(getString(R.string.resource_eventspastleague))
        }
    }

    companion object {
        fun prevInstance(): PrevFragment = PrevFragment()
    }

    private fun initAdapter() {
        adapter = PrevAdapter(schedules)
        listSchedules.adapter = adapter

        val request = ApiRequest()
        val gson = Gson()
        presenter = PrevPresenter(this, request, gson)
        presenter.getEventList(getString(R.string.resource_eventspastleague))
    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.gone()
    }

    override fun showEventList(data: List<Event>) {
        swipeRefresh.isRefreshing = false
        schedules.clear()
        schedules.addAll(data)
        adapter.notifyDataSetChanged()
    }

}