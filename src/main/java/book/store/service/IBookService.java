package book.store.service;

import book.store.payload.request.BookRq;

public interface IBookService {

    boolean addBook(BookRq bookRq);

}
