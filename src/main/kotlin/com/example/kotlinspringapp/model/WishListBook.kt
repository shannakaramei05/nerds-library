package com.example.kotlinspringapp.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
data class WishListBook(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long = 0,

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    val user:User,

    val bookTitle:String,

    val bookAuthor:String
)
