package book.store.service;

import book.store.payload.request.BookRq;

public interface IBookService {

    boolean addBook(BookRq bookRq);
    boolean exist(int id);
    void updateBook(int id,BookRq bookRq);
}
