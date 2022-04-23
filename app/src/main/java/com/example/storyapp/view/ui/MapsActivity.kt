package com.example.storyapp.view.ui

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.storyapp.R
import com.example.storyapp.databinding.ActivityMapsBinding
import com.example.storyapp.viewmodel.StoryViewModel
import com.example.storyapp.viewmodel.UserViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    private val storyViewModel by viewModels<StoryViewModel>()
    private val userViewModel by viewModels<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        setStyle()
        setCameraMovement()

        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isMapToolbarEnabled = true

        userViewModel.getUserPreferences().observe(this) {
            if (it.token.trim() != "") {
                storyViewModel.getStoryWithLocation(it.token)
            }
        }

        storyViewModel.dataStoryWithLocation.observe(this) {
            if (it != null) {
                for (data in it) {
                    mMap.addMarker(
                        MarkerOptions()
                            .position(LatLng(data.lat as Double, data.lon as Double))
                            .title("Story From : " + data.name)
                            .snippet("ID : " + data.id)
                    )
                }
            }
        }
    }

    private fun setCameraMovement() {
        val cameraFocus = LatLng(-6.200000, 106.816666)
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cameraFocus, 5f))
    }

    private fun setStyle() {
        try {
            val styleParsing =
                mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style))
            if (!styleParsing) {
                Toast.makeText(this, "Style Parsing Failed", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Resources.NotFoundException) {
            Toast.makeText(this, "Cant Find The Style", Toast.LENGTH_SHORT).show()
            Log.e("Error Parsing", "Can't find style. Error: ", e)
        }
    }
}