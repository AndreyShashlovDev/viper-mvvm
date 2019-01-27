package com.sprinter.viper.entity

import java.util.Date

data class OrderEntity(val id: Long, val userId: Long, val date: Date, val sum: Double)
