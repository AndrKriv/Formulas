package com.example.formulas.addformulas.mvvm.from_that_proj

//import android.annotation.SuppressLint
//import android.content.Context
//import android.os.Bundle
//import android.widget.ArrayAdapter
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Spinner
//import androidx.appcompat.app.AppCompatActivity
//import androidx.appcompat.widget.SwitchCompat
//import com.example.formulas.R
//import com.taeim.mathdisplay.AndroidMathView
//
//class Checker : AppCompatActivity() {
//    var form: AndroidMathView? = null
//    var elem: AndroidMathView? = null
//
//    @SuppressLint("UseSwitchCompatOrMaterialCode")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.second_activity)
//
//        form = findViewById(R.id.mathViewFormula)
//        elem = findViewById(R.id.mathViewElement)
//
//        val add: Button = findViewById(R.id.add)
//        val clean: Button = findViewById(R.id.clean)
//        val save: Button = findViewById(R.id.save)
//        val check: Button = findViewById(R.id.check)
//
//        val switch: SwitchCompat = findViewById(R.id.switch_add)
//
//        val etZnak: EditText = findViewById(R.id.txt_znak)
//
//        val high: EditText = findViewById(R.id.txt_high)
//        val low: EditText = findViewById(R.id.txt_low)
//
//        val spinner: Spinner = findViewById(R.id.spinner)
//
//        //берем список названий функций. в when сравниваем с выбранной функцией
//        //проверяем на null строки, которые будем использовать
//        //нажимаем кнопку сформировать (выбираются соответственно части из high и low или самого элемента)
//        //формируется элемент
//        ButtonFunctions.addButton(add, elem, form, switch, etZnak, this)
//
//        ButtonFunctions.clean(clean, elem, form, switch, this)
//
//        ButtonFunctions.save(save, form, switch, this)
//
//        spinnerFun(spinner, this)
//
//        ButtonFunctions.check(check, high, low, this, elem, spinner)
//    }
//
//    fun spinnerFun(spinner: Spinner, context: Context) {
//        val functions = resources.getStringArray(R.array.functions)
//        val adapter = ArrayAdapter(
//            context,
//            android.R.layout.simple_spinner_item, // Layout
//            functions
//        )
//        spinner.adapter = adapter
//    }
//}
