package com.example.f.submisionfinal.util

import android.widget.SearchView
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class RxSearchView() {
    private var searchView: SearchView? = null

    fun getSearchView(searchView: SearchView) {
        this.searchView = searchView
    }

    fun getTextWatcherObservable(): Observable<String> {
        val subject = PublishSubject.create<String>()
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                subject.onNext(newText)
                return false
            }
        })
        return subject
    }
}