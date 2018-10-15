package com.example.f.submisionfinal.util

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SchedulerProviders{
    interface BaseSchedulerProvider {
        fun io(): Scheduler
        fun computation(): Scheduler
        fun ui(): Scheduler
    }

   class SchedulerProvider : BaseSchedulerProvider {
        override fun computation() = Schedulers.computation()
        override fun ui() = AndroidSchedulers.mainThread()
        override fun io() = Schedulers.io()
    }

    class TrampolineSchedulerProvider : BaseSchedulerProvider {
        override fun computation() = Schedulers.trampoline()
        override fun ui() = Schedulers.trampoline()
        override fun io() = Schedulers.trampoline()
    }
}

