package com.doma.danina.service;

import com.doma.danina.entity.User;
import com.doma.danina.entity.Writing;
import com.doma.danina.repository.WritingRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class WritingService {
    private final WritingRepository writingRepository;

    @Transactional
    public boolean insert(String title, String body, String name) {
            Writing writing = Writing.builder()
                    .title(title)
                    .body(body)
                    .name(name)
                    .build();
            writingRepository.save(writing);
            return true;
    }

    @Transactional
    public boolean modify(long id, String newTitle, String newBody) {
        if (writingRepository.modify(id, newTitle, newBody) == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public boolean deleteWritingById(long id) {
        if (writingRepository.deleteWritingById(id) == 1) {
            return true;
        } else {
            return false;
        }
    }

    public List<Writing> getWritings() { return writingRepository.getWritings(); }

    public List<Writing> getWritingsByName(String name) { return writingRepository.getWritingsByName(name); }

    public Writing getWritingById(Long id) { return writingRepository.getWritingById(id); }

}
