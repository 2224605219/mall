package com.rl.service.impl;

import com.rl.entity.Brand;
import com.rl.mapper.BrandMapper;
import com.rl.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ronglin
 * @version 1.0
 * @crate_time 2021/9/3 15:44
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;


//    private List<String> strings = new ArrayList<String>() {
//        {
//            add("55");
//            add("w33");
//            add("sss");
//        }
//    };
//
//    private Map<String, Brand> map = new HashMap<String, Brand>() {
//        {
//            put("77", new Brand() {
//                {
//                    setId(10);
//                    setIntroduce("444");
//                }
//            });
//        }
//    };

    @Override
    public List<Brand> queryAll() {
        return this.brandMapper.queryAll();
    }

    @Override
    public Brand getById(Integer id) {
        return this.brandMapper.getById(id);
    }

    @Override
    public void add(Brand brand) {
        this.brandMapper.add(brand);
    }

    @Override
    public void update(Brand brand) {
        this.brandMapper.update(brand);
    }

    @Override
    public void delete(Integer id) {
        this.brandMapper.delete(id);
    }

    @Override
    public void batchDel(int[] ids) {
        this.brandMapper.batchDel(ids);
    }
}
