package io.adev.maxims_bar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils.TruncateAt.END
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class IngridientsCountingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        class Reciept(
                val imageResource: Int,
                val text: String)

        val reciepts = listOf(
                Reciept(
                        imageResource = R.drawable.image,
                        text = "Виски-кола"),
                Reciept(
                        imageResource = R.drawable.image,
                        text = "Виски-кола 1"),
                Reciept(
                        imageResource = R.drawable.image,
                        text = "Виски-кола 2"),
                Reciept(R.drawable.image, "Виски-кола 3"),
                Reciept(R.drawable.image, "Виски-кола 4"),
                Reciept(R.drawable.image, "Виски-кола 5"),
                Reciept(R.drawable.image, "Виски-кола 6"),
                Reciept(R.drawable.image, "Виски-кола 7"),
                Reciept(R.drawable.image, "Виски-кола 8"))

        val imageId = 0
        val textId = 1

        class RecieptViewHolder(recieptView: View) : RecyclerView.ViewHolder(recieptView) {
            val imageView = recieptView.find<ImageView>(imageId)
            val textView  = recieptView.find<TextView>(textId)
            fun bind(reciept: Reciept): Unit = run {
                imageView.imageResource = reciept.imageResource
                textView.text = reciept.text
            }
        }

        val adapter = object : RecyclerView.Adapter<RecieptViewHolder>() {
            override fun getItemCount() = reciepts.size
            override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = run {

                val recieptView = UI {

                    verticalLayout {
                        imageView {
                            id = imageId
                        }.lparams {
                            height = dip(120)
                        }
                        textView {
                            id = textId
                            ellipsize = END
                            setLines(1)
                        }
                    }

                }.view

                RecieptViewHolder(recieptView)
            }
            override fun onBindViewHolder(holder: RecieptViewHolder, position: Int) {
                val reciept = reciepts[position]
                holder.bind(reciept)
            }
        }

        val ui = UI {

            recyclerView {
                this.adapter = adapter
                layoutManager = GridLayoutManager(this@IngridientsCountingActivity, 2)
            }

        }

        setContentView(ui.view)
    }


}
