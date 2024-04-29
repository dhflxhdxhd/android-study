package com.study.android

import javax.inject.Inject

class MyName @Inject constructor() {

    override fun toString(): String {
        return "hilt 배우기"
    }
}