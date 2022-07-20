package luiz.augusto.Bookstoreapi.services;

import lombok.RequiredArgsConstructor;
import luiz.augusto.Bookstoreapi.exceptions.ObjectNotFoundException;
import luiz.augusto.Bookstoreapi.model.entities.RentBook;
import luiz.augusto.Bookstoreapi.repositories.RentBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentBookService {

    private final RentBookRepository rentBookRepository;

    public List<RentBook> getAllRents(){ return rentBookRepository.findAll(); }

    public RentBook getRentById(Long rentId)
    {
        return rentBookRepository.findById(rentId).orElseThrow(
                () -> new ObjectNotFoundException("There is no Rent with id = "+ rentId));
    }
}
