package com.fikri.CrudTest2.dao;

import com.fikri.CrudTest2.model.Product;
import com.fikri.CrudTest2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;



@Service
public class ProductDao2 implements ProductService {
    private EntityManagerFactory emf;
    //method setter

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Product> listProduct() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Product", Product.class).getResultList();
    }
    //implements method saveOrUpdate
    @Override
    public Product saveOrUpdate(Product product) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction() .begin();
        // method merge fungsinya untuk check di database, apabila belum ada maka akan create otomatis, apabila ada maka akan otomatis akan update
        Product saved = em.merge(product);
        em.getTransaction() .commit();
        return saved;
    }
    //implements method update
    @Override
    public Product getIdProduct(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Product.class, id);
    }

    @Override
    public void hapus(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction() .begin();
        em.remove(em.find(Product.class, id));
        em.getTransaction() .commit();
    }
}

