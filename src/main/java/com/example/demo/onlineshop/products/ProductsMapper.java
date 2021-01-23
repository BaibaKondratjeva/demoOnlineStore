package com.example.demo.onlineshop.products;

import com.example.demo.onlineshop.categories.Categories;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Set;

@Mapper
public interface ProductsMapper {
    @Select("select id, name, description, price, quantity, imageUri from products")
    List<ProductRequest> findAll();
    @Select("select categories.id, categories.name from products\n" +
            "left join products_categories\n" +
            "on products.id = products_categories.product_id\n" +
            "left join categories\n" +
            "on products_categories.category_id = categories.id\n" +
            "where products.id = #{id}")
    List<Categories> findProductCategories (Long productId);
    @Select("select id, name, description, price, quantity, imageUri from products where name like #{name}")
    ProductRequest findByName(String name);

    //    @Select("select id, name, description, price, quantity, imageUri from products where id = #{id}")
    @Select("select products.id, products.name, description, price, quantity, products.imageUri, categories.name from products\n" +
            "left join products_categories\n" +
            "on products.id = products_categories.product_id\n" +
            "left join categories\n" +
            "on products_categories.category_id = categories.id\n" +
            "where products.id = #{id}")
    ProductRequest findOne(Long id);

    @Select("select id, name, description, price, quantity, imageUri from products where id = #{id}")
    Products findProduct (Long id);

    @Select("select id from categories id IN (#{id}, #{id})")
    ProductRequest categoriesValidation(List<Integer> categoryIds);
    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert("insert into products (name, description, price, quantity, imageUri) values (#{name}, #{description}, " +
            "#{price}, #{quantity}, #{imageUri})")
    void create(ProductRequest product);
    @Insert({"<script>" +
            "insert into products_categories (product_id, category_id) values " +
            "<foreach item='categoryId' collection='Categories' open='' separator=',' close=''> " +
            "(#{productId}, #{categoryId}) " +
            "</foreach>" +
            "</script>"})
    void insertProductCategories (Long productId, @Param("Categories") Set<Long> categoryIds);
    @Update("update products set " +
            "name = #{name}, " +
            "description = #{description}, " +
            "price = #{price}, " +
            "quantity = #{quantity}, " +
            "imageURI = #{imageUri} " +
            "where id = #{id}")
    boolean update(ProductRequest product);
    @Update({"<script>" +
            "<foreach item='categoryId' collection='Categoriess' open='' separator=',' close=''> " +
            "update products_categories set " +
            "category_id = #{categoryId} " +
            "where id = #{productId}" +
            "</foreach>" +
            "</script>"})
    boolean updateProductCategory (Long productId, @Param("Categoriess") Set<Long> categoryIds);
    @Delete("delete from products where id = #{id}")
    boolean deleteById(Long id);

    @Select("")
    Products isProductAvailableInStock(Long id, Integer quantity);
}