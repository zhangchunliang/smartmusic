package eric.com.smartmusic.ui.fragment

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import eric.com.smartmusic.R
import eric.com.smartmusic.adapter.HomeAdapter
import eric.com.smartmusic.model.HomeItemBean
import eric.com.smartmusic.presenter.Interf.HomeView
import eric.com.smartmusic.presenter.impl.HomePresenterImpl
import eric.com.smartmusic.util.ThreadUtil
import eric.com.smartmusic.util.URLProviderUtils
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException

/**
 * Description:
 *
 * @author Eric(zhangchunliang@lkmotion.com)
 * @since 2020/5/15
 */
class HomeFragment : BaseFragment(), HomeView{

    private val adapter by lazy { HomeAdapter()}
    private val presenter by lazy { HomePresenterImpl(this) }

    override fun initView(): View? {
        return View.inflate(context, R.layout.fragment_home, null)
    }

    override fun initListener() {
        // init RecycleView
        recyclerview.layoutManager = LinearLayoutManager(context)
        // adapter view
        recyclerview.adapter = adapter
        // init refreshLayout
        refreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GREEN)
        // refreshLayout listener
        refreshLayout.setOnRefreshListener {
//            loadDatas()
            presenter.loadDatas()
        }
        // recyclerview listener
        recyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    var layoutManager = recyclerView.layoutManager
                    if (layoutManager is LinearLayoutManager) {
                        var position = layoutManager.findLastVisibleItemPosition()
                        if (position == adapter.itemCount -1){
//                            loadMore(position)
                            presenter.loadMore(position)
                        }
                    }
                }
            }

//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//            }
        })
    }

    override fun initData() {
//        loadDatas()
        presenter.loadDatas()
    }

    override fun onFailure(message: String?) {
        refreshLayout.isRefreshing = false
        message?.let {
            showToast(message)
        }
    }

    override fun onSuccess(list: List<HomeItemBean>?) {
        refreshLayout?.let {
            it.isRefreshing = false
        }
        list?.let{
            adapter.updateList(list)
        }

    }

    override fun loadMore(list: List<HomeItemBean>?) {
        list?.let{
            adapter.loadMoreList(list)
        }

    }

//    private fun loadDatas() {
//        var path = URLProviderUtils.getHomeUrl(0, 20)
//        var request = Request.Builder().apply {
//            url(path)
//            get()
//        }.build()
//        OkHttpClient().newCall(request).enqueue(object :Callback{
//            override fun onFailure(call: Call, e: IOException) {
//                ThreadUtil.runOnMainUiThread {
//                    refreshLayout.isRefreshing = false
//                }
//                showToast("获取数据出错:$call")
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                ThreadUtil.runOnMainUiThread {
//                    refreshLayout.isRefreshing = false
//                }
//                var result: String? = response?.let {
//                    if (it.code() == 200) {
//                        it.body().toString()
//                    }else{
//                        println("result:${it.code()}")
//                        null
//                    }
//                } ?: return
//                showToast("获取数据成功:$result")
//                val gson = Gson()
//                val list = gson.fromJson<List<HomeItemBean>>(result,
//                    object :TypeToken<List<HomeItemBean>>(){}.type)
//
//                ThreadUtil.runOnMainUiThread{
//                    adapter.updateList(list)
//                }
//            }
//        })
//    }
//
//    private fun loadMore(offset:Int) {
//        var path = URLProviderUtils.getHomeUrl(offset, 20)
//        var request = Request.Builder().apply {
//            url(path)
//            get()
//        }.build()
//        OkHttpClient().newCall(request).enqueue(object :Callback{
//            override fun onFailure(call: Call, e: IOException) {
//                showToast("获取数据出错:$call")
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                var result: String? = response?.let {
//                    if (it.code() == 200) {
//                        it.body().toString()
//                    }else{
//                        println("result:${it.code()}")
//                        null
//                    }
//                } ?: return
//                showToast("获取数据成功:$result")
//                val gson = Gson()
//                val list = gson.fromJson<List<HomeItemBean>>(result,
//                    object :TypeToken<List<HomeItemBean>>(){}.type)
//
//                ThreadUtil.runOnMainUiThread{
//                    adapter.loadMoreList(list)
//                }
//            }
//        })
//    }
}