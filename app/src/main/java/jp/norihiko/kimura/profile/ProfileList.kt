package jp.norihiko.kimura.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView

class ProfileList : AppCompatActivity() {

    private var _profileID = -1
    private val _helper = DatabaseHelper(this@ProfileList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_list)

        val db = _helper.writableDatabase

        val sql = "SELECT * FROM profilememos WHERE _id = ${_profileID}"

        val cursor = db.rawQuery(sql, null)

        var name = "未設定"
        var age = "未設定"
        var gender = "未設定"
        var address = "未設定"
        var roots = "未設定"
        var finaleducation = "未設定"
        var office = "未設定"

        while(cursor.moveToNext()) {
            val idxName = cursor.getColumnIndex("name")
            val idxAge = cursor.getColumnIndex("age")
            val idxGender = cursor.getColumnIndex("gender")
            val idxAddress = cursor.getColumnIndex("address")
            val idxRoots = cursor.getColumnIndex("roots")
            val idxFinaleducation = cursor.getColumnIndex("finaleducation")
            val idxOffice = cursor.getColumnIndex("office")

            name = cursor.getString(idxName)
            age = cursor.getString(idxAge)
            gender = cursor.getString(idxGender)
            address = cursor.getString(idxAddress)
            roots = cursor.getString(idxRoots)
            finaleducation = cursor.getString(idxFinaleducation)
            office = cursor.getString(idxOffice)
        }

        val nametext = findViewById<TextView>(R.id.name_content)
        nametext.setText(name)

        val agetext = findViewById<TextView>(R.id.age_content)
        agetext.setText(age)

        val gendertext = findViewById<TextView>(R.id.gender_content)
        gendertext.setText(gender)

        val addresstext = findViewById<TextView>(R.id.address_content)
        addresstext.setText(address)

        val rootstext = findViewById<TextView>(R.id.roots_content)
        rootstext.setText(roots)

        val finaleducationtext = findViewById<TextView>(R.id.finaleducation_content)
        finaleducationtext.setText(finaleducation)

        val officetext = findViewById<TextView>(R.id.office_content)
        officetext.setText(office)


    }


}
