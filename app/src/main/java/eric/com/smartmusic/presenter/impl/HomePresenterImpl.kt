package eric.com.smartmusic.presenter.impl

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import eric.com.smartmusic.model.HomeItemBean
import eric.com.smartmusic.net.HomeRequest
import eric.com.smartmusic.net.HomeResponseHandler
import eric.com.smartmusic.net.NetManager
import eric.com.smartmusic.net.ResponseHandler
import eric.com.smartmusic.presenter.Interf.HomePresenter
import eric.com.smartmusic.presenter.Interf.HomePresenter.Companion.TYPE_INIT_OR_REFRESH
import eric.com.smartmusic.presenter.Interf.HomePresenter.Companion.TYPE_LOAD_MORE
import eric.com.smartmusic.presenter.Interf.HomeView
import eric.com.smartmusic.util.ThreadUtil
import eric.com.smartmusic.util.URLProviderUtils
import okhttp3.*
import java.io.IOException

/**
 * Description:
 *
 * @author Eric(zhangchunliang@lkmotion.com)
 * @since 2020/5/16
 */
class HomePresenterImpl(var homeView: HomeView):HomePresenter, HomeResponseHandler<List<HomeItemBean>>() {

    override fun loadDatas() {
        handlerType = TYPE_INIT_OR_REFRESH;
        HomeRequest(0, this).execute()
//        NetManager.netManager.sendRequest(request)
//        var path = URLProviderUtils.getHomeUrl(0, 20)
//        var request = Request.Builder().apply {
//            url(path)
//            get()
//        }.build()
//        OkHttpClient().newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                ThreadUtil.runOnMainUiThread {
//                    homeView.onFailure(e.message)
//                }
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
//                }
//
//                if (request == null) {
//                    homeView.onFailure("response code:${response.code()}message:${response.message()}")
//                    return
//                }
//                val gson = Gson()
//                val list = gson.fromJson<List<HomeItemBean>>(result,
//                    object : TypeToken<List<HomeItemBean>>(){}.type)
//
//                ThreadUtil.runOnMainUiThread{
//                    homeView.onSuccess(list)
//                }
//            }
//        })
    }

    override fun loadMore(offset: Int) {
        handlerType = TYPE_LOAD_MORE;
        var request = HomeRequest(0, this)
        NetManager.netManager.sendRequest(request)


//        var path = URLProviderUtils.getHomeUrl(offset, 20)
//        var request = Request.Builder().apply {
//            url(path)
//            get()
//        }.build()
//        OkHttpClient().newCall(request).enqueue(object :Callback{
//            override fun onFailure(call: Call, e: IOException) {
//                homeView.onFailure(e.message)
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
//                }
//                if (request == null) {
//                    ThreadUtil.runOnMainUiThread {
//                        homeView.onFailure("response code:${response.code()}message:${response.message()}")
//                    }
//                    return
//                }
//                val gson = Gson()
//                val list = gson.fromJson<List<HomeItemBean>>(result,
//                    object :TypeToken<List<HomeItemBean>>(){}.type)
//
//                ThreadUtil.runOnMainUiThread{
//                    homeView.loadMore(list)
//                }
//            }
//        })
    }

    override fun homeFailure(message: String?) {
        message?.let {
            homeView.onFailure(message)
        }
    }

    override fun homeSuccess(type: Int, response: List<HomeItemBean>) {
        when(type) {
            TYPE_INIT_OR_REFRESH->homeView.onSuccess(response)
            TYPE_LOAD_MORE->homeView.loadMore(response)
        }
    }
}