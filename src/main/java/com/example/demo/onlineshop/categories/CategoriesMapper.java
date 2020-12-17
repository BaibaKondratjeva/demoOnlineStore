package com.example.demo.onlineshop.categories;

import com.example.demo.onlineshop.products.Products;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoriesMapper {

    @Select("select id, name, imageUri from categories")
    List<Categories> findAll();

    @Select("select id, name, imageUri from categories where name = #{name}")
    Categories findByName(String name);

    @Select("select id, name, imageUri from categories where id = #{id}")
    Categories findOne(long id);

    @Options(useGeneratedKeys = true,
            keyProperty = "id",
            keyColumn = "id")
    @Insert("insert into products (name, imageUri) values (#{name}, #{imageUri})")
    void insert(Categories category);

    @Update("update categories set " +
            "name = #{name}, " +
            "imageURI = #{imageUri} " +
            "where id = #{id}")
    boolean update(Categories category);

    @Delete("delete from categories where id = #{id}")
    boolean deleteById(long id);

}
