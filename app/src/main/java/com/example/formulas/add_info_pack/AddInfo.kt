package com.example.formulas.DB

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.formulas.R

class AddInfo : AppCompatActivity() {
    var dbHandler: DBHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add)

        dbHandler = DBHandler(this)

        val button_add: Button = findViewById(R.id.add_add)
        val button_show: Button = findViewById(R.id.add_delete)

        button_add.setOnClickListener(View.OnClickListener {
            add()
        })

        //on Click show button
        button_show.setOnClickListener(View.OnClickListener {
            show()
        })

    }

    fun add(){
//        val et_name: EditText = findViewById(R.id.add_name_of_formula)
//        val et_form: EditText = findViewById(R.id.add_formula)
//        if (validation()){
//            val fi = Formulas_Info()
//            var success = false
//            fi.name_of_form = et_name.text.toString()
//            fi.form = et_form.text.toString()
//
//            success = dbHandler!!.addForm(fi)
//
//            if (success){
//                Toast.makeText(this,"Saved Successfully", Toast.LENGTH_LONG).show()
//            }
//        }
    }

    fun show(){
//        val tv_show: TextView = findViewById(R.id.tv_show)
//        var fi = dbHandler!!.showAllForm()
//        tv_show.setText(fi)
    }

//    fun validation(): Boolean{
//        val et_nameOfF: EditText = findViewById(R.id.add_name_of_formula)
//        val et_F: EditText = findViewById(R.id.add_formula)
//        var validate = false
//
//        if (!et_nameOfF.text.toString().equals("") &&
//            !et_F.text.toString().equals("")){
//            validate = true
//        }else{
//            validate = false
//            Toast.makeText(this,"Проверьте корректность введенных данных", Toast.LENGTH_LONG).show()//введите всю инфу (что-то пустое)
//        }
//
//        return validate
//    }
}