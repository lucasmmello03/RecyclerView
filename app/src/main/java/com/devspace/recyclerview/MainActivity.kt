package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)

        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)
        }
        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }

        adapter.setOnClickListener { contact ->
            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.icon)
            startActivity(intent)
        }
    }

    private val contacts = listOf(
        Contact(
            name = "Lucas",
            phone = "(53) 98135-0797",
            icon = R.drawable.sample12
        ),
        Contact(
            name = "Raíssa",
            phone = "(53) 98166-4533",
            icon = R.drawable.sample13
        ),
        Contact(
            name = "Kátia",
            phone = "(53) 98145-5678",
            icon = R.drawable.sample3
        ),
        Contact(
            name = "Rômulo",
            phone = "(53) 98177-4733",
            icon = R.drawable.sample14
        ),
        Contact(
            name = "Jaqueline",
            phone = "(53) 98456-0797",
            icon = R.drawable.sample4
        ),
        Contact(
            name = "Hueber",
            phone = "(53) 98454-0894",
            icon = R.drawable.sample8
        ),
        Contact(
            name = "Leandro",
            phone = "(53) 98172-0787",
            icon = R.drawable.sample9
        ),
        Contact(
            name = "Márcia",
            phone = "(53) 98439-4297",
            icon = R.drawable.sample6
        ),
        Contact(
            name = "Marcos",
            phone = "(53) 98455-0995",
            icon = R.drawable.sample10
        ),
        Contact(
            name = "Julia",
            phone = "(53) 98132-0347",
            icon = R.drawable.sample5
        ),
        Contact(
            name = "Roberta",
            phone = "(53) 98163-4239",
            icon = R.drawable.sample1
        ),
        Contact(
            name = "Kátia",
            phone = "(53) 98134-4676",
            icon = R.drawable.sample11
        ),
    )
}