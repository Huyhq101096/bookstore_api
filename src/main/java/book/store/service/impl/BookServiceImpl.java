package book.store.service.impl;

import book.store.entity.Book;
import book.store.payload.request.BookRq;
import book.store.repository.BookRepository;
import book.store.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {


    @Autowired
    private BookRepository bookRepository;

    @Override
    public boolean addBook(BookRq bookRq) {
        try {
            Book book = new Book();
            book.setName(bookRq.getName());
            book.setPrice(book.getPrice());
            book.setImage(bookRq.getFile().getOriginalFilename());
            book.setQuantity(book.getQuantity());
            book.setDesc(book.getDesc());
            bookRepository.save(book);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    //update
    public boolean exist(int id) {
        return bookRepository.existsById(id);
    }

    @Override
    public void updateBook(int id, BookRq bookRq) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setName(bookRq.getName());
            book.setPrice(bookRq.getPrice());
            book.setDesc(bookRq.getDesc());

            bookRepository.save(book);
        }
    }
}
