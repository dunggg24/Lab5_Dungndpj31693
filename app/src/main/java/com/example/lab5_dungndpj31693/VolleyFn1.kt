package com.example.lab5_dungndpj31693

import android.content.Context
import android.widget.AutoCompleteTextView
import android.widget.TextView
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.Volley

class VolleyFn1 {
    var strJSON=""
    //ham doc du lieu
    fun getAllData(context: Context,textView: TextView)
    {
        //1.Tao request
        val queue = Volley.newRequestQueue(context)
        //2.Truyen url
        var url = "https://hungnttg.github.io/array_json_new.json"
        //mang cua cac doi tuong  -> goi mang truoc, doi tuong sau
        //jsonarrayrequest(
        val request = JsonArrayRequest(url,{response ->
            for (i in 0 until response.length()){
                try {
                    val person = response.getJSONObject(i);
                    val id = person.getString("id");
                    val name = person.getString("name")
                    var email = person.getString("email");
                    //dua tat ca vao chuoi
                    strJSON +="Id: $id\n";
                    strJSON +="Name: $id\n";
                    strJSON +="Email: $id\n";

                }catch (e: Exception){
                    e.printStackTrace();
                }
            }
            textView.text = strJSON // hien thi ket qua len man hinh

        },{ error -> textView.text = error.message });
        //b4. thuc thi request
        queue.add(request)
    }
}