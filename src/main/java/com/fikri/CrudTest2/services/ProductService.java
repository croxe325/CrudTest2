package com.fikri.CrudTest2.services;

import com.fikri.CrudTest2.model.Product;
import com.fikri.CrudTest2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {



    public List<Product> listProduct();
    //khusus create
    public Product saveOrUpdate(Product product);
    //khusus update
    public Product getIdProduct(Integer id);
    //khusus delete, lalu implements ke mahasiswa DAO
    public void hapus(Integer id);


}
