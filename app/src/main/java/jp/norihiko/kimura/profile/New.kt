package jp.norihiko.kimura.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText

class New : AppCompatActivity() {

    private var _profileID = -1
    private val _helper = DatabaseHelper(this@New)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)


    }

    override fun onDestroy() {
        _helper.close()
        super.onDestroy()
    }

    fun onSaveButtonClick(view: View) {

        val nametext = findViewById<EditText>(R.id.name_ed)
        val name = nametext.text.toString()

        val agetext = findViewById<EditText>(R.id.age_ed)
        val age = agetext.text.toString()

        val gendertext = findViewById<EditText>(R.id.gender_ed)
        val gender = gendertext.text.toString()

        val addresstext = findViewById<EditText>(R.id.address_ed)
        val address = addresstext.text.toString()

        val rootstext = findViewById<EditText>(R.id.roots_ed)
        val roots = rootstext.text.toString()

        val finaleducationtext = findViewById<EditText>(R.id.finaleducation_ed)
        val finaleducation = finaleducationtext.text.toString()

        val officetext = findViewById<EditText>(R.id.office_ed)
        val office = officetext.text.toString()

        val db = _helper.writableDatabase

        // 削除処理
        val sqlDelete = "DELETE FROM profilememos WHERE _id = ?"

        var stmt = db.compileStatement(sqlDelete)

        stmt.bindLong(1, _profileID.toLong())

        stmt.executeUpdateDelete()

        // 保存処理
        val sqlInsert = "INSERT INTO profilememos (_id, name, age, gender, address, roots, finaleducation, office) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"

        stmt = db.compileStatement(sqlInsert)

        stmt.bindLong(1, _profileID.toLong())
        stmt.bindString(2, name)
        stmt.bindString(3, age)
        stmt.bindString(4, gender)
        stmt.bindString(5, address)
        stmt.bindString(6, roots)
        stmt.bindString(7, finaleducation)
        stmt.bindString(8, office)

        stmt.executeInsert()

        val intent = Intent(applicationContext, SetComplete::class.java)
        startActivity(intent)
    }
}
