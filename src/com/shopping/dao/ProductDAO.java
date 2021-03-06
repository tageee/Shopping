package com.shopping.dao;

import com.shopping.Product;

import java.util.Date;
import java.util.List;

/**
 * Created by tage on 2/5/16.
 */
public interface ProductDAO {
    public List<Product> getProducts();

    public List<Product> getProducts(int pageNo, int pageSize);

    public int findProducts(List<Product> list, int[] catagoryID,
                            String keyWord,
                            double lowNormalPrice,
                            double highNormalPrice,
                            double lowMemberPrice,
                            double highMemberPrice,
                            Date startDate,
                            Date endDate,
                            int pageNO,
                            int pageSize
    );

    public List<Product> findProducts(String name);

    public boolean deleteProductByCategoryId(int categoryId);

    public boolean deleteProductById(int[] idArray);

    public boolean updateProduct(Product product);

    public boolean addProduct(Product product);

    public int getProducts(List<Product> products, int pageNo, int pageSize);

    public Product loadByID(int id);

    public List<Product> getLatestProducts(int count);
}
