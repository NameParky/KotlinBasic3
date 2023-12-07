package com.example.visiblegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forReload()

    }

    private fun forReload() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.title = getString(R.string.app_name)

        val wall1 = findViewById<TextView>(R.id.wall1)
        val wall2 = findViewById<TextView>(R.id.wall2)
        val wall3 = findViewById<TextView>(R.id.wall3)
        val wall4 = findViewById<TextView>(R.id.wall4)
        val wall5 = findViewById<TextView>(R.id.wall5)
        val wall6 = findViewById<TextView>(R.id.wall6)

        val clear = findViewById<TextView>(R.id.clear)

        val wallVsb = fun (textView : TextView, textView2 : TextView?, textView3 : TextView?) {
            // 모든 경우에 초기화될 수 있도록 = emptyArray() 추가
            // ?가 2개 써진이후로 경우의수가 많아진 것 같다.
            var viewArray : Array<TextView> = emptyArray()

            // 널여부에따라 Array에 들어가는 파라미터의 갯수를 결정.
            if(textView2 == null && textView3 == null) {
                viewArray = arrayOf(textView)
            } else if (textView3 == null && textView2 != null) {
                viewArray = arrayOf(textView, textView2)
            } else if (textView2 != null && textView3 != null){
                viewArray = arrayOf(textView, textView2, textView3)
            }

            // 보일땐 안보이게 안보일땐 보이게.
            for (i in viewArray) {
                if(i.visibility == View.VISIBLE) {
                    i.visibility = View.INVISIBLE
                } else {
                    i.visibility = View.VISIBLE
                }
            }

            val allViewArray : Array<TextView> = arrayOf(wall1, wall2, wall3, wall4, wall5, wall6)
            var cnt : Int = 0
            for (i in allViewArray) {
                if(i.visibility == View.VISIBLE) {
                    cnt++
                    if(cnt == 6) {
                        clear.visibility = View.VISIBLE
                    }
                }
            }
        }

        val button1 = findViewById<Button>(R.id.button1).setOnClickListener {
            wallVsb(wall1, wall3, null)
        }
        val button2 = findViewById<Button>(R.id.button2).setOnClickListener {
            wallVsb(wall1, wall3, wall5)
        }
        val button3 = findViewById<Button>(R.id.button3).setOnClickListener {
            wallVsb(wall3, wall4, null)
        }
        val button4 = findViewById<Button>(R.id.button4).setOnClickListener {
            wallVsb(wall2, wall3, wall4)
        }
        val button5 = findViewById<Button>(R.id.button5).setOnClickListener {
            wallVsb(wall5, null, null)
        }
        val button6 = findViewById<Button>(R.id.button6).setOnClickListener {
            wallVsb(wall1, wall6, null)
        }
        val restart = findViewById<Button>(R.id.restart).setOnClickListener {
            setContentView(R.layout.activity_main)
            forReload()
        }
    }
}