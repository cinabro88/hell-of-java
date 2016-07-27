package com.hell.board.repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mingook on 2016년7월 27일 (수).
 */
abstract class BaseRepository<T> {
    protected List<T> datas = new ArrayList();

    public void save(T data) {
        datas.add(data);
    }

    public List<T> findAll() {
        return datas;
    }
}
