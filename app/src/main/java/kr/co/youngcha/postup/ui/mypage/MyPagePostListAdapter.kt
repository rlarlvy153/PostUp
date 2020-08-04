package kr.co.youngcha.postup.ui.mypage

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kr.co.youngcha.postup.R
import kr.co.youngcha.postup.model.Post
import timber.log.Timber

class MyPagePostListAdapter (val context: Context) : RecyclerView.Adapter<MyPagePostListAdapter.ViewHolder>(){

    var spotList = ArrayList<Post>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.mypage_post_item, parent, false))
    }

    override fun getItemCount() = spotList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(spotList[position])
        holder.itemView.tag = spotList[position]
    }

    fun addItem(list : ArrayList<Post>){
        spotList.clear()
        spotList.addAll(list)
    }


    inner class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){

        val postId = itemView.findViewById<TextView>(R.id.post_id)
        val postText = itemView.findViewById<TextView>(R.id.post_text)

        init {
            itemView.setOnLongClickListener {
                Timber.d("$adapterPosition")
                val dialogBuilder = AlertDialog.Builder(context)
                dialogBuilder.setTitle("삭제")
                dialogBuilder.setMessage("삭제하시게씀?")
                dialogBuilder.setPositiveButton("YES",  {dialog: DialogInterface?, which: Int ->
                    Timber.d("remove!")
                })
                dialogBuilder.setNegativeButton("NO",  {dialog: DialogInterface?, which: Int ->
                })
                dialogBuilder.show()
                false
            }
        }

        fun bind(post : Post){
            postId.text = post.postId.toString()
            postText.text = post.text

        }
    }
}