package book.store.service;

import book.store.payload.request.AboutRq;
import org.springframework.stereotype.Service;

public interface IAboutService {
    boolean addAbout (AboutRq aboutRq);
}
