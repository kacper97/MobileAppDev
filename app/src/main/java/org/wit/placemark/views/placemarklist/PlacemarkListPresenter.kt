package org.wit.placemark.views.placemarklist

import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.startActivityForResult
import org.wit.placemark.activities.PlacemarkMapsActivity
import org.wit.placemark.main.MainApp
import org.wit.placemark.models.PlacemarkModel
import org.wit.placemark.views.placemark.PlacemarkView

class PlacemarkListPresenter(val activity: PlacemarkListView) {

  var app: MainApp

  init {
    app = activity.application as MainApp
  }

  fun getPlacemarks() = app.placemarks.findAll()

  fun doAddPlacemark() {
    activity.startActivityForResult<PlacemarkView>(0)
  }

  fun doEditPlacemark(placemark: PlacemarkModel) {
    activity.startActivityForResult(activity.intentFor<PlacemarkView>().putExtra("placemark_edit", placemark), 0)
  }

  fun doShowPlacemarksMap() {
    activity.startActivity<PlacemarkMapsActivity>()
  }
}
