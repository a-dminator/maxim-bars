package io.adev.maxims_bar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk15.listeners.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val ui = UI {

            val names = listOf(
                    "Алкогольные коктейли",
                    "Безалкогольные коктейли",
                    "Алкогольные напитки",
                    "Безалкогольные напитки")

            verticalLayout {

                names.forEach { name ->

                    button {
                        text = name
                        onClick {
                            startActivity<IngridientsCountingActivity>()
                        }
                    }.lparams {
                        width = matchParent
                        topMargin = dip(10)
                        horizontalMargin = dip(10)
                    }

                }

            }

        }

        setContentView(ui.view)
    }

}