package com.example.redisom.controller;

import com.example.redisom.entity.O2ORecord;
import com.example.redisom.service.O2ORecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/o2o-records")
@RequiredArgsConstructor
public class O2RecordController {

    private final O2ORecordService service;

    @PostMapping
    public O2ORecord createRecord(@RequestBody O2ORecord record) {
        return service.save(record);
    }

    @GetMapping
    public List<O2ORecord> findAll() {
        return service.findAll();
    }

    @GetMapping("/{rn}")
    public Optional<O2ORecord> getRecordByRn(@PathVariable String rn) {
        return service.findByRn(rn);
    }

    @PutMapping("/{rn}")
    public O2ORecord updateRecord(@PathVariable String rn, @RequestBody O2ORecord record) {
        record.setRn(rn);
        return service.save(record);
    }

    @DeleteMapping("/{rn}")
    public void deleteRecord(@PathVariable String rn) {
        service.deleteByRn(rn);
    }
}

