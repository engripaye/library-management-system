package org.engripaye.librarymanagementsystem.dto;

public record BorrowRequest
        (Long userId,
         Long bookId,
         Integer days) {}
