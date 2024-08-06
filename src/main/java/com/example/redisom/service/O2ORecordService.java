package com.example.redisom.service;

import com.example.redisom.entity.O2ORecord;
import com.example.redisom.repository.O2ORecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class O2ORecordService {

    private final O2ORecordRepository recordRepository;


    public O2ORecord save(O2ORecord record) {
        return recordRepository.save(record);
    }

    public Optional<O2ORecord> findByRn(String rn) {
        return recordRepository.findByRn(rn);
    }

    public void deleteByRn(String rn) {
        recordRepository.deleteByRn(rn);
    }

    public List<O2ORecord> findAll() {
        return recordRepository.findAll();
    }
}
