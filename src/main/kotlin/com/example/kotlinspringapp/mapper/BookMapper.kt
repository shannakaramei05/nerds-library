package com.example.kotlinspringapp.mapper

import com.example.kotlinspringapp.dto.AddStocksBookRequest
import com.example.kotlinspringapp.dto.BookResponseDTO
import com.example.kotlinspringapp.dto.WishListBookRequestDTO
import com.example.kotlinspringapp.model.*

object BookMapper {
   fun toDTO(book: Book) : BookResponseDTO {
       return BookResponseDTO(
           title=book.title,
           publishYear = book.publishYear,
           bookCoverUrl = book.bookCoverUrl,
           author  = book.author?.fullName ?: ""
       )
   }

    fun toEntity(bookResponseDTO: BookResponseDTO, author:Author) :Book {
        return Book(
            title = bookResponseDTO.title,
            publishYear = bookResponseDTO.publishYear,
            bookCoverUrl = bookResponseDTO.bookCoverUrl,
            author = author
        )
    }

    fun toWishListEntity(request:WishListBookRequestDTO, user:User) : WishListBook {
        return WishListBook(
            user = user,
            bookTitle = request.bookTitle,
            bookAuthor = request.bookAuthor
        )
    }

    fun wishListToString(request:List<WishListBook>) : List<String> {
        return request.map{it.bookTitle}
    }

    fun toBookStocks(request:AddStocksBookRequest, book:Book) : BookStocks {
        return BookStocks(
            totalCopies = request.totalCopies,
            availableCopies = request.availableCopes,
            isAvailable = true,
            book = book
        )
    }
}