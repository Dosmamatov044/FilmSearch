package com.example.filmsearch.screens.result_search



import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filmsearch.databinding.ListMovieItemBinding
import com.example.filmsearch.loadImage
import com.example.filmsearch.model.Doc

class ResultSearchAdapter:RecyclerView.Adapter<ResultSearchAdapter.ResultHolder>() {

   var resultList = listOf<Doc>()
       set(value) {
           field = value
           notifyDataSetChanged()
       }

    class ResultHolder (val binding: ListMovieItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultHolder {
        val binding =
            ListMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ResultHolder(binding)
    }

    override fun onBindViewHolder(holder: ResultHolder, position: Int) {
        val binding = holder.binding
        val model = resultList[position]
        with (binding){
            tvName.text = model.name
            tvGenres.text = model.type
            tvYear.text = model.year.toString()
            tvVote.text = model.votes.kp.toString()





            try {
                imgItem.loadImage(model.poster.previewUrl)
            }catch (e:java.lang.NullPointerException){

                Log.d("errors",e.message.toString())

            }finally {
                Log.d("errors","Ммм")

            }






        }


    }

    override fun getItemCount(): Int {
       return resultList.size
    }
}