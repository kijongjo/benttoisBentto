package com.kijong.lunch

import android.animation.ObjectAnimator
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import android.widget.Toast.*
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kijong.lunch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var isFabOpen  = false
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
    val fabOpen= AnimationUtils.loadAnimation(this,R.anim.fab_open)
    val fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close)
    val fabRClockwise = AnimationUtils.loadAnimation(this, R.anim.rotate_clockwise)
    val fabRAntiClockwise = AnimationUtils.loadAnimation(this, R.anim.rotate_anticlockwise)


    binding.fabMain.setOnClickListener {
        //클릭이벤트 버튼 색 변경
        binding.fabMain.isSelected = !binding.fabMain.isSelected
        if(isFabOpen){
            //투명뷰 안보이게 하기
            binding.blackDiv.visibility = View.INVISIBLE
            //플로팅 버튼 close
            binding.textadd.startAnimation(fabClose)
            binding.textModify.startAnimation(fabClose)
            binding.textShare.startAnimation(fabClose)
            binding.textNavi.startAnimation(fabClose)
            binding.fabadd.startAnimation(fabClose)
            binding.fabModify.startAnimation(fabClose)
            binding.fabShare.startAnimation(fabClose)
            binding.fabNavi.startAnimation(fabClose)
            binding.fabMain.startAnimation(fabRClockwise)
            isFabOpen =false
        }else{
            //투명뷰 보이게 하기
            binding.blackDiv.visibility = View.VISIBLE
            //플로팅 버튼 open
            binding.textadd.startAnimation(fabOpen)
            binding.textModify.startAnimation(fabOpen)
            binding.textShare.startAnimation(fabOpen)
            binding.textNavi.startAnimation(fabOpen)
            binding.fabadd.startAnimation(fabOpen)
            binding.fabModify.startAnimation(fabOpen)
            binding.fabShare.startAnimation(fabOpen)
            binding.fabNavi.startAnimation(fabOpen)
            binding.fabMain.startAnimation(fabRAntiClockwise)
            isFabOpen =true
        }
    }
    //메인 리스트 구현 Recycler View
    val items =mutableListOf<String>()
    items.add("홍릐 마라탕")
    items.add("이바돔 감자탕")
    items.add("김밥 분식")
    items.add("맥도날드 햄버거")
    items.add("우소 곱창전골")
    items.add("국수 나무")
    items.add("아웃백")
    items.add("구내 식당")
    items.add("현대 갈비")
    items.add("교동 짬뽕")
    val fl = findViewById<RecyclerView>(R.id.foodList)
    val flAdapter = FoodListAdapter(items)
    fl.adapter = flAdapter
    fl.layoutManager = LinearLayoutManager(this)
    }
}