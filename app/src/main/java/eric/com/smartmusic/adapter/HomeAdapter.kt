package eric.com.smartmusic.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eric.com.smartmusic.model.HomeItemBean
import eric.com.smartmusic.ui.widget.HomeItemView
import eric.com.smartmusic.ui.widget.LoadMoreView

/**
 * Description:
 *
 * @author Eric(zhangchunliang@lkmotion.com)
 * @since 2020/5/16
 */
class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeHolder>(){

    private var list = ArrayList<HomeItemBean>()

    fun updateList(list: List<HomeItemBean>)  {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun loadMoreList(list: List<HomeItemBean>){
        this.list.addAll(list)
        notifyDataSetChanged()
    }


    class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        if (viewType == 1){ // load more holder
            return HomeHolder(LoadMoreView(parent?.context))
        }
        return HomeHolder(HomeItemView(parent?.context))
    }

    override fun getItemCount(): Int {
        if (list.size == 0){
            return 0
        }
        return list.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        if (list.size == position && position != 0) {
            // type load more
            return 1
        }
        return 0
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        if (position == list.size) return
        var item = list.get(position)
        var itemView = holder.itemView as HomeItemView
        itemView.setData(item)

    }
}