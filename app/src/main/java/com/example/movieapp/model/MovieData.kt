package com.app.neoleaf.credit.model

import java.io.Serializable

class MovieData: Serializable {
    var page: Int = 0
    var results: ArrayList<Result> = ArrayList()
    var total_pages: Int = 0
    var total_results: Int = 0
}