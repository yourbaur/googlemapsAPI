package com.example.mapsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.select_marker.*
import kotlinx.android.synthetic.main.select_marker.view.*

class MainActivity : AppCompatActivity() {
    lateinit var mapFragment: SupportMapFragment
    lateinit var googleMap:GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap = it
            button2.setOnClickListener {
                val mDialogView = LayoutInflater.from(this).inflate(R.layout.select_marker,null)
                val mBuilder = AlertDialog.Builder(this)
                    .setView(mDialogView)
                    .setTitle("Set the two markers")
                val mAlerDialog = mBuilder.show()
                mDialogView.button.setOnClickListener {
                    val num11 = mDialogView.edit1.text.toString().toDoubleOrNull(); val num12 = mDialogView.edit11.text.toString().toDoubleOrNull()
                    val num21 = mDialogView.edit2.text.toString().toDoubleOrNull(); val num22 = mDialogView.edit22.text.toString().toDoubleOrNull()
                    if (num11!=null || num12 !=null){
                        val location1 =LatLng(num11!!, num12!!)
                        googleMap.addMarker(MarkerOptions().position(location1).title("My Location"))

                    }
                    if (num21!=null || num22 !=null){
                        val location2 =LatLng(num21!!, num22!!)
                        googleMap.addMarker(MarkerOptions().position(location2).title("Another Location"))
                    }
                    mAlerDialog.dismiss()
                }
            }

        })
    }
}
